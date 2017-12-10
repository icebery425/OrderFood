package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.account.GroupResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("groupResourceDao")
public interface GroupResourceDao {
	public List<GroupResource> findAll(Map<String, Object> params);
	public int insert(GroupResource groupResource);
	public int delete(String id);
	public int deleteByGroupId(String groupId);
}