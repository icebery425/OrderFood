package com.worldunion.prophesy.model;

import java.io.Serializable;
import java.util.Date;

public class FinaReport implements Serializable {
	
	
	private String daycode;
	private String servicecode;
	private Double collectionamount;
	private Double realreveamount;
	private Long reportedAreaid;
	private Date addtime;
	private String status;
	private Long staffid;
	public String getDaycode() {
		return daycode;
	}
	public void setDaycode(String daycode) {
		this.daycode = daycode;
	}
	public String getServicecode() {
		return servicecode;
	}
	public void setServicecode(String servicecode) {
		this.servicecode = servicecode;
	}
	
	public Double getCollectionamount() {
		return collectionamount;
	}
	public void setCollectionamount(Double collectionamount) {
		this.collectionamount = collectionamount;
	}
	public Double getRealreveamount() {
		return realreveamount;
	}
	public void setRealreveamount(Double realreveamount) {
		this.realreveamount = realreveamount;
	}
	
	public Long getReportedAreaid() {
		return reportedAreaid;
	}
	public void setReportedAreaid(Long reportedAreaid) {
		this.reportedAreaid = reportedAreaid;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getStaffid() {
		return staffid;
	}
	public void setStaffid(Long staffid) {
		this.staffid = staffid;
	}
	
	
}
