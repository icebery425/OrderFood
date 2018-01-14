package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.account.GroupStaff;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("groupStaffDao")
public interface GroupStaffDao {
	 List<GroupStaff> selectByMap(Map<String,Object> params);
    void insert(GroupStaff staffGroup);
    void update(GroupStaff staffGroup);
    void delete(GroupStaff staffGroup);
}