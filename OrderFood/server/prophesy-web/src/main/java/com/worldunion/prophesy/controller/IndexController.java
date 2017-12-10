package com.worldunion.prophesy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.worldunion.prophesy.controller.base.BaseController;
import com.worldunion.prophesy.model.account.Resource;
import com.worldunion.prophesy.model.sku.Sku;
import com.worldunion.prophesy.model.util.SystemVariableUtils;
import com.worldunion.prophesy.service.base.SkuService;
import com.worldunion.prophesy.utils.common.DateUtil;
import com.worldunion.prophesy.utils.httputils.exception.HttpProcessException;

/**
 *
 * 首页
 * 
 */
@Controller
public class IndexController extends BaseController {
	@Autowired
	SkuService skuService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap) throws HttpProcessException {
    	List<Resource> menusList = SystemVariableUtils.getSessionVariable().getMenusList();
    	modelMap.put("menusList",menusList);
        return "index";
    }

    @RequestMapping("/home")
    public String home(ModelMap modelMap) throws HttpProcessException {
//    	List Allcitys=cityService.selectCityList();
//    	List<StaffDataright> sdList=SystemVariableUtils.getSessionVariable().getCityList();
//		List<City> citys =CommonUtilController.compareCityList(sdList, Allcitys);
//		if(Allcitys.size()==citys.size()){
//			modelMap.put("isallcity",true);
//		}else{
//			modelMap.put("isallcity",false);
//		}
//		modelMap.put("citys",citys);
//    	Sku sku=skuService.selectSkuList(1);
    	modelMap.put("citys",null);
		modelMap.put("startday",DateUtil.getBeforeday(-365, "yyyy-MM-dd"));
		modelMap.put("endday",DateUtil.getBeforeday(-1, "yyyy-MM-dd"));
        return "firstpage";
    }



}
