package com.worldunion.prophesy.service.base;

import javax.servlet.http.HttpServletRequest;

import com.worldunion.prophesy.model.Log;

import java.util.List;
import java.util.Map;


public interface LogService {
	void add(Log log,HttpServletRequest request);
	void add(Log log);
	void addApp(Log log);




	/**
	 * 按天统计当天每个小时的pv（访问量）,uv（访客数） 查询当前和前一天的数据
	 * 最近7天/近1个月/近一年 按天统计pv（访问量),uv（访客数）
	 * 入参时间格式 20170901
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryPVUVEchartsByDay(Map<String,Object> map);


	/**
	 * 查询总数
	 * 入参时间格式 20170901
	 * @param map
	 * @return
	 */
	int queryPVUVTableDataCount(Map<String,Object> map);

	/**
	 * 分页查询
	 * 入参时间格式 20170901
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryPVUVTableData(Map<String,Object> map);


	/**
	 * 查询菜单访问列表总条数 分页用
	 * 入参时间格式 20170901
	 * @param map
	 * @return
	 */
	int queryMenuPVByDateCount(Map<String,Object> map);

	/**
	 * 分页查询
	 * 入参时间格式 20170901
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryMenuPVByDate(Map<String,Object> map);

	/**
	 * 查询单个菜单里所有模块 访问列表总条数 分页用
	 * 入参时间格式 20170912
	 * @param map
	 * @return
	 */
	int queryModelPVByMenuCount(Map<String,Object> map);

	/**
	 * 单个菜单里所有模块  分页查询
	 * 入参时间格式 20170912
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryModelPVByMenuDate(Map<String,Object> map);


	/**
	 * 从日志里查询访问过的菜单列表
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryLogMenuList(Map<String,Object> map);

	/**
	 * 查询日志访问明细 访问列表总条数 分页用
	 * 支持条件： 开始时间，结束时间，员工名，工号，菜单
	 * 入参时间格式 20170912
	 * @param map
	 * @return
	 */
	int queryLogPVDetailCount(Map<String,Object> map);

	/**
	 * 查询访问明细  分页查询
	 * 支持条件： 开始时间，结束时间，员工名，工号，菜单
	 * 入参时间格式 20170912
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryLogPVDetail(Map<String,Object> map);

}
