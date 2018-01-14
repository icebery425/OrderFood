package com.worldunion.prophesy.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Project implements Serializable {
	private Long projectid;

    private String projectcode;

    private String projectname;

    private Long servprojectid;

    private Long organizationid;

    private Long companyid;

    private Long developercomid;

    private Long managerid;

    private Long planmanagerid;

    private String businessproperty;

    private String projecttype;

    private Date opendate;

    private String leavetype;

    private String projectphase;

    private Integer provinceid;

    private Integer cityid;

    private Long regionid;

    private Integer countyid;

    private String salemodel;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String addrname;

    private Long srcservprojectid;

    private Date startdate;

    private Date enddate;

    private Date addtime;

    private Date entertime;

    private Date altertime;

    private String status;

    private Long checkid;

    private Long enterid;

    private Long alterid;

    private String remark;

    private Long sortnum;

    private static final long serialVersionUID = 1L;

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode == null ? null : projectcode.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public Long getServprojectid() {
        return servprojectid;
    }

    public void setServprojectid(Long servprojectid) {
        this.servprojectid = servprojectid;
    }

    public Long getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Long organizationid) {
        this.organizationid = organizationid;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public Long getDevelopercomid() {
        return developercomid;
    }

    public void setDevelopercomid(Long developercomid) {
        this.developercomid = developercomid;
    }

    public Long getManagerid() {
        return managerid;
    }

    public void setManagerid(Long managerid) {
        this.managerid = managerid;
    }

    public Long getPlanmanagerid() {
        return planmanagerid;
    }

    public void setPlanmanagerid(Long planmanagerid) {
        this.planmanagerid = planmanagerid;
    }

    public String getBusinessproperty() {
        return businessproperty;
    }

    public void setBusinessproperty(String businessproperty) {
        this.businessproperty = businessproperty == null ? null : businessproperty.trim();
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype == null ? null : projecttype.trim();
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype == null ? null : leavetype.trim();
    }

    public String getProjectphase() {
        return projectphase;
    }

    public void setProjectphase(String projectphase) {
        this.projectphase = projectphase == null ? null : projectphase.trim();
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Long getRegionid() {
        return regionid;
    }

    public void setRegionid(Long regionid) {
        this.regionid = regionid;
    }

    public Integer getCountyid() {
        return countyid;
    }

    public void setCountyid(Integer countyid) {
        this.countyid = countyid;
    }

    public String getSalemodel() {
        return salemodel;
    }

    public void setSalemodel(String salemodel) {
        this.salemodel = salemodel == null ? null : salemodel.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getAddrname() {
        return addrname;
    }

    public void setAddrname(String addrname) {
        this.addrname = addrname == null ? null : addrname.trim();
    }

    public Long getSrcservprojectid() {
        return srcservprojectid;
    }

    public void setSrcservprojectid(Long srcservprojectid) {
        this.srcservprojectid = srcservprojectid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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
        this.status = status == null ? null : status.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getSortnum() {
        return sortnum;
    }

    public void setSortnum(Long sortnum) {
        this.sortnum = sortnum;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Project other = (Project) that;
        return (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getProjectcode() == null ? other.getProjectcode() == null : this.getProjectcode().equals(other.getProjectcode()))
            && (this.getProjectname() == null ? other.getProjectname() == null : this.getProjectname().equals(other.getProjectname()))
            && (this.getServprojectid() == null ? other.getServprojectid() == null : this.getServprojectid().equals(other.getServprojectid()))
            && (this.getOrganizationid() == null ? other.getOrganizationid() == null : this.getOrganizationid().equals(other.getOrganizationid()))
            && (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getDevelopercomid() == null ? other.getDevelopercomid() == null : this.getDevelopercomid().equals(other.getDevelopercomid()))
            && (this.getManagerid() == null ? other.getManagerid() == null : this.getManagerid().equals(other.getManagerid()))
            && (this.getPlanmanagerid() == null ? other.getPlanmanagerid() == null : this.getPlanmanagerid().equals(other.getPlanmanagerid()))
            && (this.getBusinessproperty() == null ? other.getBusinessproperty() == null : this.getBusinessproperty().equals(other.getBusinessproperty()))
            && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
            && (this.getOpendate() == null ? other.getOpendate() == null : this.getOpendate().equals(other.getOpendate()))
            && (this.getLeavetype() == null ? other.getLeavetype() == null : this.getLeavetype().equals(other.getLeavetype()))
            && (this.getProjectphase() == null ? other.getProjectphase() == null : this.getProjectphase().equals(other.getProjectphase()))
            && (this.getProvinceid() == null ? other.getProvinceid() == null : this.getProvinceid().equals(other.getProvinceid()))
            && (this.getCityid() == null ? other.getCityid() == null : this.getCityid().equals(other.getCityid()))
            && (this.getRegionid() == null ? other.getRegionid() == null : this.getRegionid().equals(other.getRegionid()))
            && (this.getCountyid() == null ? other.getCountyid() == null : this.getCountyid().equals(other.getCountyid()))
            && (this.getSalemodel() == null ? other.getSalemodel() == null : this.getSalemodel().equals(other.getSalemodel()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getAddrname() == null ? other.getAddrname() == null : this.getAddrname().equals(other.getAddrname()))
            && (this.getSrcservprojectid() == null ? other.getSrcservprojectid() == null : this.getSrcservprojectid().equals(other.getSrcservprojectid()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getEntertime() == null ? other.getEntertime() == null : this.getEntertime().equals(other.getEntertime()))
            && (this.getAltertime() == null ? other.getAltertime() == null : this.getAltertime().equals(other.getAltertime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCheckid() == null ? other.getCheckid() == null : this.getCheckid().equals(other.getCheckid()))
            && (this.getEnterid() == null ? other.getEnterid() == null : this.getEnterid().equals(other.getEnterid()))
            && (this.getAlterid() == null ? other.getAlterid() == null : this.getAlterid().equals(other.getAlterid()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getSortnum() == null ? other.getSortnum() == null : this.getSortnum().equals(other.getSortnum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getProjectcode() == null) ? 0 : getProjectcode().hashCode());
        result = prime * result + ((getProjectname() == null) ? 0 : getProjectname().hashCode());
        result = prime * result + ((getServprojectid() == null) ? 0 : getServprojectid().hashCode());
        result = prime * result + ((getOrganizationid() == null) ? 0 : getOrganizationid().hashCode());
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getDevelopercomid() == null) ? 0 : getDevelopercomid().hashCode());
        result = prime * result + ((getManagerid() == null) ? 0 : getManagerid().hashCode());
        result = prime * result + ((getPlanmanagerid() == null) ? 0 : getPlanmanagerid().hashCode());
        result = prime * result + ((getBusinessproperty() == null) ? 0 : getBusinessproperty().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getOpendate() == null) ? 0 : getOpendate().hashCode());
        result = prime * result + ((getLeavetype() == null) ? 0 : getLeavetype().hashCode());
        result = prime * result + ((getProjectphase() == null) ? 0 : getProjectphase().hashCode());
        result = prime * result + ((getProvinceid() == null) ? 0 : getProvinceid().hashCode());
        result = prime * result + ((getCityid() == null) ? 0 : getCityid().hashCode());
        result = prime * result + ((getRegionid() == null) ? 0 : getRegionid().hashCode());
        result = prime * result + ((getCountyid() == null) ? 0 : getCountyid().hashCode());
        result = prime * result + ((getSalemodel() == null) ? 0 : getSalemodel().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getAddrname() == null) ? 0 : getAddrname().hashCode());
        result = prime * result + ((getSrcservprojectid() == null) ? 0 : getSrcservprojectid().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getEntertime() == null) ? 0 : getEntertime().hashCode());
        result = prime * result + ((getAltertime() == null) ? 0 : getAltertime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCheckid() == null) ? 0 : getCheckid().hashCode());
        result = prime * result + ((getEnterid() == null) ? 0 : getEnterid().hashCode());
        result = prime * result + ((getAlterid() == null) ? 0 : getAlterid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getSortnum() == null) ? 0 : getSortnum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectid=").append(projectid);
        sb.append(", projectcode=").append(projectcode);
        sb.append(", projectname=").append(projectname);
        sb.append(", servprojectid=").append(servprojectid);
        sb.append(", organizationid=").append(organizationid);
        sb.append(", companyid=").append(companyid);
        sb.append(", developercomid=").append(developercomid);
        sb.append(", managerid=").append(managerid);
        sb.append(", planmanagerid=").append(planmanagerid);
        sb.append(", businessproperty=").append(businessproperty);
        sb.append(", projecttype=").append(projecttype);
        sb.append(", opendate=").append(opendate);
        sb.append(", leavetype=").append(leavetype);
        sb.append(", projectphase=").append(projectphase);
        sb.append(", provinceid=").append(provinceid);
        sb.append(", cityid=").append(cityid);
        sb.append(", regionid=").append(regionid);
        sb.append(", countyid=").append(countyid);
        sb.append(", salemodel=").append(salemodel);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", addrname=").append(addrname);
        sb.append(", srcservprojectid=").append(srcservprojectid);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", addtime=").append(addtime);
        sb.append(", entertime=").append(entertime);
        sb.append(", altertime=").append(altertime);
        sb.append(", status=").append(status);
        sb.append(", checkid=").append(checkid);
        sb.append(", enterid=").append(enterid);
        sb.append(", alterid=").append(alterid);
        sb.append(", remark=").append(remark);
        sb.append(", sortnum=").append(sortnum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
	
}