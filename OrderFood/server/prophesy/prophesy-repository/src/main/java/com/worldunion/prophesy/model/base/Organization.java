package com.worldunion.prophesy.model.base;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable {
    private Long organizationid;

    private String organizationcode;

    private String organizationname;

    private Long parentorgid;

    private String orgtype;

    private Long finadeptid;

    private Long companyid;

    private Date addtime;

    private Date entertime;

    private Date altertime;

    private Long enterid;

    private Long alterid;

    private String status;

    private String remark;

    private Short orglevel;

    private Long srcorganizationid;

    private static final long serialVersionUID = 1L;

    public Long getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Long organizationid) {
        this.organizationid = organizationid;
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode == null ? null : organizationcode.trim();
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    public Long getParentorgid() {
        return parentorgid;
    }

    public void setParentorgid(Long parentorgid) {
        this.parentorgid = parentorgid;
    }

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype == null ? null : orgtype.trim();
    }

    public Long getFinadeptid() {
        return finadeptid;
    }

    public void setFinadeptid(Long finadeptid) {
        this.finadeptid = finadeptid;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getOrglevel() {
        return orglevel;
    }

    public void setOrglevel(Short orglevel) {
        this.orglevel = orglevel;
    }

    public Long getSrcorganizationid() {
        return srcorganizationid;
    }

    public void setSrcorganizationid(Long srcorganizationid) {
        this.srcorganizationid = srcorganizationid;
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
        Organization other = (Organization) that;
        return (this.getOrganizationid() == null ? other.getOrganizationid() == null : this.getOrganizationid().equals(other.getOrganizationid()))
            && (this.getOrganizationcode() == null ? other.getOrganizationcode() == null : this.getOrganizationcode().equals(other.getOrganizationcode()))
            && (this.getOrganizationname() == null ? other.getOrganizationname() == null : this.getOrganizationname().equals(other.getOrganizationname()))
            && (this.getParentorgid() == null ? other.getParentorgid() == null : this.getParentorgid().equals(other.getParentorgid()))
            && (this.getOrgtype() == null ? other.getOrgtype() == null : this.getOrgtype().equals(other.getOrgtype()))
            && (this.getFinadeptid() == null ? other.getFinadeptid() == null : this.getFinadeptid().equals(other.getFinadeptid()))
            && (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getEntertime() == null ? other.getEntertime() == null : this.getEntertime().equals(other.getEntertime()))
            && (this.getAltertime() == null ? other.getAltertime() == null : this.getAltertime().equals(other.getAltertime()))
            && (this.getEnterid() == null ? other.getEnterid() == null : this.getEnterid().equals(other.getEnterid()))
            && (this.getAlterid() == null ? other.getAlterid() == null : this.getAlterid().equals(other.getAlterid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getOrglevel() == null ? other.getOrglevel() == null : this.getOrglevel().equals(other.getOrglevel()))
            && (this.getSrcorganizationid() == null ? other.getSrcorganizationid() == null : this.getSrcorganizationid().equals(other.getSrcorganizationid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrganizationid() == null) ? 0 : getOrganizationid().hashCode());
        result = prime * result + ((getOrganizationcode() == null) ? 0 : getOrganizationcode().hashCode());
        result = prime * result + ((getOrganizationname() == null) ? 0 : getOrganizationname().hashCode());
        result = prime * result + ((getParentorgid() == null) ? 0 : getParentorgid().hashCode());
        result = prime * result + ((getOrgtype() == null) ? 0 : getOrgtype().hashCode());
        result = prime * result + ((getFinadeptid() == null) ? 0 : getFinadeptid().hashCode());
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getEntertime() == null) ? 0 : getEntertime().hashCode());
        result = prime * result + ((getAltertime() == null) ? 0 : getAltertime().hashCode());
        result = prime * result + ((getEnterid() == null) ? 0 : getEnterid().hashCode());
        result = prime * result + ((getAlterid() == null) ? 0 : getAlterid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOrglevel() == null) ? 0 : getOrglevel().hashCode());
        result = prime * result + ((getSrcorganizationid() == null) ? 0 : getSrcorganizationid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", organizationid=").append(organizationid);
        sb.append(", organizationcode=").append(organizationcode);
        sb.append(", organizationname=").append(organizationname);
        sb.append(", parentorgid=").append(parentorgid);
        sb.append(", orgtype=").append(orgtype);
        sb.append(", finadeptid=").append(finadeptid);
        sb.append(", companyid=").append(companyid);
        sb.append(", addtime=").append(addtime);
        sb.append(", entertime=").append(entertime);
        sb.append(", altertime=").append(altertime);
        sb.append(", enterid=").append(enterid);
        sb.append(", alterid=").append(alterid);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", orglevel=").append(orglevel);
        sb.append(", srcorganizationid=").append(srcorganizationid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}