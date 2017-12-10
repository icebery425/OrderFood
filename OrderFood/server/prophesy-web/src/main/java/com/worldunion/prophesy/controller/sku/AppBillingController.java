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
@RequestMapping("/api/order")
public class AppBillingController extends BaseController{
	@Autowired
	SkuService skuService;
	@Autowired
	BillingService billingService;
	/**
     * 查詢訂單
     *
     * @return
     */
    @RequestMapping("/queryById")
//    @SystemControllerLog(description = "订单查询（单个）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result queryById(Integer id) {
    	
    	Billing billing=null;
		try {
			billing = billingService.selectBillingByid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(billing);
    }
    /**
     * 查詢訂單列表
     *
     * @return
     */
    @RequestMapping("/queryBillinglist")
//    @SystemControllerLog(description = "订单查询（列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result queryBillinglist() {
    	
    	List<Billing> billList=new ArrayList<Billing>();
    	Map<String,Object> param=this.getQueryParams();
    	
		try {
			String pageIndex=String.valueOf(param.get("pageIndex"));
			String pageSize=String.valueOf(param.get("pageSize"));
			if(pageIndex!=null && !"".equals(pageIndex)&&pageSize!=null && !"".equals(pageSize)){
				param.put("start", (Integer.parseInt(pageIndex)-1)*Integer.parseInt(pageSize));
				param.put("end", Integer.parseInt(pageSize));
			}
			
			billList = billingService.selectBillingList(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(billList);
    }
    /**
     * 取消訂單
     *
     * @return
     */
    @RequestMapping("/cancelOrder")
//    @SystemControllerLog(description = "取消订单（单个）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result cancelBillById(Integer orderId) {
    	
    	Billing billing=null;
    	Map<String,Object> param=new HashMap<String,Object>();
		try {
			param.put("orderId", orderId);
			param.put("status", "920");
			 billingService.updateBillingByParam(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return Result.buildOkResult(billing);
    }
    
    
}
