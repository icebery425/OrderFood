package com.worldunion.prophesy.controller.account;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.controller.BaseController;
import com.worldunion.prophesy.generator.page.PageList;
import com.worldunion.prophesy.generator.page.PagingCriterion;
import com.worldunion.prophesy.model.account.GroupStaff;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.util.Constant;
import com.worldunion.prophesy.service.account.GroupService;
import com.worldunion.prophesy.service.account.StaffDatarightService;
import com.worldunion.prophesy.service.account.StaffService;
import com.worldunion.prophesy.service.base.SystemControllerLog;
import com.worldunion.prophesy.utils.common.error.Result;

/**
 *
 * 首页
 * 
 */
@Controller
@RequestMapping("/account/staff")
public class StaffController extends BaseController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private StaffDatarightService staffDataRightService;
//	@Autowired
//	StaticTypeService staticTypeService;
    
	
	/**
     * 系统管理：用户管理
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/list")
    @SystemControllerLog(description = "系统管理：用户管理",logTypeCode=Constant.LOG_TYPECODE_BUSI,logActionCode=Constant.LOG_ACTION_VIEW_MENU,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_USER,tableName="")
    public String list(ModelMap modelMap) {
        return "account/staff/list";
    }

    /**
     * 系统管理：修改密码
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/password")
    @SystemControllerLog(description = "系统管理：修改密码",logTypeCode=Constant.LOG_TYPECODE_BUSI,logActionCode=Constant.LOG_ACTION_VIEW_MENU,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_MODIFYPASSWORD,tableName="")
    public String password(ModelMap modelMap) {
//    	modelMap.put("Session", SystemVariableUtils.getSessionVariable());
        return "account/staff/password";
    }

    /**
     * 人员管理JSON数据
     *
     * @return
     */
    @RequestMapping("/list/data")
    @SystemControllerLog(description = "用户管理（帐号列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_USER,tableName="tsm_staff")
    @ResponseBody
    public PageList<Staff> listData() {
        Map<String, Object> params = getQueryParams();
//        params.put("pageSize", params.get("rows"));
//        params.put("currentPage", params.get("page"));
        PagingCriterion pagingCriterion = new PagingCriterion();
        pagingCriterion.setPageSize(Integer.valueOf(params.get("rows")+""));
        pagingCriterion.setCurrentPage(Integer.valueOf(params.get("page")+""));
        
        PageList<Staff> result = this.staffService.searchByMap(params, pagingCriterion);
        result.getPaginator().setPages();
        
        return result;
    }


    /**
     * 新增
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/add")
    public String addView(ModelMap modelMap) {
        return "account/staff/add";
    }


    @RequestMapping("/add/save")
    @SystemControllerLog(description = "用户管理（新增帐号）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_USER,tableName="tsm_staff")
    @ResponseBody
    public Result doAdd(Staff staff) {
        int code = this.staffService.save(staff);
        if(code ==0){
        	return Result.buildOkResult();
        } else {
        	return Result.buildErrorResult();
        }
    }


    /**
     * 编辑
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/edit")
    public String editView(ModelMap modelMap, Long id) {
        modelMap.put("entity", this.staffService.getStaffById(id));
        return "account/staff/edit";
    }


    @RequestMapping("/edit/save")
    @SystemControllerLog(description = "用户管理（编辑帐号）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_UPDATE,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_USER,tableName="tsm_staff")
    @ResponseBody
    public Result doEdit(Staff staff) {

        this.staffService.update(staff);

        return Result.buildOkResult();
    }


    @RequestMapping("/delete")
    @SystemControllerLog(description = "用户管理（删除帐号信息）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_DELETE,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_USER,tableName="tsm_staff")
    @ResponseBody
    public Result delete(Long id) {
        this.staffService.deleteById(id);
        return Result.buildOkResult();
    }

    @RequestMapping("/list/role")
    public String role(Long id, ModelMap modelMap) {
        modelMap.put("entity", this.staffService.getStaffById(id));
        modelMap.put("staffGroup", this.staffService.getStaffGroup(id));
        modelMap.put("groupList", groupService.getGroups(null));
        return "account/staff/role";
    }


    @RequestMapping("/list/role/save")
    @ResponseBody
    public Result saveRole(GroupStaff staffGroup, ModelMap modelMap) {
        this.staffService.insertOrUpdateStaffGroup(staffGroup);
        return Result.buildOkResult();
    }
}
