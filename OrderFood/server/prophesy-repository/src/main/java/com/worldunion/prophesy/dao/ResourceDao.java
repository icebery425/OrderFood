package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.account.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("resourceDao")
public interface ResourceDao {
	//------------------CRUD--------------------------
	public int insert(Resource resource);
	public int update(Resource resource);
	public int delete(String id);
	public int updateLeaf(Resource resource);
	
	//--------------------search--------------
	/**
	 *  查询父类为1 ，但是没有子节点的数据
	 * @param params
	 * @return
	 */
	public List<Resource> findNoChildList(Map<String, Object> params);
	public List<Resource>  findAllResources(Map<String, Object> params);
	public List<Resource> findUserResources(Map<String, Object> params);
	public Resource findResourceByMap(Map<String, Object> params);
	//-------------others----------------------
	public int getTotalCount(Map<String, Object> params);
	public String selectWeekCode(String startdate);
}