package com.worldunion.prophesy.service.account;



import java.util.List;
import java.util.Map;

import com.worldunion.prophesy.model.account.Resource;

public interface ResourceService   {

	public List<Resource> getStaffResources(Long staffId);
	public List<Resource> getResources();
	public List<Resource> getResources(List<String> ids);
	public List<Resource> mergeResourcesToParent(List<Resource> list, String resourceType);
	public List<Resource> getMergeResources();
	public Resource getResource(String id);
	public List<Resource> getIgnoreResources(String... ignoreIdValue) ;
	public void saveOrUpdateResource(Resource resource);
	public int getTotalCount(Map<String, Object> params);
	
	/**
	 *  查询父类为1 ，但是没有子节点的数据
	 * @param params
	 * @return
	 */
	public List<Resource> findNoChildList(Map<String, Object> params);
	/**
	 * 删除多个
	 * @param ids
	 */
	public void deleteResources(String ids);


	/**
	 * 获取选择的Resource
	 * @param groupId
	 * @return
	 */
	public List<Map<String,Object>> getSelectedTreeResource(String groupId);

	public List<Map<String,Object>> getTreeResource();
	
	
	/**
	 * 日期计算
	 */
	public Map<String, Object> getdateParams(String datetype);
	public String getBeforeWeek(int num);
	public String getSeqWeek();
	public String getDefaultDateParams(String datetype);
	
}
