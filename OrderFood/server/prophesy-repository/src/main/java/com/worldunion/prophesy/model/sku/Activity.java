package com.worldunion.prophesy.model.sku;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
    private Integer activityid;

    private Integer activitytypeid;

    private String activitytitle;

    private String picaddr;

    private String activityaddr;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(Integer activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public String getActivitytitle() {
        return activitytitle;
    }

    public void setActivitytitle(String activitytitle) {
        this.activitytitle = activitytitle == null ? null : activitytitle.trim();
    }

    public String getPicaddr() {
        return picaddr;
    }

    public void setPicaddr(String picaddr) {
        this.picaddr = picaddr == null ? null : picaddr.trim();
    }

    public String getActivityaddr() {
        return activityaddr;
    }

    public void setActivityaddr(String activityaddr) {
        this.activityaddr = activityaddr == null ? null : activityaddr.trim();
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
        Activity other = (Activity) that;
        return (this.getActivityid() == null ? other.getActivityid() == null : this.getActivityid().equals(other.getActivityid()))
            && (this.getActivitytypeid() == null ? other.getActivitytypeid() == null : this.getActivitytypeid().equals(other.getActivitytypeid()))
            && (this.getActivitytitle() == null ? other.getActivitytitle() == null : this.getActivitytitle().equals(other.getActivitytitle()))
            && (this.getPicaddr() == null ? other.getPicaddr() == null : this.getPicaddr().equals(other.getPicaddr()))
            && (this.getActivityaddr() == null ? other.getActivityaddr() == null : this.getActivityaddr().equals(other.getActivityaddr()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityid() == null) ? 0 : getActivityid().hashCode());
        result = prime * result + ((getActivitytypeid() == null) ? 0 : getActivitytypeid().hashCode());
        result = prime * result + ((getActivitytitle() == null) ? 0 : getActivitytitle().hashCode());
        result = prime * result + ((getPicaddr() == null) ? 0 : getPicaddr().hashCode());
        result = prime * result + ((getActivityaddr() == null) ? 0 : getActivityaddr().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityid=").append(activityid);
        sb.append(", activitytypeid=").append(activitytypeid);
        sb.append(", activitytitle=").append(activitytitle);
        sb.append(", picaddr=").append(picaddr);
        sb.append(", activityaddr=").append(activityaddr);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}