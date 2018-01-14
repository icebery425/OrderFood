package com.worldunion.prophesy.model.account;

import java.io.Serializable;

public class GroupStaff implements Serializable {
    private String id;

    private String fkGroupId;

    private Integer staffid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkGroupId() {
        return fkGroupId;
    }

    public void setFkGroupId(String fkGroupId) {
        this.fkGroupId = fkGroupId == null ? null : fkGroupId.trim();
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
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
        GroupStaff other = (GroupStaff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFkGroupId() == null ? other.getFkGroupId() == null : this.getFkGroupId().equals(other.getFkGroupId()))
            && (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFkGroupId() == null) ? 0 : getFkGroupId().hashCode());
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fkGroupId=").append(fkGroupId);
        sb.append(", staffid=").append(staffid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}