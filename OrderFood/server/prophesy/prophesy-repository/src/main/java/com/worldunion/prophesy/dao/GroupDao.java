package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.generator.page.Pagination;
import com.worldunion.prophesy.model.account.Group;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("groupDao")
public interface GroupDao {
	public int insert(Group group);
	public int delete(String id);
	public int update(Group group);
	public void updateLeaf(Group res);
	
	//===================search-==================
	public List<Group> findAllGroups(Map<String, Object> params);
	public List<Group> findNoChildList(Map<String, Object> params);
	public Group findByOne(Map<String, Object> params);
	public int searchByMapPageCount(Map<String, Object> params);
	public List<Group> searchByMapPage(Map<String, Object> params);
	public List<Group> findGroups(Group group);
	public Pagination<Map<String, Object>> searchByMap(Pagination<Map<String, Object>> pagination, Map<String, Object> params);
}
