package com.worldunion.prophesy.service.account;


import java.util.List;
import java.util.Map;

import com.worldunion.prophesy.model.account.StaffDataright;

public interface StaffDatarightService  {

	List<StaffDataright> getStaffDatarightByType(Long id, int type);
	List<StaffDataright> getStaffDatarightByType(String username, int type);

	List<StaffDataright> queryCityright(Map<String, Object> params);

	List<StaffDataright> queryServiceright(Map<String, Object> params);
	
	List<StaffDataright> queryCompanyright(Map<String, Object> params);
	
	List<StaffDataright> queryPDComRight(Map<String, Object> params);
	
	List<StaffDataright> queryReportAreaRight(Map<String, Object> params);
	
	List<StaffDataright> queryStaffServiceright(Map<String, Object> params);
	
	List<StaffDataright> queryIncomeRoleright(Map<String, Object> params);
	
	List<StaffDataright> queryStaffCompanyright(Map<String, Object> params);
	
	StaffDataright queryStaffRevenueright(Map<String, Object> params);
	
	List<StaffDataright> queryStaffPDComright(Map<String, Object> params);
	

	int updateStaffDataright(Map<String, Object> params);
	
	List<Map<String, Object>> queryRevenueList();
	List<StaffDataright> queryStaffReportArearight(Map<String, Object> params);

}
