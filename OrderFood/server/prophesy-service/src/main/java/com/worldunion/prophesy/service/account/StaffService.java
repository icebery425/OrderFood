package com.worldunion.prophesy.service.account;


import java.util.Map;

import com.worldunion.prophesy.generator.page.PageList;
import com.worldunion.prophesy.generator.page.Pagination;
import com.worldunion.prophesy.generator.page.PagingCriterion;
import com.worldunion.prophesy.model.account.GroupStaff;
import com.worldunion.prophesy.model.account.Staff;

/**
 * Created by starhousexq on 2015/11/21.
 */
public interface StaffService {
    Staff getStaffByCode(String staffCode);

    Staff getStaffById(Long id);

    Pagination<Map<String, Object>> searchByMap(Pagination<Map<String, Object>> pagination, Map<String, Object> params);

    int save(Staff staff);

    /**
     * 修改状态
     *
     * @param id
     */
    void deleteById(Long id);

    void  update(Staff staff);

    void  updatePassword(Long id,String pwd);

    GroupStaff getStaffGroup(Long id);

    void insertOrUpdateStaffGroup(GroupStaff staffGroup);

    PageList<Staff> searchByMap(Map<String, Object> params, PagingCriterion pagingCriterion);

    
}
