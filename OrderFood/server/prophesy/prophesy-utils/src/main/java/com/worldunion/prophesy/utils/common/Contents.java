package com.worldunion.prophesy.utils.common;

import com.worldunion.prophesy.utils.properties.PropertyPlaceholder;


public class Contents {
	
	/**
	 * 客户主数据-代理ERP         
	 */
	public final static Integer SOURCEID_ERP = 208;
	
	/**
	 * 客户主数据-房联宝                  
	 */
	public final static Integer SOURCEID_FLB = 207;
	
	/**
	 * 客户主数据-房联宝(集房集客)       
	 */
	public final static Integer SOURCEID_FLB_JFJK = 281;
	
	/**
	 * 客户主数据-公寓      
	 */
	public final static Integer SOURCEID_APARTMENT = 206;
	
	/**
	 * 客户主数据-二手房  
	 */
	public final static Integer SOURCEID_SECONDEHAND = 210;
	
	/**
	 * 客户主数据-金融云贷 
	 */
	public final static Integer SOURCEID_JRYD = 212;
	
	/**
	 * 客户主数据-金融集金
	 */
	public final static Integer SOURCEID_JRJJ = 211;

	/**
	 * 客户主数据-装修      
	 */
	public final static Integer SOURCEID_ZX = 213;
	
	
//	public final static  String CAS_URL = "http://auth.worldunion.com.cn/wu-cas-web/";
//	public final static  String  CAS_URL = "http://192.168.11.98:8686/wu-cas-web/";
	public final static  String  CAS_URL = PropertyPlaceholder.getProperty("CAS_URL");

	/**
	 * cookies中存当前用户code的变量名
	 */
	public final static String COOKIE_USERCODE = "biUserCode";
	
	/**
	 * cache中获取staff信息的key 格式：usercode_staff，usercode为变量
	 */
	public final static String CACHE_USERINFO = "_staff";
	
	/**
	 * cache中获取cityList信息的key 格式：usercode_cityList，usercode为变量
	 */
	public final static String CACHE_CITY = "_cityList";
	
	/**
	 * cache中获取_roleList信息的key 格式：usercode_roleList，usercode为变量
	 */
	public final static String CACHE_ROLE = "_roleList";
	
	/**
	 * cache中获取serviceTypeList信息的key 格式：usercode_servTypeList，usercode为变量
	 */
	public final static String CACHE_SERVICE = "_servTypeList";
	
	/**
	 * cache中获取subCompanyList信息的key 格式：usercode_subCompList，usercode为变量
	 */
	public final static String CACHE_COMPANY = "_subCompList";
	
	
	/**
	 * 创收权限类型-线总（默认线总）
	 */
	public final static Integer ROLE_TYPE_01 = 1;
	
	
	/**
	 * 创收权限类型-地总
	 */
	public final static Integer ROLE_TYPE_02 = 2;


	/**
	 * 日报
	 */
	public final static String EXCEL_EXPORT_DAILY = "daily";
	/**
	 * 合并报表
	 */
	public final static String EXCEL_EXPORT_MERGE = "merge";

	/**
	 * 集团财务-创收回款报表-日报
	 */
	public final static String INCOME_RECEIVED_PAYMENTS_DAY = "income_received_payments_day.xlsx";
	/**
	 * 集团财务-创收回款报表-月报
	 */
	public final static String INCOME_RECEIVED_PAYMENTS_MONTH = "income_received_payments_month.xlsx";
	/**
	 * 集团财务-创收回款报表-年报
	 */
	public final static String INCOME_RECEIVED_PAYMENTS_YEAR = "income_received_payments_year.xlsx";
	/**
	 * 集团财务-创收回款报表-日报加合并报表
	 */
	public final static String INCOME_RECEIVED_PAYMENTS_DAY_MERGE = "income_received_payments_day_merge.xlsx";
	/**
	 * 集团财务-创收回款报表-合并报表
	 */
	public final static String INCOME_RECEIVED_PAYMENTS_MERGE = "income_received_payments_merge.xlsx";
	/**
	 * 销售管理-创收回款报表-日报
	 */
	public final static String SALES_MANAGEMENT_DAY = "sales_management_day.xlsx";
	/**
	 * 销售管理-创收回款报表-月报
	 */
	public final static String SALES_MANAGEMENT_MONTH = "sales_management_month.xlsx";
	/**
	 * 销售管理-创收回款报表-年报
	 */
	public final static String SALES_MANAGEMENT_YEAR = "sales_management_year.xlsx";
	/**
	 * 地区财务-创收回款报表-日报
	 */
	public final static String AREAREVE_DAY = "areareve-day.xlsx";
	/**
	 * 地区财务-创收回款报表-年报
	 */
	public final static String AREAREVE_YEAR = "areareve-year.xlsx";
	/**
	 * 装修费用填报
	 */
	public final static String APART_RENOFEE = "apart-renofee.xlsx";
	/**
	 * 装修费用填报明细
	 */
	public final static String APART_RENOFEEDEATAIL = "apart-renofeedetail.xlsx";
	/**
	 * 销售分析-公司报表-周报
	 */
	public final static String AGENT_COMP_WEEK_DATA = "agent_comp_week_data.xlsx";
	
	/**
	 * 销售分析-公司报表-月报
	 */
	public final static String AGENT_COMP_MONTH_DATA = "agent_comp_month_data.xlsx";
	
	/**
	 * 销售分析-公司报表-年报
	 */
	public final static String AGENT_COMP_YEAR_DATA = "agent_comp_year_data.xlsx";
	
	/**
	 * 销售分析-组织报表-周报
	 */
	public final static String AGENT_ORGA_WEEK_DATA = "agent_orga_week_data.xlsx";
	
	/**
	 * 销售分析-组织报表-月报
	 */
	public final static String AGENT_ORGA_MONTH_DATA = "agent_orga_month_data.xlsx";
	
	/**
	 * 销售分析-组织报表-年报
	 */
	public final static String AGENT_ORGA_YEAR_DATA = "agent_orga_year_data.xlsx";
	/**
	 * 销售分析-项目报表-周报
	 */
	public final static String AGENT_PROJ_WEEK_DATA = "agent_proj_week_data.xlsx";
	
	/**
	 * 销售分析-项目报表-月报
	 */
	public final static String AGENT_PROJ_MONTH_DATA = "agent_proj_month_data.xlsx";
	
	/**
	 * 销售分析-项目报表-年报
	 */
	public final static String AGENT_PROJ_YEAR_DATA = "agent_proj_year_data.xlsx";
	
	
	/**
	 * 数据权限类型
	 */
	public final static int TYPE_CITY = 1;	//城市权限
	public final static int TYPE_SERVICE = 5;	//业务线权限
	public final static int TYPE_COMPANY = 6;	//地区公司权限
	public final static int TYPE_REVENUE = 3;	//创收数据权限
	public final static int TYPE_PDEVCOM = 8;	//父开发商权限
	public final static int TYPE_REPORTAREA = 9;	//上报区域权限



	public final static String TABLEAU_USERNAME = "huangminfa";

	public final static String TABLEAU_SERVER_IP = "192.168.10.226";


}
