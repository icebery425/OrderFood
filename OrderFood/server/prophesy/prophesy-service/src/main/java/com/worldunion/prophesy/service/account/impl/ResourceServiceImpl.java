package com.worldunion.prophesy.service.account.impl;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worldunion.prophesy.dao.GroupResourceDao;
import com.worldunion.prophesy.dao.ResourceDao;
import com.worldunion.prophesy.model.account.GroupResource;
import com.worldunion.prophesy.model.account.Resource;
import com.worldunion.prophesy.service.account.ResourceService;
import com.worldunion.prophesy.utils.common.CollectionUtil;
import com.worldunion.prophesy.utils.common.DateUtil;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private GroupResourceDao groupResourceDao;


    @Override
    public List<Resource> getStaffResources(Long userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("staffId", userId);
        return resourceDao.findUserResources(params);
    }

    /**
     * 遍历list中的数据,如果数据的父类与parent相等，将数据加入到parent的children中
     *
     * @param list       资源集合
     * @param parent     父类对象
     * @param ignoreType 不需要加入到parent的资源类型
     */
    private void mergeToParent(List<Resource> list, Resource parent, String ignoreType) {
        if (!parent.getLeaf()) {
            return;
        }

        parent.setChildren(new ArrayList<Resource>());
        parent.setLeaf(false);

        for (Resource r : list) {
        	
        	if("系统管理".equals(r.getName())){
        		System.out.println(r.getName());
        	}
            //这是一个递归过程，如果当前遍历的r资源的parentId等于parent父类对象的id，将会在次递归r对象。通过遍历list是否也存在r对象的子级。
            if (r!=null && (ignoreType == null || !StringUtils.equals(r.getType(), ignoreType)) && StringUtils.equals(r.getParentId(), parent.getId())) {
                Resource temp = new Resource();
                BeanUtils.copyProperties(r, temp);
                temp.setChildren(null);
                mergeToParent(list, temp, ignoreType);
                parent.getChildren().add(temp);
                parent.setLeaf(true);
            }

        }
    }

    @Override
    public List<Resource> getResources() {
        return resourceDao.findAllResources(null);
    }

    @Override
    public List<Resource> getMergeResources() {
        List<Resource> result = resourceDao.findAllResources(null);
        return mergeResourcesToParent(result, null);
    }


    public List<Resource> mergeResourcesToParent(List<Resource> list, String ignoreType) {
        
        List<Resource> result = new ArrayList<Resource>();
		for (Resource r : list) {
			if(r!=null){
				if("系统管理".equals(r.getName())){
					System.out.println(r.getName());
				}
				if (r.getParent() == null&& (ignoreType == null || !StringUtils.equals(ignoreType,r.getType()))) {
					Resource temp = new Resource();
					BeanUtils.copyProperties(r, temp);
					mergeToParent(list, temp, ignoreType);
					result.add(temp);
				}
			}
		
		}

		return result;
        
    }


    @Override
    public Resource getResource(String id) {

        if (StringUtils.isEmpty(id)) return null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return resourceDao.findResourceByMap(params);
    }


    @Override
    public List<Resource> getResources(List<String> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", ids);
        return resourceDao.findAllResources(params);
    }


    @Override
    public List<Resource> getIgnoreResources(String... ignoreIdValue) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nids", ignoreIdValue);
        return resourceDao.findAllResources(params);
    }


    @Override
    @Transactional
    public void saveOrUpdateResource(Resource resource) {
        if (StringUtils.isNotEmpty(resource.getId())) {
            resourceDao.update(resource);
            updateAllLeaf();
        } else {
            final String id = UUID.randomUUID().toString();
            resource.setId(id);
            if (resource.getSort() == null) {
                resource.setSort(resourceDao.getTotalCount(null) + 1);
            }
            resourceDao.insert(resource);
        }
        // 如果对象父类不为null，将父类的leaf设置成true，表示父类下存在子节点
        if (resource.getParent() != null && StringUtils.isNotEmpty(resource.getParent().getId())) {
            Resource res = new Resource(resource.getParent().getId());
            res.setLeaf(Boolean.TRUE);
            resourceDao.updateLeaf(res);
        }
    }


    @Override
    public int getTotalCount(Map<String, Object> params) {
        return resourceDao.getTotalCount(params);
    }


    @Override
    public List<Resource> findNoChildList(Map<String, Object> params) {
        return resourceDao.findNoChildList(null);
    }


    @Override
    @Transactional
    public void deleteResources(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            String[] arr = ids.split(",");
            for (String id : arr) {
                resourceDao.delete(id);
            }
        }
        updateAllLeaf();
    }

    @Override
    public List<Map<String, Object>> getSelectedTreeResource(String groupId) {
        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
        List<Resource> list = this.getResources();

        if (StringUtils.isEmpty(groupId)) {
            if (list != null && !list.isEmpty()) {
                for (Resource resource : list) {
                    String resouceId = resource.getId();
                    Map<String, Object> dataMap = new HashMap<String, Object>();
                    dataMap.put("id", resouceId);
                    dataMap.put("pId", resource.getParentId());
                    dataMap.put("name", resource.getName());
                    treeList.add(dataMap);
                }
            }
        } else {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("groupId", groupId);
            List<GroupResource> groupResourceList = this.groupResourceDao.findAll(params);
            if (list != null && !list.isEmpty()) {
                for (Resource resource : list) {
                    String resouceId = resource.getId();
                    boolean isChecked = this.isExistResouce(resouceId, groupResourceList);
                    Map<String, Object> dataMap = new HashMap<String, Object>();
                    dataMap.put("id", resouceId);
                    dataMap.put("pId", resource.getParentId());
                    dataMap.put("name", resource.getName());
                    dataMap.put("checked", isChecked);
                    treeList.add(dataMap);
                }
            }

        }

        return treeList;
    }

    @Override
    public List<Map<String, Object>> getTreeResource() {
        List<Resource> list = this.getResources();
        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
        if (list == null || list.isEmpty()) return null;
        for (Resource resource : list) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("id", resource.getId());
            dataMap.put("pId", resource.getParentId());


            dataMap.put("name", resource.getName());
            dataMap.put("type", resource.getType());
            treeList.add(dataMap);
        }
        return treeList;
    }


    private boolean isExistResouce(String resourceId, List<GroupResource> groupResourceList) {
        boolean flag = false;

        if (groupResourceList == null || groupResourceList.isEmpty() || StringUtils.isEmpty(resourceId)) return false;
        for (GroupResource groupResource : groupResourceList) {

            if (StringUtils.equals(resourceId, groupResource.getResource().getId())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 更新父节点状态
     */
    private void updateAllLeaf() {
        //删除后查询所有的 节点状态不正确的数据
        List<Resource> findNoChildList = resourceDao.findNoChildList(null);
        if (findNoChildList != null) {
            for (Resource resource : findNoChildList) {
                resource.setLeaf(Boolean.FALSE);
                resourceDao.updateLeaf(resource);
            }
        }
    }
    
    

    public String getBeforeWeek(int num){
		String beforeDate = DateUtil.getBeforeday(num, "yyyyMMdd");
		String week = resourceDao.selectWeekCode(beforeDate);
		return week;
	}
    public String getSeqWeek() {
    	String nowDate = DateUtil.format(new Date(), "yyyyMMdd");
		String week = resourceDao.selectWeekCode(nowDate);
		return week;
	}

    public Map<String, Object> getdateParams(String datetype){
		String startdate = null;
		String enddate = null;
		Map<String,Object> params = new HashMap<String, Object>();

		switch (datetype){
		case "YEAR":
			startdate = "2007";
			enddate = DateUtil.format(new Date(), "yyyy");
			break;
		case "MONTH":
			startdate = "2007-01";
			enddate = DateUtil.format(new Date(), "yyyy-MM");
			break;
		case "WEEK":
			startdate = getBeforeWeek(-365);
			enddate = getSeqWeek();
			break;
		case "DAY":
			startdate = DateUtil.getBeforeday(-366, "yyyy-MM-dd");
			enddate = DateUtil.getBeforeday(-1, "yyyy-MM-dd");
			break;
		}
		params.put("startdate", startdate);
		params.put("enddate", enddate);
		return params;
	}
	
	/**
	 * 获取默认展示按年按月按周排名的数据的开始时间
	 * @param datetype
	 * @return
	 */
	public String getDefaultDateParams(String datetype){
		String startdate = null;

		switch (datetype){
		case "YEAR":
			startdate = DateUtil.getLastYear(-1);
			break;
		case "MONTH":
			startdate = DateUtil.getLastDate(new Date(), -6);
			break;
		case "WEEK":
			startdate = getBeforeWeek(-30);
			break;
		case "DAY":
			startdate = DateUtil.getBeforeday(-366, "yyyy-MM-dd");
			break;
		}
		
		return startdate;
	}
}
