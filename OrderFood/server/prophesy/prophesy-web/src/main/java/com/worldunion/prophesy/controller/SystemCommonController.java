package com.worldunion.prophesy.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.util.Constant;
import com.worldunion.prophesy.model.util.SystemVariableUtils;
import com.worldunion.prophesy.service.account.StaffService;
import com.worldunion.prophesy.service.base.ServiceException;
import com.worldunion.prophesy.service.base.SystemControllerLog;
import com.worldunion.prophesy.utils.common.error.Result;


/**
 * 系统安全控制器
 *
 */
@Controller
public class SystemCommonController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StaffService staffService;



	/**
	 * 登录C，返回登录页面。当C发现当前用户已经登录名且认真后，会自动跳转到index页面
	 * @return String
	 */
	@RequestMapping("/login")
	public String login(ModelMap model) {
		if (!SystemVariableUtils.isAuthenticated()) {
			return "login";
		}else{
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			return "redirect:/logout";
		}


		//return "redirect:/index";
	}
	@RequestMapping("/syslogout")
	@SystemControllerLog(description = "退出",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_LOGOUT,funcCode=Constant.LOG_FUNC_LOGOUT,tableName="")
	public String sysLogOut(ModelMap model) {
			return "redirect:/logout";
	}

	/**
	 * 当前用户修改密码C.修改成功将会注销用户，重新登录
	 */
	@RequestMapping("/change-password")
	@SystemControllerLog(description = "修改密码",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_UPDATE,funcCode=Constant.LOG_FUNC_BASE,tableName="tsm_staff")
	@ResponseBody
	public Result changePassword(String oldPassword, String password) {

		Staff  staff = SystemVariableUtils.getSessionVariable().getStaff();

//		oldPassword = new SimpleHash("MD5", oldPassword.toCharArray())
//				.toString();

		if (!staff.getPassword().equals(oldPassword)) {
			throw new ServiceException("旧密码不正确.");
		}

		staffService.updatePassword(staff.getStaffid(), password);

		return Result.buildOkResult();

	}

	
	
	@RequestMapping("/profile")
	public String profile(ModelMap model){
		model.put("user", SystemVariableUtils.getSessionVariable().getStaff());
		return "account/profile";
	}




	@RequestMapping("/unauthorized")
	public String unauthorized(ModelMap model){
		return "common/unauthorized";
	}
	

	
	
}
