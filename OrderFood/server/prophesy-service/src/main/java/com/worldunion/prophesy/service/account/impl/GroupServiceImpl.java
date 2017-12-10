package com.worldunion.prophesy.service.account.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worldunion.prophesy.dao.GroupDao;
import com.worldunion.prophesy.dao.GroupResourceDao;
import com.worldunion.prophesy.dao.GroupStaffDao;
import com.worldunion.prophesy.generator.page.Page;
import com.worldunion.prophesy.generator.page.PageList;
import com.worldunion.prophesy.generator.page.Pagination;
import com.worldunion.prophesy.generator.page.Paginator;
import com.worldunion.prophesy.generator.page.PagingCriterion;
import com.worldunion.prophesy.model.account.Group;
import com.worldunion.prophesy.model.account.GroupResource;
import com.worldunion.prophesy.model.account.GroupStaff;
import com.worldunion.prophesy.model.account.Resource;
import com.worldunion.prophesy.service.account.GroupService;
import com.worldunion.prophesy.utils.common.AssertUtil;
import com.worldunion.prophesy.utils.common.exception.BizCoreErrors;
import com.worldunion.prophesy.utils.common.exception.BizCoreException;

@Service
public class GroupServiceImpl   implements GroupService {

	@Autowired
	private GroupDao groupDao;

	@Autowired
	private GroupResourceDao groupResourceDao;
	
	@Autowired
	private GroupStaffDao groupStaffDao;

	@Override
	public List<Group> getMergeGroups(String groupType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", groupType);
		List<Group> list = groupDao.findAllGroups(params);
		return mergeToParent(list);
	}

	@Override
	public Group getGroup(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return groupDao.findByOne(params);
	}

	@Override
	@Transactional
	public void deleteGroups(List<String> ids) {
		if (ids != null && !ids.isEmpty()) {
			Iterator<String> iterator = ids.iterator();
			while (iterator.hasNext()) {
				String id = iterator.next();
				if(StringUtils.isNotEmpty(id)){
					this.groupDao.delete(id);
					this.groupResourceDao.deleteByGroupId(id);
				}
			}
		}
		updateAllLeaf();
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		AssertUtil.notNull(id, BizCoreErrors.illegalArgument.message("GroupId不能为空"));
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("fkGroupId", id);
		List<GroupStaff> groups = groupStaffDao.selectByMap(params);
		if(groups.size()>0){
			throw new BizCoreException(BizCoreErrors.illegalArgument.message("已关联账户不可删除"));
		}
		
		this.groupDao.delete(id);
		this.groupResourceDao.deleteByGroupId(id);

	}

	@Override
	public List<Group> getGroups(Map<String, Object> params) {
		return this.groupDao.findAllGroups(params);
	}

	@Override
	@Transactional
	public void saveOrupateGroup(Group group) {
		
		List<Group> groups = findGroups(group);
    	if(groups.size()>0){
    		throw new BizCoreException(BizCoreErrors.illegalArgument.message("权限组名称已存在"));
    	}
		// 保存Group
		if (StringUtils.isEmpty(group.getId())) {
			final String id = UUID.randomUUID().toString();
			group.setId(id);
			this.groupDao.insert(group);
		} else {
			this.groupResourceDao.deleteByGroupId(group.getId());
			this.groupDao.update(group);
			updateAllLeaf();

		}

		List<Resource> resourcesList = group.getResourcesList();
		if (resourcesList != null && !resourcesList.isEmpty()) {
			Iterator<Resource> iterator = resourcesList.iterator();
			while (iterator.hasNext()) {
				Resource resource = iterator.next();
				GroupResource gr = new GroupResource(UUID.randomUUID().toString());
				gr.setGroup(group);
				gr.setResource(resource);
				this.groupResourceDao.insert(gr);
			}
		}

		// 如果对象父类不为null，将父类的leaf设置成true，表示父类下存在子节点
		if (group.getParent() != null
				&& StringUtils.isNotEmpty(group.getParent().getId())) {
			Group res = new Group(group.getParent().getId());
			res.setLeaf(Boolean.TRUE);
			this.groupDao.updateLeaf(res);
		}
	}

	@Override
	public Pagination<Map<String, Object>> searchByMap(Pagination<Map<String, Object>> pagination, Map<String, Object> params) {
		return groupDao.searchByMap(pagination,params);
	}

	/**
	 * 更新父节点状态
	 */
	private void updateAllLeaf() {
		// 删除后查询所有的 节点状态不正确的数据
		List<Group> findNoChildList = this.groupDao.findNoChildList(null);
		if (findNoChildList != null) {
			for (Group group : findNoChildList) {
				group.setLeaf(Boolean.FALSE);
				this.groupDao.updateLeaf(group);
			}
		}
	}
	
	
	public List<Group> mergeToParent(List<Group> list) {
		List<Group> result = new ArrayList<Group>();

		for (Group r : list) {
			if (r.getParent() == null) {
				Group temp = new Group();
				BeanUtils.copyProperties(r, temp);
				mergeToParent(list, temp);
				result.add(temp);
			}
		}

		return result;
	}
	
	
	/**
	 * 遍历list中的数据,如果数据的父类与parent相等，将数据加入到parent的children中
	 * 
	 * @param list 资源集合
	 * @param parent 父类对象
	 */
	private void mergeToParent(List<Group> list, Group parent) {
		if (!parent.getLeaf()) {
			return ;
		}
		
		parent.setChildren(new ArrayList<Group>());
		parent.setLeaf(false);
		
		for (Group r: list) {
			
			if (StringUtils.equals(r.getParentId(),parent.getId())) {
				Group temp = new Group();
				BeanUtils.copyProperties(r, temp);
				temp.setChildren(null);
				mergeToParent(list,temp);
				parent.getChildren().add(temp);
				parent.setLeaf(true);
			}
			
		}
	}

	@Override
	public PageList<Group> searchByMapPage(PagingCriterion pagingCriterion, Map<String, Object> params) {
		
		
		int count = groupDao.searchByMapPageCount(params);
		int pageSize = pagingCriterion.getPageSize();
		Paginator paginator = new Paginator();
		paginator.setCurrentPage(pagingCriterion.getCurrentPage());
		paginator.setPageSize(pagingCriterion.getPageSize() == 0 ? 20 : pagingCriterion.getPageSize());
		
		PageList<Group> resultList = new PageList<Group>();
		
		if (count != 0) {
			Page page = new Page(pagingCriterion.getStartRow(), pageSize>=20?20:pageSize);
			paginator.setTotalRows(count);//总记录数
			params.put("page", page);
			List<Group> list = groupDao.searchByMapPage(params);
			resultList.setList(list);
		} else {
			paginator.setTotalRows(0);//总记录数
		}
		resultList.setPaginator(paginator);
		
		

		
		return resultList;
	}

	@Override
	public List<Group> findGroups(Group group) {
		return groupDao.findGroups(group);
	}

}
