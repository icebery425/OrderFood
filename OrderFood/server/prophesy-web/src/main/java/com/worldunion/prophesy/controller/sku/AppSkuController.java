package com.worldunion.prophesy.controller.sku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.controller.BaseController;
import com.worldunion.prophesy.model.sku.Billing;
import com.worldunion.prophesy.model.sku.Sku;
import com.worldunion.prophesy.model.sku.SkuType;
import com.worldunion.prophesy.service.base.BillingService;
import com.worldunion.prophesy.service.base.SkuService;
import com.worldunion.prophesy.utils.common.error.Result;
@Controller
@RequestMapping("/api/sku")
public class AppSkuController extends BaseController{
	@Autowired
	SkuService skuService;
	@Autowired
	BillingService billingService;
	
    /**
     * 查询菜单种类
     *
     * @return
     */
    @RequestMapping("/typelist")
//    @SystemControllerLog(description = "菜单类型列表",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result queryAllSkuType() {
    	
    	List<SkuType> stList=null;
		try {
			stList=skuService.queryAllSkuType();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(stList);
    }
    /**
     * 查询菜单列表
     *
     * @return
     */
    @RequestMapping("/skulist")
//    @SystemControllerLog(description = "菜单列表",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result queryAllSkuList(Integer skuTypeId) {
    	
    	List<Sku> stList=null;
		try {
			stList=skuService.queryAllSkuList(skuTypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(stList);
    }
}
