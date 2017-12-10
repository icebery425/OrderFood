package com.worldunion.prophesy.model.sku;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer userid;

    private String mobile;

    private String wechatno;

    private String wechatnickname;

    private String usertypeid;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWechatno() {
        return wechatno;
    }

    public void setWechatno(String wechatno) {
        this.wechatno = wechatno == null ? null : wechatno.trim();
    }

    public String getWechatnickname() {
        return wechatnickname;
    }

    public void setWechatnickname(String wechatnickname) {
        this.wechatnickname = wechatnickname == null ? null : wechatnickname.trim();
    }

    public String getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(String usertypeid) {
        this.usertypeid = usertypeid == null ? null : usertypeid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
        User other = (User) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getWechatno() == null ? other.getWechatno() == null : this.getWechatno().equals(other.getWechatno()))
            && (this.getWechatnickname() == null ? other.getWechatnickname() == null : this.getWechatnickname().equals(other.getWechatnickname()))
            && (this.getUsertypeid() == null ? other.getUsertypeid() == null : this.getUsertypeid().equals(other.getUsertypeid()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getWechatno() == null) ? 0 : getWechatno().hashCode());
        result = prime * result + ((getWechatnickname() == null) ? 0 : getWechatnickname().hashCode());
        result = prime * result + ((getUsertypeid() == null) ? 0 : getUsertypeid().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", mobile=").append(mobile);
        sb.append(", wechatno=").append(wechatno);
        sb.append(", wechatnickname=").append(wechatnickname);
        sb.append(", usertypeid=").append(usertypeid);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}