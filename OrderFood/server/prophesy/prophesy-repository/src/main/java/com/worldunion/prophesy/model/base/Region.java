package com.worldunion.prophesy.model.base;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by 0141434 on 2015/12/1.
 */
public class Region implements Serializable {


    private Long regionid;


    private String regionname;


    private String regioncode;


    private Integer countyid;


    private Long gisid;


    private Date addtime;


    private Date entertime;

    private Date altertime;


    private Date checktime;


    private Long enterid;


    private Long checkid;


    private Long alterid;


    private String status;

    private Long sortnum;

    private String simplespell;


    private String fullspell;
    
    private Double longitude;
    private Double latitude;

    //Extra Add filed
    private static final long serialVersionUID = 1L;


    public Long getRegionid() {
        return regionid;
    }


    public void setRegionid(Long regionid) {
        this.regionid = regionid;
    }


    public String getRegionname() {
        return regionname;
    }


    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }


    public String getRegioncode() {
        return regioncode;
    }


    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode == null ? null : regioncode.trim();
    }


    public Integer getCountyid() {
        return countyid;
    }


    public void setCountyid(Integer countyid) {
        this.countyid = countyid;
    }


    public Long getGisid() {
        return gisid;
    }

    public void setGisid(Long gisid) {
        this.gisid = gisid;
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


    public Date getChecktime() {
        return checktime;
    }


    public void setChecktime(Date checktime) {
        this.checktime = checktime;
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


    public String getSimplespell() {
        return simplespell;
    }


    public void setSimplespell(String simplespell) {
        this.simplespell = simplespell == null ? null : simplespell.trim();
    }


    public String getFullspell() {
        return fullspell;
    }


    public void setFullspell(String fullspell) {
        this.fullspell = fullspell == null ? null : fullspell.trim();
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
        Region other = (Region) that;
        return (this.getRegionid() == null ? other.getRegionid() == null : this.getRegionid().equals(other.getRegionid()))
                && (this.getRegionname() == null ? other.getRegionname() == null : this.getRegionname().equals(other.getRegionname()))
                && (this.getRegioncode() == null ? other.getRegioncode() == null : this.getRegioncode().equals(other.getRegioncode()))
                && (this.getCountyid() == null ? other.getCountyid() == null : this.getCountyid().equals(other.getCountyid()))
                && (this.getGisid() == null ? other.getGisid() == null : this.getGisid().equals(other.getGisid()))
                && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
                && (this.getEntertime() == null ? other.getEntertime() == null : this.getEntertime().equals(other.getEntertime()))
                && (this.getAltertime() == null ? other.getAltertime() == null : this.getAltertime().equals(other.getAltertime()))
                && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
                && (this.getEnterid() == null ? other.getEnterid() == null : this.getEnterid().equals(other.getEnterid()))
                && (this.getCheckid() == null ? other.getCheckid() == null : this.getCheckid().equals(other.getCheckid()))
                && (this.getAlterid() == null ? other.getAlterid() == null : this.getAlterid().equals(other.getAlterid()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getSortnum() == null ? other.getSortnum() == null : this.getSortnum().equals(other.getSortnum()))
                && (this.getSimplespell() == null ? other.getSimplespell() == null : this.getSimplespell().equals(other.getSimplespell()))
                && (this.getFullspell() == null ? other.getFullspell() == null : this.getFullspell().equals(other.getFullspell()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TPM_REGION
     *
     * @mbggenerated Mon Nov 30 11:27:17 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegionid() == null) ? 0 : getRegionid().hashCode());
        result = prime * result + ((getRegionname() == null) ? 0 : getRegionname().hashCode());
        result = prime * result + ((getRegioncode() == null) ? 0 : getRegioncode().hashCode());
        result = prime * result + ((getCountyid() == null) ? 0 : getCountyid().hashCode());
        result = prime * result + ((getGisid() == null) ? 0 : getGisid().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getEntertime() == null) ? 0 : getEntertime().hashCode());
        result = prime * result + ((getAltertime() == null) ? 0 : getAltertime().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getEnterid() == null) ? 0 : getEnterid().hashCode());
        result = prime * result + ((getCheckid() == null) ? 0 : getCheckid().hashCode());
        result = prime * result + ((getAlterid() == null) ? 0 : getAlterid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSortnum() == null) ? 0 : getSortnum().hashCode());
        result = prime * result + ((getSimplespell() == null) ? 0 : getSimplespell().hashCode());
        result = prime * result + ((getFullspell() == null) ? 0 : getFullspell().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TPM_REGION
     *
     * @mbggenerated Mon Nov 30 11:27:17 CST 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", regionid=").append(regionid);
        sb.append(", regionname=").append(regionname);
        sb.append(", regioncode=").append(regioncode);
        sb.append(", countyid=").append(countyid);
        sb.append(", gisid=").append(gisid);
        sb.append(", addtime=").append(addtime);
        sb.append(", entertime=").append(entertime);
        sb.append(", altertime=").append(altertime);
        sb.append(", checktime=").append(checktime);
        sb.append(", enterid=").append(enterid);
        sb.append(", checkid=").append(checkid);
        sb.append(", alterid=").append(alterid);
        sb.append(", status=").append(status);
        sb.append(", sortnum=").append(sortnum);
        sb.append(", simplespell=").append(simplespell);
        sb.append(", fullspell=").append(fullspell);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	/**
	 * 扩展字段
	 */
    private String countyname;//区县名称
    private Long citytype;//类型
    private Long baseId;//匹配ID
	public String getCountyname() {
		return countyname;
	}


	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}


	public Long getCitytype() {
		return citytype;
	}


	public void setCitytype(Long citytype) {
		this.citytype = citytype;
	}


	public Long getBaseId() {
		return baseId;
	}


	public void setBaseId(Long baseId) {
		this.baseId = baseId;
	}
    /**
     * 扩展字段
     */
	private Long cityid;


	public Long getCityid() {
		return cityid;
	}


	public void setCityid(Long cityid) {
		this.cityid = cityid;
	}




	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
}
