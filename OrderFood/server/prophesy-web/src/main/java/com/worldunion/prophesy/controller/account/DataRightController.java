package com.worldunion.prophesy.controller.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.controller.BaseController;
import com.worldunion.prophesy.model.account.StaffDataright;
import com.worldunion.prophesy.model.base.City;
import com.worldunion.prophesy.model.util.Constant;
import com.worldunion.prophesy.model.util.SystemVariableUtils;
import com.worldunion.prophesy.service.account.GroupService;
import com.worldunion.prophesy.service.account.StaffDatarightService;
import com.worldunion.prophesy.service.account.StaffService;
import com.worldunion.prophesy.service.base.SystemControllerLog;
import com.worldunion.prophesy.utils.common.Contents;
import com.worldunion.prophesy.utils.common.error.Result;

/**
 *
 * 首页
 * 
 */
@Controller
@RequestMapping("/account/dataright")
public class DataRightController extends BaseController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private StaffDatarightService staffDataRightService;

	
	/*private static int TYPE_CITY = 1;
	private static int TYPE_SERVICE = 5;
	private static int TYPE_COMPANY = 6;
	private static int TYPE_REVENUE = 3;
	private static int TYPE_PDEVCOM = 8;
	private static int TYPE_REPORTAREA = 9;*/
	
	
	/**
     * 系统管理：数据权限管理
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/list")
    @SystemControllerLog(description = "系统管理：数据权限管理",logTypeCode=Constant.LOG_TYPECODE_BUSI,logActionCode=Constant.LOG_ACTION_VIEW_MENU,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="")
    public String list(ModelMap modelMap) {
        return "account/dataright/list";
    }

   
    
    
    private Result baseSave(String ids, int staffid, int type){
    	Map<String, Object>params = new HashMap<String, Object>();
    	params.put("datarighttypeid", type);
    	params.put("ids", ids);
    	params.put("staffid", staffid);
    	params.put("enterid", SystemVariableUtils.getSessionVariable().getStaff().getStaffid());
    	int code = staffDataRightService.updateStaffDataright(params);
    	if(code ==0){
        	return Result.buildOkResult();
        } else {
        	return Result.buildErrorResult();
        }
    }
    
    @RequestMapping("/city/save")
    @SystemControllerLog(description = "数据权限管理（保存城市数据信息）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @ResponseBody
    public Result citySave(String ids, int staffid) {
    	return baseSave(ids, staffid, Contents.TYPE_CITY);
    }
    
    /**
     * 业务线数据权限管理页面
     *
     * @param modelMap
     * @return
     */
    @SystemControllerLog(description = "数据权限管理（业务线数据信息列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @RequestMapping("/service")
    public String toService(Long id, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", id);
		params.put("datarighttypeid", Contents.TYPE_SERVICE);
		List<StaffDataright>staffDatarights = staffDataRightService.queryServiceright(params);
		modelMap.put("datas",staffDatarights);
        return "account/dataright/service";
    }
    
    @RequestMapping("/service/save")
    @SystemControllerLog(description = "数据权限管理（保存业务线数据信息）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @ResponseBody
    public Result serviceSave(String ids, int staffid) {
    	return baseSave(ids, staffid, Contents.TYPE_SERVICE);
    }
    
    /**
     * 地区公司数据权限管理页面
     *
     * @param modelMap
     * @return
     */
    @SystemControllerLog(description = "数据权限管理（地区公司数据信息列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @RequestMapping("/company")
    public String toCompany(Long id, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", id);
		params.put("datarighttypeid", Contents.TYPE_COMPANY);
		List<StaffDataright>staffDatarights = staffDataRightService.queryCompanyright(params);
		modelMap.put("datas",staffDatarights);
        return "account/dataright/company";
    }

    @RequestMapping("/company/save")
    @SystemControllerLog(description = "数据权限管理（保存地区公司数据信息）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @ResponseBody
    public Result companySave(String ids, int staffid) {
    	return baseSave(ids, staffid, Contents.TYPE_COMPANY);
    }
    
    /**
     * 创收数据权限管理页面
     *
     * @param modelMap
     * @return
     */
    @SystemControllerLog(description = "数据权限管理（创收数据信息列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @RequestMapping("/revenue")
    public String toRevenue(Long id, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", id);
		params.put("datarighttypeid", Contents.TYPE_REVENUE);
		StaffDataright staffDatarights = staffDataRightService.queryStaffRevenueright(params);
		if(null != staffDatarights && null != staffDatarights.getDataid()){
			modelMap.put("revenuedata","0"+staffDatarights.getDataid());
		}
		List<Map<String, Object>> revenueList = staffDataRightService.queryRevenueList();
		modelMap.put("revenueList",revenueList);
        return "account/dataright/revenue";
    }
    
    @RequestMapping("/revenue/save")
    @SystemControllerLog(description = "数据权限管理（保存创收数据信息）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @ResponseBody
    public Result revenueSave(String ids, int staffid) {
    	return baseSave(ids, staffid, Contents.TYPE_REVENUE);
    }
    
    /**
     * 父开发商权限管理页面
     *
     * @param modelMap
     * @return
     */
    @SystemControllerLog(description = "数据权限管理（父开发商信息列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @RequestMapping("/pardevcompany")
    public String toPardevcompany(Long id, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", id);
		params.put("datarighttypeid", Contents.TYPE_PDEVCOM);
		List<StaffDataright>staffDatarights = staffDataRightService.queryPDComRight(params);
		modelMap.put("datas",staffDatarights);
        return "account/dataright/pardevcompany";
    }
    @RequestMapping("/pardevcompany/save")
    @SystemControllerLog(description = "数据权限管理（保存父开发商信息）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @ResponseBody
    public Result pardevcompanySave(String ids, int staffid) {
    	return baseSave(ids, staffid, Contents.TYPE_PDEVCOM);
    }
    /**
     * 上报区域权限管理页面
     *
     * @param modelMap
     * @return
     */
    @SystemControllerLog(description = "数据权限管理（上报区域信息列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @RequestMapping("/reportArea")
    public String toReportArea(Long id, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", id);
		params.put("datarighttypeid", Contents.TYPE_REPORTAREA);
		List<StaffDataright>staffDatarights = staffDataRightService.queryReportAreaRight(params);
		modelMap.put("datas",staffDatarights);
        return "account/dataright/reportArea";
    }
    @RequestMapping("/reportArea/save")
    @SystemControllerLog(description = "数据权限管理（保存上报区域信息）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_DATAPERMISSION,tableName="tsm_staff_dataright")
    @ResponseBody
    public Result reportAreaSave(String ids, int staffid) {
    	return baseSave(ids, staffid, Contents.TYPE_REPORTAREA);
    }
}
