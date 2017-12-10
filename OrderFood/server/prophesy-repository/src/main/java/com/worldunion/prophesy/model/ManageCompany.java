package com.worldunion.prophesy.model;

import java.io.Serializable;
import java.util.Date;

public class ManageCompany implements Serializable {
    private Long managecompanyid;

    private String managecompanycode;

    private String managecompanyname;

    private Long manageareaid;

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

    public Long getManagecompanyid() {
        return managecompanyid;
    }

    public void setManagecompanyid(Long managecompanyid) {
        this.managecompanyid = managecompanyid;
    }

    public String getManagecompanycode() {
        return managecompanycode;
    }

    public void setManagecompanycode(String managecompanycode) {
        this.managecompanycode = managecompanycode == null ? null : managecompanycode.trim();
    }

    public String getManagecompanyname() {
        return managecompanyname;
    }

    public void setManagecompanyname(String managecompanyname) {
        this.managecompanyname = managecompanyname == null ? null : managecompanyname.trim();
    }

    public Long getManageareaid() {
        return manageareaid;
    }

    public void setManageareaid(Long manageareaid) {
        this.manageareaid = manageareaid;
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
        ManageCompany other = (ManageCompany) that;
        return (this.getManagecompanyid() == null ? other.getManagecompanyid() == null : this.getManagecompanyid().equals(other.getManagecompanyid()))
            && (this.getManagecompanycode() == null ? other.getManagecompanycode() == null : this.getManagecompanycode().equals(other.getManagecompanycode()))
            && (this.getManagecompanyname() == null ? other.getManagecompanyname() == null : this.getManagecompanyname().equals(other.getManagecompanyname()))
            && (this.getManageareaid() == null ? other.getManageareaid() == null : this.getManageareaid().equals(other.getManageareaid()))
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
        result = prime * result + ((getManagecompanyid() == null) ? 0 : getManagecompanyid().hashCode());
        result = prime * result + ((getManagecompanycode() == null) ? 0 : getManagecompanycode().hashCode());
        result = prime * result + ((getManagecompanyname() == null) ? 0 : getManagecompanyname().hashCode());
        result = prime * result + ((getManageareaid() == null) ? 0 : getManageareaid().hashCode());
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
        sb.append(", managecompanyid=").append(managecompanyid);
        sb.append(", managecompanycode=").append(managecompanycode);
        sb.append(", managecompanyname=").append(managecompanyname);
        sb.append(", manageareaid=").append(manageareaid);
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