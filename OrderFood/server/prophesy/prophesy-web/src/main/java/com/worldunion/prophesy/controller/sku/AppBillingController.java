package com.worldunion.prophesy.controller.sku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.worldunion.prophesy.controller.BaseController;
import com.worldunion.prophesy.model.sku.Billing;
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
			return Result.buildOneErrorResult("999", "参数错误");
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
			return Result.buildOneErrorResult("999", "参数错误");
			
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
			return Result.buildOneErrorResult("999", "参数错误");
		}
    	return Result.buildOkResult(billing);
    }
    /**
     * 下訂單或結算接口
     *
     * @return
     */
    @RequestMapping("/submitOrder")
//    @SystemControllerLog(description = "提交订单（单个）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result submitOrder() {
    	Map<String,String> params=new HashMap<String,String>();
    	
    	Map<String,Object> resultparams=new HashMap<String,Object>();
    	Map<String,Object> billskumap=new HashMap<String,Object>();
    	String[] strarr ={"deliveryType",//配送方式
    			"deliveryTime",//配送时间
    			"totalAmount",//商品金额
    			"discountAmount",//折扣金额
    			"freightAmount",//配送费
    			"receivableAmount",//应收金额
    			"msg",//留言
    			"desc",//备注
    			"supervisor",//联系人
    			"supervisorPhone",//联系方式
    			"openid",//openid
    			"address",//送货地址
    			"items"
    			};
    	
    	params=getHeaderMap(strarr);
    	String code=this.getuuid();
    	params.put("billcode", code);
    	Billing billing=null;
    	Map<String,Object> param=new HashMap<String,Object>();
    	
//		try {
//			JSONArray ja=JSONArray.parseArray(String.valueOf(params.get("items")));
//			int billid= billingService.insertBillInfo(param);//存入訂單表
////			JSONObject json = JSONObject.parseObject(params.get("billinginfo"));//訂單商品信息（可能多個），存入訂單商品表根據格式
//			List<Map<String,Object>> billskuling=new ArrayList<Map<String,Object>>();
//			//存入訂單商品表方法
//			for(int num=0;num<ja.size();num++){
//				 JSONObject myjObject=ja.getJSONObject(num);
//				 billskumap=new HashMap<String,Object>();
//				 billskumap.put("skuid", myjObject.get("skuId"));
//				 billskumap.put("quantity",  myjObject.get("quantity"));
//				 billskumap.put("billid", billid);
//				 billskuling.add(billskumap);
//			}
//			billingService.insertBillSkuInfo(billskuling);
//			resultparams.put("id", billid);
//			resultparams.put("number", code);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Result.buildOneErrorResult("999", "参数错误");
//		}
    	return Result.buildOkResult(resultparams);
    }
   
    
    
}
