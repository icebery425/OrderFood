package com.worldunion.prophesy.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.model.DevCompany;
import com.worldunion.prophesy.model.DevCompanyParent;
import com.worldunion.prophesy.model.ManageCompany;
import com.worldunion.prophesy.model.ReportedArea;
import com.worldunion.prophesy.model.account.StaffDataright;
import com.worldunion.prophesy.model.base.City;
import com.worldunion.prophesy.model.base.Company;
import com.worldunion.prophesy.model.base.County;
import com.worldunion.prophesy.model.base.Organization;
import com.worldunion.prophesy.model.base.Project;
import com.worldunion.prophesy.model.base.Region;
import com.worldunion.prophesy.model.base.Service;
import com.worldunion.prophesy.model.util.SystemVariableUtils;

import com.worldunion.prophesy.utils.common.error.Result;
import com.worldunion.prophesy.utils.httputils.exception.HttpProcessException;

@Controller
@RequestMapping("/common")
public class CommonUtilController extends BaseController {

	


	
	
	
	public List<DevCompanyParent> comparePDComList(List<StaffDataright> sdList,List<DevCompanyParent> devCompanyParentList){
		List<DevCompanyParent> resultList=new ArrayList<DevCompanyParent>();
		boolean flag=false;
		if(sdList==null|| sdList.size()==0){
			resultList= devCompanyParentList;
		}else{
			for(int num=0;num<sdList.size();num++){
				StaffDataright sd=sdList.get(num);
				for(int k=0;k<devCompanyParentList.size();k++){
					DevCompanyParent c=devCompanyParentList.get(k);
					if(c.getPardevelopcomid().toString().equals(sd.getDataid().toString())){
						resultList.add(c);
						break;
					}
					
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 查询当前用户有权限的业务线id，若没有配置则返回*
	 * @param modelMap
	 * @return
	 * @throws HttpProcessException
	 */
	@RequestMapping("/selectServiceIds")
	@ResponseBody
	public Result selectServiceIds(ModelMap modelMap) throws HttpProcessException {
		List<StaffDataright> servList=SystemVariableUtils.getSessionVariable().getServTypeList();
		return Result.buildOkResult(CommonUtilController.getDataRight(servList));
	}

	public static List<City> compareCityList(List<StaffDataright> sdList,List<City> cList){
		List<City> resultList=new ArrayList<City>();
		boolean flag=false;
		if(sdList==null|| sdList.size()==0){
			resultList= cList;
		}else{
			for(int num=0;num<sdList.size();num++){
				StaffDataright sd=sdList.get(num);
				for(int k=0;k<cList.size();k++){
					City c=cList.get(k);
					if(c.getCityid().equals(sd.getDataid())){
						resultList.add(c);
						break;
					}
					
				}
			}
		}
		return resultList;
	}
	public static List<Company> compareCompanyList(List<StaffDataright> sdList,List<Company> cList){
		List<Company> resultList=new ArrayList<Company>();
		boolean flag=false;
		if(sdList==null|| sdList.size()==0){
			resultList= cList;
		}else{
			for(int num=0;num<sdList.size();num++){
				StaffDataright sd=sdList.get(num);
				for(int k=0;k<cList.size();k++){
					Company c=cList.get(k);
					if(c.getCompanyid().equals(sd.getDataid())){
						resultList.add(c);
						break;
					}
					
				}
			}
		}
		return resultList;
	}
	public static List<ManageCompany> compareManageCompanyList(List<StaffDataright> sdList,List<ManageCompany> cList){
		List<ManageCompany> resultList=new ArrayList<ManageCompany>();
		boolean flag=false;
		if(sdList==null|| sdList.size()==0){
			resultList= cList;
		}else{
			for(int num=0;num<sdList.size();num++){
				StaffDataright sd=sdList.get(num);
				for(int k=0;k<cList.size();k++){
					ManageCompany c=cList.get(k);
					if(c.getManagecompanyid().equals(sd.getDataid())){
						resultList.add(c);
						break;
					}
					
				}
			}
		}
		return resultList;
	}
	public static List<ReportedArea> compareReportedAreaList(List<StaffDataright> sdList,List<ReportedArea> cList){
		List<ReportedArea> resultList=new ArrayList<ReportedArea>();
		boolean flag=false;
		if(sdList==null|| sdList.size()==0){
			resultList= cList;
		}else{
			for(int num=0;num<sdList.size();num++){
				StaffDataright sd=sdList.get(num);
				for(int k=0;k<cList.size();k++){
					ReportedArea c=cList.get(k);
					if(Long.valueOf(c.getReportedareaid()).equals(Long.valueOf(sd.getDataid()))){
						resultList.add(c);
						break;
					}
					
				}
			}
		}
		return resultList;
	}
	public static List<Service> compareServiceList(List<StaffDataright> sdList,List<Service> cList){
		List<Service> resultList=new ArrayList<Service>();
		boolean flag=false;
		if(sdList==null|| sdList.size()==0){
			resultList= cList;
		}else{
			for(int num=0;num<sdList.size();num++){
				StaffDataright sd=sdList.get(num);
				for(int k=0;k<cList.size();k++){
					Service c=cList.get(k);
					if(c.getServiceid().equals(sd.getDataid())){
						resultList.add(c);
						break;
					}
					
				}
			}
		}
		return resultList;
	}
	public static String getDataRight(List<StaffDataright> sdList){
		String datastr="";
		if(sdList!=null && sdList.size()>0){
			for(int num=0;num<sdList.size();num++){
				datastr=datastr+sdList.get(num).getDataid()+",";
			}
			datastr=datastr.substring(0,datastr.length()-1);
		}else{
			datastr="*";
		}
		return datastr;
	}
	
}
