package com.worldunion.prophesy.model.sku;

import java.io.Serializable;
import java.util.Date;

public class UserAddr implements Serializable {
    private Integer useraddrid;

    private Integer userid;

    private String contactaddr;

    private String contactmoblie;

    private String contactname;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Integer getUseraddrid() {
        return useraddrid;
    }

    public void setUseraddrid(Integer useraddrid) {
        this.useraddrid = useraddrid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContactaddr() {
        return contactaddr;
    }

    public void setContactaddr(String contactaddr) {
        this.contactaddr = contactaddr == null ? null : contactaddr.trim();
    }

    public String getContactmoblie() {
        return contactmoblie;
    }

    public void setContactmoblie(String contactmoblie) {
        this.contactmoblie = contactmoblie == null ? null : contactmoblie.trim();
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
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
        UserAddr other = (UserAddr) that;
        return (this.getUseraddrid() == null ? other.getUseraddrid() == null : this.getUseraddrid().equals(other.getUseraddrid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getContactaddr() == null ? other.getContactaddr() == null : this.getContactaddr().equals(other.getContactaddr()))
            && (this.getContactmoblie() == null ? other.getContactmoblie() == null : this.getContactmoblie().equals(other.getContactmoblie()))
            && (this.getContactname() == null ? other.getContactname() == null : this.getContactname().equals(other.getContactname()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUseraddrid() == null) ? 0 : getUseraddrid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getContactaddr() == null) ? 0 : getContactaddr().hashCode());
        result = prime * result + ((getContactmoblie() == null) ? 0 : getContactmoblie().hashCode());
        result = prime * result + ((getContactname() == null) ? 0 : getContactname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", useraddrid=").append(useraddrid);
        sb.append(", userid=").append(userid);
        sb.append(", contactaddr=").append(contactaddr);
        sb.append(", contactmoblie=").append(contactmoblie);
        sb.append(", contactname=").append(contactname);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}