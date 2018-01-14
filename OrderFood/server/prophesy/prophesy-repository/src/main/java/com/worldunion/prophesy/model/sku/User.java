package com.worldunion.prophesy.model.sku;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer userid;

    private String mobile;

    private String wechatno;

    private String wechatnickname;

    private String usertypeid;

    private String avatarurl;

    private Integer gender;

    private String wxFormId;

    private String wxappcode;

    private Date createdate;

    private String status;

    private String openid;

    private String token;

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

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

  

    public String getWxFormId() {
		return wxFormId;
	}

	public void setWxFormId(String wxFormId) {
		this.wxFormId = wxFormId;
	}

	public String getWxappcode() {
        return wxappcode;
    }

    public void setWxappcode(String wxappcode) {
        this.wxappcode = wxappcode == null ? null : wxappcode.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
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
            && (this.getAvatarurl() == null ? other.getAvatarurl() == null : this.getAvatarurl().equals(other.getAvatarurl()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getWxappcode() == null ? other.getWxappcode() == null : this.getWxappcode().equals(other.getWxappcode()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()));
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
        result = prime * result + ((getAvatarurl() == null) ? 0 : getAvatarurl().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getWxappcode() == null) ? 0 : getWxappcode().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
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
        sb.append(", avatarurl=").append(avatarurl);
        sb.append(", gender=").append(gender);
        sb.append(", wxappcode=").append(wxappcode);
        sb.append(", createdate=").append(createdate);
        sb.append(", status=").append(status);
        sb.append(", openid=").append(openid);
        sb.append(", token=").append(token);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}