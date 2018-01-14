package com.worldunion.prophesy.model.account;

import java.io.Serializable;
import java.util.Date;

public class StaffDataright implements Serializable {
    private Integer staffdatarightid;

    private Integer staffid;

    private Integer dataid;

    private String dataname;

    private String firstname;

    private Integer datarighttypeid;

    private Integer datarightdimid;

    private Date entertime;

    private Date checktime;

    private Date altertime;

    private String status;

    private Long enterid;

    private Long alterid;

    private static final long serialVersionUID = 1L;

    public Integer getStaffdatarightid() {
        return staffdatarightid;
    }

    public void setStaffdatarightid(Integer staffdatarightid) {
        this.staffdatarightid = staffdatarightid;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Integer getDatarighttypeid() {
        return datarighttypeid;
    }

    public void setDatarighttypeid(Integer datarighttypeid) {
        this.datarighttypeid = datarighttypeid;
    }

    public Integer getDatarightdimid() {
        return datarightdimid;
    }

    public void setDatarightdimid(Integer datarightdimid) {
        this.datarightdimid = datarightdimid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getDataname() {
		return dataname;
	}

	public void setDataname(String dataname) {
		this.dataname = dataname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
        StaffDataright other = (StaffDataright) that;
        return (this.getStaffdatarightid() == null ? other.getStaffdatarightid() == null : this.getStaffdatarightid().equals(other.getStaffdatarightid()))
            && (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getDataid() == null ? other.getDataid() == null : this.getDataid().equals(other.getDataid()))
            && (this.getDatarighttypeid() == null ? other.getDatarighttypeid() == null : this.getDatarighttypeid().equals(other.getDatarighttypeid()))
            && (this.getDatarightdimid() == null ? other.getDatarightdimid() == null : this.getDatarightdimid().equals(other.getDatarightdimid()))
            && (this.getEntertime() == null ? other.getEntertime() == null : this.getEntertime().equals(other.getEntertime()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getAltertime() == null ? other.getAltertime() == null : this.getAltertime().equals(other.getAltertime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEnterid() == null ? other.getEnterid() == null : this.getEnterid().equals(other.getEnterid()))
            && (this.getAlterid() == null ? other.getAlterid() == null : this.getAlterid().equals(other.getAlterid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStaffdatarightid() == null) ? 0 : getStaffdatarightid().hashCode());
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getDataid() == null) ? 0 : getDataid().hashCode());
        result = prime * result + ((getDatarighttypeid() == null) ? 0 : getDatarighttypeid().hashCode());
        result = prime * result + ((getDatarightdimid() == null) ? 0 : getDatarightdimid().hashCode());
        result = prime * result + ((getEntertime() == null) ? 0 : getEntertime().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getAltertime() == null) ? 0 : getAltertime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEnterid() == null) ? 0 : getEnterid().hashCode());
        result = prime * result + ((getAlterid() == null) ? 0 : getAlterid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffdatarightid=").append(staffdatarightid);
        sb.append(", staffid=").append(staffid);
        sb.append(", dataid=").append(dataid);
        sb.append(", datarighttypeid=").append(datarighttypeid);
        sb.append(", datarightdimid=").append(datarightdimid);
        sb.append(", entertime=").append(entertime);
        sb.append(", checktime=").append(checktime);
        sb.append(", altertime=").append(altertime);
        sb.append(", status=").append(status);
        sb.append(", enterid=").append(enterid);
        sb.append(", alterid=").append(alterid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}