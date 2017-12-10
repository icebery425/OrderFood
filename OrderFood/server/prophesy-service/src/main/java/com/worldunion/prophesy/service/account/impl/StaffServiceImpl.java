package com.worldunion.prophesy.service.account.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.dao.GroupStaffDao;
import com.worldunion.prophesy.dao.StaffDao;
import com.worldunion.prophesy.generator.page.Page;
import com.worldunion.prophesy.generator.page.PageList;
import com.worldunion.prophesy.generator.page.Pagination;
import com.worldunion.prophesy.generator.page.Paginator;
import com.worldunion.prophesy.generator.page.PagingCriterion;
import com.worldunion.prophesy.model.account.GroupStaff;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.service.account.StaffService;
import com.worldunion.prophesy.utils.common.AssertUtil;
import com.worldunion.prophesy.utils.common.exception.BizCoreErrors;
import com.worldunion.prophesy.utils.common.exception.BizCoreException;

/**
 * Created by starhousexq on 2015/11/21.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private GroupStaffDao groupStaffDAO;

    @Override
    public Staff getStaffByCode(String staffCode) {
        AssertUtil.notNull(staffCode, BizCoreErrors.illegalArgument.message("工号不能为空"));
        Map<String, Object> params = new HashMap<>();
        params.put("staffCode", staffCode);
        return findOneByMap(params);
    }

    @Override
    public Staff getStaffById(Long id) {
    	 Map<String, Object> params = new HashMap<>();
         params.put("staffId",id);
    	
        return findOneByMap(params);
    }

    @Override
    public Pagination<Map<String, Object>> searchByMap(Pagination<Map<String, Object>> pagination, Map<String, Object> params) {
        return staffDao.searchByMap(pagination, params);
    }

    @Override
    public int save(Staff staff) {
        AssertUtil.notNull(staff.getStaffcode(), BizCoreErrors.illegalArgument.message("工号不能为空"));
        AssertUtil.notNull(staff.getStaffname(), BizCoreErrors.illegalArgument.message("人员名称不能为空"));
        Staff staffTemp = getStaffByCode(staff.getStaffcode());

        if(staffTemp==null){
            String password=null;
            if(StringUtils.isBlank(staff.getPassword())){
                password = new SimpleHash("MD5", staff.getStaffcode()).toHex();
            }else{
                password = new SimpleHash("MD5", staff.getPassword()).toHex();
            }

            staff.setPassword(password);
//            staff.setCreatetime(new Date());
            staffDao.insert(staff);
            return 0;
        }else{
//            throw new BizCoreException(BizCoreErrors.illegalArgument.message("工号已经存在"));
        	return 1;
        }

    }

    @Override
    public void deleteById(Long id) {
        AssertUtil.notNull(id, BizCoreErrors.illegalArgument.message("Id不能为空"));
        Staff staff  = new Staff();
        staff.setStaffid(id);
        staff.setState(Integer.valueOf(3));//删除状态
        staffDao.updateBySelective(staff);
    }

    @Override
    public void update(Staff staff) {
        AssertUtil.notNull(staff, BizCoreErrors.illegalArgument.message("实体对象不能为空"));
        AssertUtil.notNull(staff.getStaffid(), BizCoreErrors.illegalArgument.message("Id不能为空"));
        AssertUtil.notNull(staff.getStaffcode(), BizCoreErrors.illegalArgument.message("工号不能为空"));
        AssertUtil.notNull(staff.getStaffname(), BizCoreErrors.illegalArgument.message("名称不能为空"));

        Map<String, Object> params = new HashMap<>();
        params.put("staffCode",staff.getStaffcode());
        params.put("excludeStaffId",staff.getStaffid());
        Integer count =   staffDao.selectCountByMap(params);
        if(count >0){
            throw new BizCoreException(BizCoreErrors.illegalArgument.message("工号"+staff.getStaffcode()+"已经存在"));
        }

        if(StringUtils.isNotBlank(staff.getPassword())){
            staff.setPassword(new SimpleHash("MD5", staff.getPassword()).toHex());
        }else{
            staff.setPassword(null);
        }

        this.staffDao.updateBySelective(staff);

    }

    @Override
    public void updatePassword(Long id, String pwd) {
        AssertUtil.notNull(id, BizCoreErrors.illegalArgument.message("id不能为空"));
        AssertUtil.notNull(pwd, BizCoreErrors.illegalArgument.message("密码不能为空"));
        Staff staff  = new Staff();
        staff.setStaffid(id);
        staff.setPassword(new SimpleHash("MD5", pwd.toCharArray())
                .toString());
        this.staffDao.updateBySelective(staff);
    }

    @Override
    public GroupStaff getStaffGroup(Long id) {
        if(id!=null){
            Map<String, Object> params = new HashMap<>();
            params.put("staffid",id);
           List<GroupStaff> list = groupStaffDAO.selectByMap(params);
            if(list!=null && !list.isEmpty())return  list.get(0);
          return   null;
        }

        return null;
    }

    @Override
    public void insertOrUpdateStaffGroup(GroupStaff staffGroup) {
        if(StringUtils.isNotBlank(staffGroup.getId())){
            this.groupStaffDAO.update(staffGroup);
        }else{
            staffGroup.setId(UUID.randomUUID().toString());
            this.groupStaffDAO.insert(staffGroup);
        }
    }
    
    
    private Staff findOneByMap(Map<String, Object> params){
    	
    	final List<Staff> list= staffDao.selectByMap(params);
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() > 1) {
            throw new TooManyResultsException("[queryMap="+params+"]Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
        } else {
            return null;
        }
    }

	@Override
	public PageList<Staff> searchByMap(Map<String, Object> params, PagingCriterion pagingCriterion) {
		
		int count = staffDao.searchByMapPageCount(params);
		int pageSize = pagingCriterion.getPageSize();
		Paginator paginator = new Paginator();
		paginator.setCurrentPage(pagingCriterion.getCurrentPage());
		paginator.setPageSize(pagingCriterion.getPageSize() == 0 ? 20 : pagingCriterion.getPageSize());
		
		PageList<Staff> resultList = new PageList<Staff>();
		
		if (count != 0) {
			Page page = new Page(pagingCriterion.getStartRow(), pageSize>=20?20:pageSize);
			paginator.setTotalRows(count);//总记录数
			params.put("page", page);
			List<Staff> list = staffDao.searchByMapPage(params);
			resultList.setList(list);
		} else {
			paginator.setTotalRows(0);//总记录数
		}
		resultList.setPaginator(paginator);
	
		return resultList;
	}

}
