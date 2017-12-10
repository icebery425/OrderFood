package com.worldunion.prophesy.model;

import java.io.Serializable;
import java.util.Date;

public class LogDetail implements Serializable {
    private Long logdetailid;

    private Long logid;

    private Date addtime;

    private String remark;

    private String tablename;

    private Long dataid;

    private String nowvalue;

    private String originalvalue;

    private static final long serialVersionUID = 1L;

    public Long getLogdetailid() {
        return logdetailid;
    }

    public void setLogdetailid(Long logdetailid) {
        this.logdetailid = logdetailid;
    }

    public Long getLogid() {
        return logid;
    }

    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Long getDataid() {
        return dataid;
    }

    public void setDataid(Long dataid) {
        this.dataid = dataid;
    }

    public String getNowvalue() {
        return nowvalue;
    }

    public void setNowvalue(String nowvalue) {
        this.nowvalue = nowvalue == null ? null : nowvalue.trim();
    }

    public String getOriginalvalue() {
        return originalvalue;
    }

    public void setOriginalvalue(String originalvalue) {
        this.originalvalue = originalvalue == null ? null : originalvalue.trim();
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
        LogDetail other = (LogDetail) that;
        return (this.getLogdetailid() == null ? other.getLogdetailid() == null : this.getLogdetailid().equals(other.getLogdetailid()))
            && (this.getLogid() == null ? other.getLogid() == null : this.getLogid().equals(other.getLogid()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTablename() == null ? other.getTablename() == null : this.getTablename().equals(other.getTablename()))
            && (this.getDataid() == null ? other.getDataid() == null : this.getDataid().equals(other.getDataid()))
            && (this.getNowvalue() == null ? other.getNowvalue() == null : this.getNowvalue().equals(other.getNowvalue()))
            && (this.getOriginalvalue() == null ? other.getOriginalvalue() == null : this.getOriginalvalue().equals(other.getOriginalvalue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogdetailid() == null) ? 0 : getLogdetailid().hashCode());
        result = prime * result + ((getLogid() == null) ? 0 : getLogid().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTablename() == null) ? 0 : getTablename().hashCode());
        result = prime * result + ((getDataid() == null) ? 0 : getDataid().hashCode());
        result = prime * result + ((getNowvalue() == null) ? 0 : getNowvalue().hashCode());
        result = prime * result + ((getOriginalvalue() == null) ? 0 : getOriginalvalue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logdetailid=").append(logdetailid);
        sb.append(", logid=").append(logid);
        sb.append(", addtime=").append(addtime);
        sb.append(", remark=").append(remark);
        sb.append(", tablename=").append(tablename);
        sb.append(", dataid=").append(dataid);
        sb.append(", nowvalue=").append(nowvalue);
        sb.append(", originalvalue=").append(originalvalue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}