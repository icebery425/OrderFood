package com.worldunion.prophesy.model.base;

import java.io.Serializable;
import java.util.Date;

public class Service implements Serializable {
	private Integer serviceid;
	private String servcode;
	private String servicename;
	private Date addtime;
	private Date entertime;
	private Date altertime;
	private String status;
	private Long checkid;
	private Long enterid;
	private Long alterid;
	private String remark;
	private Long sortnum;
	
	public Integer getServiceid() {
		return serviceid;
	}
	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}
	public String getServcode() {
		return servcode;
	}
	public void setServcode(String servcode) {
		this.servcode = servcode;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Date getEntertime() {
		return entertime;
	}
	public void setEntertime(Date entertime) {
		this.entertime = entertime;
	}
	public Date getAltertime() {
		return altertime;
	}
	public void setAltertime(Date altertime) {
		this.altertime = altertime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCheckid() {
		return checkid;
	}
	public void setCheckid(Long checkid) {
		this.checkid = checkid;
	}
	public Long getEnterid() {
		return enterid;
	}
	public void setEnterid(Long enterid) {
		this.enterid = enterid;
	}
	public Long getAlterid() {
		return alterid;
	}
	public void setAlterid(Long alterid) {
		this.alterid = alterid;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getSortnum() {
		return sortnum;
	}
	public void setSortnum(Long sortnum) {
		this.sortnum = sortnum;
	}
	@Override
	public String toString() {
		return "Service [serviceid=" + serviceid + ", servcode=" + servcode
				+ ", servicename=" + servicename + ", addtime=" + addtime
				+ ", entertime=" + entertime + ", altertime=" + altertime
				+ ", status=" + status + ", checkid=" + checkid + ", enterid="
				+ enterid + ", alterid=" + alterid + ", remark=" + remark
				+ ", sortnum=" + sortnum + "]";
	}

}
