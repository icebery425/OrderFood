package com.worldunion.prophesy.model.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Staff implements Serializable {
    private Long staffid;

    private String staffname;

    private String email;

    private String password;

    private Integer state;

    private String createtime;

    private String staffcode;

    private static final long serialVersionUID = 1L;

    //用户所在的组
    private List<Group> groupsList = new ArrayList<Group>();


    public List<Group> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<Group> groupsList) {
        this.groupsList = groupsList;
    }
    
    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    
    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode == null ? null : staffcode.trim();
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
        Staff other = (Staff) that;
        return (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getStaffname() == null ? other.getStaffname() == null : this.getStaffname().equals(other.getStaffname()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getStaffcode() == null ? other.getStaffcode() == null : this.getStaffcode().equals(other.getStaffcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getStaffname() == null) ? 0 : getStaffname().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getStaffcode() == null) ? 0 : getStaffcode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffid=").append(staffid);
        sb.append(", staffname=").append(staffname);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", state=").append(state);
        sb.append(", createtime=").append(createtime);
        sb.append(", staffcode=").append(staffcode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}