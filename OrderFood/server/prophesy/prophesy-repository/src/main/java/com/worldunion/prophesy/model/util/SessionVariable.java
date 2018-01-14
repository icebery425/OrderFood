package com.worldunion.prophesy.model.util;

import java.io.Serializable;
import java.util.List;

import com.worldunion.prophesy.model.account.Group;
import com.worldunion.prophesy.model.account.Resource;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.account.StaffDataright;

/**
 * 
 * 系统常用Session变量实体
 * 
 */
public class SessionVariable implements Serializable {

	private static final long serialVersionUID = 1L;

	// 当前用户
	private Staff staff;
	// 当前用户所在的组集合
	private List<Group> groupsList;
	// 当前用户的授权资源集合
	private List<Resource> authorizationInfo;
	// 当前用户的菜单集合
	private List<Resource> menusList;
	// 城市资源
	private List<StaffDataright> cityList;
	// 业务线资源
	private List<StaffDataright> servTypeList;
	// 分公司资源
	private List<StaffDataright> subCompList;
	// 分公司资源
	private List<StaffDataright> ReportedAreaList;
	// 管报公司
	private List<StaffDataright> manageCompList;
	// 父开发商
	private List<StaffDataright> pDevCompList;
	
	public SessionVariable() {

	}

	public SessionVariable(Staff staff) {
		this.staff = staff;
	}

	public SessionVariable(Staff staff, List<Resource> authorizationInfo,
			List<Resource> menusList) {
		this.staff = staff;
		this.groupsList = staff.getGroupsList();
		this.authorizationInfo = authorizationInfo;
		this.menusList = menusList;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	/**
	 * 获取当前用户所在的组集合
	 * 
	 * @return List
	 */
	public List<Group> getGroupsList() {
		return groupsList;
	}

	/**
	 * 设置当前用户所在的组集合
	 * 
	 * @param groupsList
	 *            组集合
	 */
	public void setGroupsList(List<Group> groupsList) {
		this.groupsList = groupsList;
	}

	/**
	 * 获取当前用户的所有授权资源集合
	 * 
	 * @return List
	 */
	public List<Resource> getAuthorizationInfo() {
		return authorizationInfo;
	}

	/**
	 * 设置当前用户的所有授权资源集合
	 * 
	 * @param authorizationInfo
	 *            资源集合
	 */
	public void setAuthorizationInfo(List<Resource> authorizationInfo) {
		this.authorizationInfo = authorizationInfo;
	}

	/**
	 * 获取当前用户拥有的菜单集合
	 * 
	 * @return List
	 */
	public List<Resource> getMenusList() {
		return menusList;
	}

	/**
	 * 设置当前用户拥有的菜单集合
	 * 
	 * @param menusList
	 *            资源集合
	 */
	public void setMenusList(List<Resource> menusList) {
		this.menusList = menusList;
	}

	public List<StaffDataright> getCityList() {
		return cityList;
	}

	public void setCityList(List<StaffDataright> cityList) {
		this.cityList = cityList;
	}

	public List<StaffDataright> getServTypeList() {
		return servTypeList;
	}

	public void setServTypeList(List<StaffDataright> servTypeList) {
		this.servTypeList = servTypeList;
	}

	public List<StaffDataright> getSubCompList() {
		return subCompList;
	}

	public void setSubCompList(List<StaffDataright> subCompList) {
		this.subCompList = subCompList;
	}

	public List<StaffDataright> getManageCompList() {
		return manageCompList;
	}

	public void setManageCompList(List<StaffDataright> manageCompList) {
		this.manageCompList = manageCompList;
	}

	public List<StaffDataright> getpDevCompList() {
		return pDevCompList;
	}

	public void setpDevCompList(List<StaffDataright> pDevCompList) {
		this.pDevCompList = pDevCompList;
	}

	public List<StaffDataright> getReportedAreaList() {
		return ReportedAreaList;
	}

	public void setReportedAreaList(List<StaffDataright> reportedAreaList) {
		ReportedAreaList = reportedAreaList;
	}

	

}
