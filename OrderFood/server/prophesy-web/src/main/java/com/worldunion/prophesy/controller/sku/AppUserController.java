package com.worldunion.prophesy.controller.sku;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.controller.BaseController;
import com.worldunion.prophesy.model.sku.Message;
import com.worldunion.prophesy.model.sku.UserAddr;
import com.worldunion.prophesy.service.base.MessageService;
import com.worldunion.prophesy.service.base.UserAddrService;
import com.worldunion.prophesy.service.base.UserService;
import com.worldunion.prophesy.utils.common.error.Result;
@Controller
@RequestMapping("/api/user")
public class AppUserController extends BaseController{
	@Autowired
	UserService userService;
	@Autowired
	UserAddrService userAddrService;
	@Autowired
	MessageService messageService;
	
    /**
     * 查询用户地址
     *必输传用户ID，pageIndex,pageSize
     * @return
     */
    @RequestMapping("/queryUserAddr")
//    @SystemControllerLog(description = "用户地址列表",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result queryUserAddr() {
    	
    	List<UserAddr> userList=null;
		try {
			Map<String,Object> param=this.getQueryParams();
			getPageParams(param);
			userList=userAddrService.queryUserAddrByParams(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(userList);
    }
    /**
     * 查询用户消息
     *必输传用户ID，
     *pageIndex,pageSize
     * @return
     */
    @RequestMapping("/queryUserMessage")
//    @SystemControllerLog(description = "用户消息列表",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result queryUserMessage() {
    	
    	List<Message> userList=null;
		try {
			Map<String,Object> param=this.getQueryParams();
			getPageParams(param);
			userList=messageService.queryUserMessageByParams(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(userList);
    }
    /**
     * 查询用户消息
     *必输传用户ID，
     *pageIndex,pageSize
     * @return
     */
    @RequestMapping("/queryUserMessageByid")
//    @SystemControllerLog(description = "用户消息详情",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result queryUserMessageByid() {
    	
    	List<Message> messageList=null;
    	Message	message =null;
		try {
			Map<String,Object> param=this.getQueryParams();
			getPageParams(param);
			messageList=messageService.queryUserMessageByParams(param);
			if(messageList!=null && messageList.size()>0){
				message=messageList.get(0);			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(message);
    }
}
