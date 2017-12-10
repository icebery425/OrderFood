package com.worldunion.prophesy.model;

import java.io.Serializable;
import java.util.Date;

public class DevCompanyParent implements Serializable {
    private Long pardevelopcomid;

    private String pardevcomcode;

    private String pardevcomname;

    private String simplespell;

    private Long servpardevcomid;

    private Date addtime;

    private Date entertime;

    private Date checktime;

    private Date altertime;

    private Long enterid;

    private Long checkid;

    private Long alterid;

    private String status;

    private Long sortnum;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getPardevelopcomid() {
        return pardevelopcomid;
    }

    public void setPardevelopcomid(Long pardevelopcomid) {
        this.pardevelopcomid = pardevelopcomid;
    }

    public String getPardevcomcode() {
        return pardevcomcode;
    }

    public void setPardevcomcode(String pardevcomcode) {
        this.pardevcomcode = pardevcomcode == null ? null : pardevcomcode.trim();
    }

    public String getPardevcomname() {
        return pardevcomname;
    }

    public void setPardevcomname(String pardevcomname) {
        this.pardevcomname = pardevcomname == null ? null : pardevcomname.trim();
    }

    public String getSimplespell() {
        return simplespell;
    }

    public void setSimplespell(String simplespell) {
        this.simplespell = simplespell == null ? null : simplespell.trim();
    }

    public Long getServpardevcomid() {
        return servpardevcomid;
    }

    public void setServpardevcomid(Long servpardevcomid) {
        this.servpardevcomid = servpardevcomid;
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
        this.status = status == null ? null : status.trim();
    }

    public Long getSortnum() {
        return sortnum;
    }

    public void setSortnum(Long sortnum) {
        this.sortnum = sortnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        DevCompanyParent other = (DevCompanyParent) that;
        return (this.getPardevelopcomid() == null ? other.getPardevelopcomid() == null : this.getPardevelopcomid().equals(other.getPardevelopcomid()))
            && (this.getPardevcomcode() == null ? other.getPardevcomcode() == null : this.getPardevcomcode().equals(other.getPardevcomcode()))
            && (this.getPardevcomname() == null ? other.getPardevcomname() == null : this.getPardevcomname().equals(other.getPardevcomname()))
            && (this.getSimplespell() == null ? other.getSimplespell() == null : this.getSimplespell().equals(other.getSimplespell()))
            && (this.getServpardevcomid() == null ? other.getServpardevcomid() == null : this.getServpardevcomid().equals(other.getServpardevcomid()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getEntertime() == null ? other.getEntertime() == null : this.getEntertime().equals(other.getEntertime()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getAltertime() == null ? other.getAltertime() == null : this.getAltertime().equals(other.getAltertime()))
            && (this.getEnterid() == null ? other.getEnterid() == null : this.getEnterid().equals(other.getEnterid()))
            && (this.getCheckid() == null ? other.getCheckid() == null : this.getCheckid().equals(other.getCheckid()))
            && (this.getAlterid() == null ? other.getAlterid() == null : this.getAlterid().equals(other.getAlterid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSortnum() == null ? other.getSortnum() == null : this.getSortnum().equals(other.getSortnum()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPardevelopcomid() == null) ? 0 : getPardevelopcomid().hashCode());
        result = prime * result + ((getPardevcomcode() == null) ? 0 : getPardevcomcode().hashCode());
        result = prime * result + ((getPardevcomname() == null) ? 0 : getPardevcomname().hashCode());
        result = prime * result + ((getSimplespell() == null) ? 0 : getSimplespell().hashCode());
        result = prime * result + ((getServpardevcomid() == null) ? 0 : getServpardevcomid().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getEntertime() == null) ? 0 : getEntertime().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getAltertime() == null) ? 0 : getAltertime().hashCode());
        result = prime * result + ((getEnterid() == null) ? 0 : getEnterid().hashCode());
        result = prime * result + ((getCheckid() == null) ? 0 : getCheckid().hashCode());
        result = prime * result + ((getAlterid() == null) ? 0 : getAlterid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSortnum() == null) ? 0 : getSortnum().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pardevelopcomid=").append(pardevelopcomid);
        sb.append(", pardevcomcode=").append(pardevcomcode);
        sb.append(", pardevcomname=").append(pardevcomname);
        sb.append(", simplespell=").append(simplespell);
        sb.append(", servpardevcomid=").append(servpardevcomid);
        sb.append(", addtime=").append(addtime);
        sb.append(", entertime=").append(entertime);
        sb.append(", checktime=").append(checktime);
        sb.append(", altertime=").append(altertime);
        sb.append(", enterid=").append(enterid);
        sb.append(", checkid=").append(checkid);
        sb.append(", alterid=").append(alterid);
        sb.append(", status=").append(status);
        sb.append(", sortnum=").append(sortnum);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}