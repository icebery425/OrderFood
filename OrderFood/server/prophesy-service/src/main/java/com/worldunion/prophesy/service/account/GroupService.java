package com.worldunion.prophesy.service.account;


import com.worldunion.prophesy.generator.page.PageList;
import com.worldunion.prophesy.generator.page.Pagination;
import com.worldunion.prophesy.generator.page.PagingCriterion;
import com.worldunion.prophesy.model.account.Group;

import java.util.List;
import java.util.Map;

public interface GroupService  {

	public List<Group> getMergeGroups(String groupType);
	public Group getGroup(String id);
	public void deleteGroups(List<String> ids);
	public void deleteById(String id);
	public List<Group> getGroups(Map<String, Object> params) ;
	public List<Group> findGroups(Group group);
	public void saveOrupateGroup(Group group);
	public Pagination<Map<String, Object>> searchByMap(Pagination<Map<String, Object>> pagination, Map<String, Object> params);
	public PageList<Group> searchByMapPage(PagingCriterion pagingCriterion, Map<String, Object> params);




}
