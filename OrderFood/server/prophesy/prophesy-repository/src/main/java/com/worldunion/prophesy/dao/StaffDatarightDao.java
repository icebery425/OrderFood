package com.worldunion.prophesy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.worldunion.prophesy.model.account.StaffDataright;
import com.worldunion.prophesy.model.account.StaffDatarightExample;
import org.springframework.stereotype.Repository;

@Repository("staffDatarightDao")
public interface StaffDatarightDao {
    int countByExample(StaffDatarightExample example);

    int deleteByExample(StaffDatarightExample example);

    int deleteByPrimaryKey(Integer staffdatarightid);

    int insert(StaffDataright record);

    int insertSelective(StaffDataright record);

    List<StaffDataright> selectByExample(StaffDatarightExample example);

    StaffDataright selectByPrimaryKey(Integer staffdatarightid);

    int updateByExampleSelective(@Param("record") StaffDataright record, @Param("example") StaffDatarightExample example);

    int updateByExample(@Param("record") StaffDataright record, @Param("example") StaffDatarightExample example);

    int updateByPrimaryKeySelective(StaffDataright record);

    int updateByPrimaryKey(StaffDataright record);

	List<StaffDataright> getStaffDatarightByType(Map<String, Object> params);
	
	List<StaffDataright> queryCityright(Map<String, Object> params);
	
	List<StaffDataright> queryServiceright(Map<String, Object> params);
	
	List<StaffDataright> queryCompanyright(Map<String, Object> params);
	
	List<StaffDataright> queryStaffServiceright(Map<String, Object> params);

	List<StaffDataright> queryIncomeRoleright(Map<String, Object> params);
	
	List<StaffDataright> queryStaffCompanyright(Map<String, Object> params);
	
	List<StaffDataright> queryPDComRight(Map<String, Object> params);
	
	List<StaffDataright> queryReportAreaRight(Map<String, Object> params);

	void deleteByStaff(Map<String, Object> params);

	int insertStaffright(StaffDataright record);

	StaffDataright queryStaffRevenueright(Map<String, Object> params);

	List<Map<String, Object>> queryRevenueList();

	List<StaffDataright> queryStaffPDComright(Map<String, Object> params);

	List<StaffDataright> queryStaffReportArearight(Map<String, Object> params);
}