package com.worldunion.prophesy.model.util;

/**
 * Created by 0139933 on 2015/11/24.
 */
public class Constant {
	
    /**
     * 日志类型 (tpm_static_type类型26)
     */
    public static final String LOG_TYPECODE_SYS="01";//系统日志
    public static final String LOG_TYPECODE_BUSI="02";//业务日志
    /**
     * 日志动作 (tpm_static_type类型27)
     */

    public static final String LOG_ACTION_VIEW_MENU="00";//菜单 菜单URL请求（页面）
    public static final String LOG_ACTION_VIEW="01";//查看 页面中的URL请求（请求数据）

    public static final String LOG_ACTION_ADD="02";//新增
    public static final String LOG_ACTION_UPDATE="03";//修改
    public static final String LOG_ACTION_DELETE="04";//删除
    public static final String LOG_ACTION_LOGIN="05";//登录
    public static final String LOG_ACTION_LOGOUT="06";//退出
    public static final String LOG_ACTION_BATCHD="07";//批量删除
    public static final String LOG_ACTION_BATCHU="08";//批量修改
    public static final String LOG_ACTION_BATCHADD="09";//批量新增
    public static final String LOG_ACTION_CHECK="10";//审核
    public static final String LOG_ACTION_CHECK_CANCEL="11";//取消审核
    public static final String LOG_ACTION_REPORT="12";//上报
    public static final String LOG_ACTION_EXPORT="13";//导出







    /**
     * 日志模块（业务模块) (tpm_static_type类型28)
     */
    public static final String LOG_FUNC_LOG="01";//登录
    public static final String LOG_FUNC_LOGOUT="02";//退出
    public static final String LOG_FUNC_INDEX="03";//首页
    public static final String LOG_FUNC_BASE="04";//基础模块
    public static final String LOG_FUNC_APP="05";//bi app


    //首页模块
    public static final String LOG_FUNC_NEWHOUSESALE_INDEX="11";//首页-新房销售分析
    public static final String LOG_FUNC_LONANANA_INDEX="12";//首页-金融放款分析
    public static final String LOG_FUNC_APART_INDEX="13";//首页-公寓房源分析（一整块）
    public static final String LOG_FUNC_AGENT_INDEX="14";//首页-代理经营分析


    //菜单-综合分析
    public static final String LOG_FUNC_TOTAL_TOTALINCOME="21";//综合分析-总体收入分析
    public static final String LOG_FUNC_TOTAL_TOTALPERFORMANCE="22";//综合分析-总体业绩分析
    public static final String LOG_FUNC_TOTAL_INCOMERANK="23";//综合分析-创收排名分析

    //菜单-业务量分析
    public static final String LOG_FUNC_VOLUMN_NEWHOUSESALE="24";//业务量分析-新房销售分析
    public static final String LOG_FUNC_VOLUMN_NEWHOUSERANK="25";//业务量分析-新房排名分析
    public static final String LOG_FUNC_VOLUMN_FINANCIALLOAN="26";//业务量分析-金融放款分析
    public static final String LOG_FUNC_VOLUMN_FINANCIALSALESRANK="27";//业务量分析-金融销售排名分析
    public static final String LOG_FUNC_VOLUMN_APARTMENTHOUSE="28";//业务量分析-公寓房源分析
    public static final String LOG_FUNC_VOLUMN_YDCONVERSIONRATE="29";//业务量分析-云贷转化率

    //菜单-财务运营
    public static final String LOG_FUNC_FINA_CITY_REVENUECOLLECTION="30";//财务运营-创收回款报表-地区财务
    public static final String LOG_FUNC_FINA_COMPANY_REVENUECOLLECTION="31";//财务运营-创收回款报表-集团财务

    //菜单-销售管理
    public static final String LOG_FUNC_SALEMANA_BIGCUSTOMERS_REVENUECOLLECTION="32";//销售管理-大客户创收回款报表

    //菜单-基础管理
    public static final String LOG_FUNC_BASE_CUSTOMERMAINTENANCE="33";//基础管理-客户维护
    public static final String LOG_FUNC_BASE_PROJECTMAINTENANCE="34";//基础管理-项目维护

    //菜单-系统管理
    public static final String LOG_FUNC_SYSTEMMANAGER_USER = "35";//系统管理-用户管理
    public static final String LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP = "36";//系统管理-权限组管理
    public static final String LOG_FUNC_SYSTEMMANAGER_MODIFYPASSWORD = "37";//系统管理-修改密码
    public static final String LOG_FUNC_SYSTEMMANAGER_MENU = "38";//系统管理-菜单资源管理
    public static final String LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION = "39";//系统管理-数据权限管理

    //公寓模块
    //菜单-公寓投资分析
    public static final String LOG_FUNC_APART_INVEST_CITY="40";//公寓-投资-城市
    public static final String LOG_FUNC_APART_INVEST_PROJECT="41";//公寓-投资-项目

    //菜单-公寓运营分析
    public static final String LOG_FUNC_APART_OPERATE_CITY="42";//公寓-运营-城市
    public static final String LOG_FUNC_APART_OPERATE_PROJECT="43";//公寓-运营-项目

    //菜单-公寓签约分析
    public static final String LOG_FUNC_APART_SIGN_CITY="44";//公寓-签约-城市
    public static final String LOG_FUNC_APART_SIGN_PROJECT="45";//公寓-签约-项目

    //菜单-公寓装修分析
    public static final String LOG_FUNC_APART_RENO_CITY="46";//公寓-装修-城市
    public static final String LOG_FUNC_APART_RENO_PROJECT="47";//公寓-装修-项目
    public static final String LOG_FUNC_APART_RENO_FEE_REPORT="48";//公寓-装修费用填报

    //页面-公寓项目明细 （从其他页面链进去）
    public static final String LOG_FUNC_APART_PROJECT_DETAIL="49";//公寓-项目明细

    //菜单-代理经营分析模块
    public static final String LOG_FUNC_AGENT_COMPANY="50";//代理经营-公司
    public static final String LOG_FUNC_AGENT_ORGANIZATION="51";//代理经营-组织
    public static final String LOG_FUNC_AGENT_PROJECT="52";//代理经营-项目

    //菜单-金融风险分析模块
    public static final String LOG_FUNC_LOAN_FORECAST="53";//金融风险分析-资金预测报表
    public static final String LOG_FUNC_LOAN_FORECAST_DETAIL="53";//金融风险分析-资金预测报表明细








    public static final String AGENT_INDEX="index";//代理销售-首页
    public static final String AGENT_COMPANY="company";//代理销售-公司
    public static final String AGENT_ORGANIZATION="organization";//代理销售-部门
    public static final String AGENT_PROJECT="project";//代理销售-项目

    
    
    
    
    

}
