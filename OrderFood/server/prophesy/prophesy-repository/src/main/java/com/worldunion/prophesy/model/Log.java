package com.worldunion.prophesy.model;

import java.util.Date;
import java.util.List;


public class Log {
	private int logid;
	private String loginip;
	private String urlinfo;
	private String remark;
	private int logtypeid;
	private Long staffid;
	private int logactionid;
	private Date addtime;
	private int funcid;
	private int datanum;
	private List<LogDetail> detail;
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public String getUrlinfo() {
		return urlinfo;
	}
	public void setUrlinfo(String urlinfo) {
		this.urlinfo = urlinfo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getLogtypeid() {
		return logtypeid;
	}
	public void setLogtypeid(int logtypeid) {
		this.logtypeid = logtypeid;
	}
	public Long getStaffid() {
		return staffid;
	}
	public void setStaffid(Long staffid) {
		this.staffid = staffid;
	}
	public int getLogactionid() {
		return logactionid;
	}
	public void setLogactionid(int logactionid) {
		this.logactionid = logactionid;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public int getFuncid() {
		return funcid;
	}
	public void setFuncid(int funcid) {
		this.funcid = funcid;
	}
	public int getDatanum() {
		return datanum;
	}
	public void setDatanum(int datanum) {
		this.datanum = datanum;
	}
	public List<LogDetail> getDetail() {
		return detail;
	}
	public void setDetail(List<LogDetail> detail) {
		this.detail = detail;
	}
	/**
	 * 扩展字段，可以参考constant.java的配置 如:LOG_TYPECODE_BUSI
	 */
	private String logtypeCode;//日志类型 tpm_static_type表里面classcode=26
	private String logactionCode;//日志动作 tpm_static_type表里面classcode=27
	private String funcCode;//日志功能 tpm_static_type表里面classcode=28
	public String getLogtypeCode() {
		return logtypeCode;
	}
	public void setLogtypeCode(String logtypeCode) {
		this.logtypeCode = logtypeCode;
	}
	public String getLogactionCode() {
		return logactionCode;
	}
	public void setLogactionCode(String logactionCode) {
		this.logactionCode = logactionCode;
	}
	public String getFuncCode() {
		return funcCode;
	}
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	
}
