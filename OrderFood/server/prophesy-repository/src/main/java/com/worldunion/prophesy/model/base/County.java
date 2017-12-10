package com.worldunion.prophesy.model.base;

import java.io.Serializable;
import java.util.Date;

public class County implements Serializable {
	private Integer countyid;


    private String countyname;


    private String gbcode;


    private Long gisid;


    private Integer cityid;


    private Date addtime;


    private Date entertime;

    private Date checktime;

    private Date altertime;


    private Long enterid;


    private Long checkid;

    private Long alterid;


    private String status;


    private Long sortnum;


    private String simplespell;

    private String fullspell;

	public Integer getCountyid() {
		return countyid;
	}

	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}

	public String getCountyname() {
		return countyname;
	}

	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public Long getGisid() {
		return gisid;
	}

	public void setGisid(Long gisid) {
		this.gisid = gisid;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
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

	public Date getChecktime() {
		return checktime;
	}

	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}

	public Date getAltertime() {
		return altertime;
	}

	public void setAltertime(Date altertime) {
		this.altertime = altertime;
	}

	public Long getEnterid() {
		return enterid;
	}

	public void setEnterid(Long enterid) {
		this.enterid = enterid;
	}

	public Long getCheckid() {
		return checkid;
	}

	public void setCheckid(Long checkid) {
		this.checkid = checkid;
	}

	public Long getAlterid() {
		return alterid;
	}

	public void setAlterid(Long alterid) {
		this.alterid = alterid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSortnum() {
		return sortnum;
	}

	public void setSortnum(Long sortnum) {
		this.sortnum = sortnum;
	}

	public String getSimplespell() {
		return simplespell;
	}

	public void setSimplespell(String simplespell) {
		this.simplespell = simplespell;
	}

	public String getFullspell() {
		return fullspell;
	}

	public void setFullspell(String fullspell) {
		this.fullspell = fullspell;
	}

	@Override
	public String toString() {
		return "County [countyid=" + countyid + ", countyname=" + countyname
				+ ", gbcode=" + gbcode + ", gisid=" + gisid + ", cityid="
				+ cityid + ", addtime=" + addtime + ", entertime=" + entertime
				+ ", checktime=" + checktime + ", altertime=" + altertime
				+ ", enterid=" + enterid + ", checkid=" + checkid
				+ ", alterid=" + alterid + ", status=" + status + ", sortnum="
				+ sortnum + ", simplespell=" + simplespell + ", fullspell="
				+ fullspell + "]";
	}
}