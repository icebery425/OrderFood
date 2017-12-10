package com.worldunion.prophesy.service.account.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worldunion.prophesy.dao.StaffDao;
import com.worldunion.prophesy.dao.StaffDatarightDao;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.account.StaffDataright;
import com.worldunion.prophesy.service.account.StaffDatarightService;
import com.worldunion.prophesy.utils.common.Contents;

@Service("staffDatarightService")
public class StaffDatarightServiceImpl   implements StaffDatarightService {


	@Autowired
	private StaffDatarightDao staffDatarightDao;
	@Autowired
	private StaffDao staffDao;

	@Override
	public List<StaffDataright> getStaffDatarightByType(Long id, int typeid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", id);
		params.put("datarighttypeid", typeid);
		List<StaffDataright> staffDatarights = null;
//		if(typeid == Contents.TYPE_CITY){
//			staffDatarights = this.queryCityright(params);
//		} else if(typeid == Contents.TYPE_REVENUE){
//			staffDatarights = this.queryIncomeRoleright(params);
//		} else if(typeid == Contents.TYPE_SERVICE){
//			staffDatarights = this.queryStaffServiceright(params);
//		} else if (typeid == Contents.TYPE_COMPANY){
//			staffDatarights = this.queryStaffCompanyright(params);
//		} else if (typeid == Contents.TYPE_PDEVCOM){
//			staffDatarights = this.queryStaffPDComright(params);
//		}else if (typeid == Contents.TYPE_REPORTAREA){
//			staffDatarights = this.queryStaffReportArearight(params);
//		}
		return staffDatarights;
	}

	@Override
	@Transactional
	public int updateStaffDataright(Map<String, Object> params) {
		try{
			String ids = params.get("ids")+"";
			staffDatarightDao.deleteByStaff(params);
			if(StringUtils.isNotBlank(ids)){
				String[] idList = ids.split(",");
				for(String idStr : idList){
					StaffDataright dataRight = new StaffDataright();
					dataRight.setDataid(Integer.valueOf(idStr));
					dataRight.setDatarighttypeid((int)params.get("datarighttypeid"));
					dataRight.setStaffid((int)params.get("staffid"));
					dataRight.setEnterid((Long)params.get("enterid"));
					staffDatarightDao.insertStaffright(dataRight);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

	@Override
	public List<StaffDataright> queryCityright(Map<String, Object> params) {
		List<StaffDataright> cityrightlist = staffDatarightDao.queryCityright(params);
		return cityrightlist;
	}

	@Override
	public List<StaffDataright> queryServiceright(Map<String, Object> params) {
		List<StaffDataright> cityrightlist = staffDatarightDao.queryServiceright(params);
		return cityrightlist;
	}
	
	@Override
	public List<StaffDataright> queryCompanyright(Map<String, Object> params) {
		List<StaffDataright> cityrightlist = staffDatarightDao.queryCompanyright(params);
		return cityrightlist;
	}
	@Override
	public List<StaffDataright> queryPDComRight(Map<String, Object> params) {
		return staffDatarightDao.queryPDComRight(params);
	}
	@Override
	public List<StaffDataright> queryReportAreaRight(Map<String, Object> params) {
		return staffDatarightDao.queryReportAreaRight(params);
	}

	@Override
	public List<Map<String, Object>> queryRevenueList() {
		return staffDatarightDao.queryRevenueList();
	}

	@Override
	public List<StaffDataright> queryStaffServiceright(
			Map<String, Object> params) {
		List<StaffDataright> cityrightlist = staffDatarightDao.queryStaffServiceright(params);
		return cityrightlist;
	}
	
	@Override
	public List<StaffDataright> queryIncomeRoleright(
			Map<String, Object> params) {
		List<StaffDataright> cityrightlist = staffDatarightDao.queryIncomeRoleright(params);
		return cityrightlist;
	}
	

	@Override
	public List<StaffDataright> queryStaffCompanyright(
			Map<String, Object> params) {
		List<StaffDataright> cityrightlist = staffDatarightDao.queryStaffCompanyright(params);
		return cityrightlist;
	}
	
	@Override
	public List<StaffDataright> queryStaffPDComright(Map<String, Object> params) {
		List<StaffDataright> cityrightlist = staffDatarightDao.queryStaffPDComright(params);
		return cityrightlist;
	}
	@Override
	public List<StaffDataright> queryStaffReportArearight(Map<String, Object> params) {
		List<StaffDataright> reportArearightlist = staffDatarightDao.queryStaffReportArearight(params);
		return reportArearightlist;
	}
	
	@Override
	public List<StaffDataright> getStaffDatarightByType(String username,
			int type) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("staffCode", username);
		List<Staff> staffs=staffDao.selectByMap(params);
		if(staffs==null ||staffs.size()==0){
			return new ArrayList<StaffDataright>();
		}
		Long id=staffs.get(0).getStaffid();
		return getStaffDatarightByType(id,type);
	}

	@Override
	public StaffDataright queryStaffRevenueright(Map<String, Object> params) {
		return staffDatarightDao.queryStaffRevenueright(params);
	}



	
}
