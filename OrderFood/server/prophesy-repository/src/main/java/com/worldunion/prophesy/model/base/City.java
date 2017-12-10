package com.worldunion.prophesy.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class City implements Serializable {
    private Integer cityid;

    private String cityname;

    private String firstname;

    private String gbcode;

    private Long gisid;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Integer provinceid;

    private Date entertime;

    private Date altertime;

    private Date addtime;

    private Date checktime;

    private Long checkid;

    private Long enterid;

    private Long alterid;

    private String status;

    private Long sortnum;

    private String simplespell;

    private BigDecimal leftlatitude;

    private BigDecimal leftlongitude;

    private BigDecimal rightlatitude;

    private BigDecimal rightlongitude;

    private static final long serialVersionUID = 1L;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname == null ? null : firstname.trim();
    }

    public String getGbcode() {
        return gbcode;
    }

    public void setGbcode(String gbcode) {
        this.gbcode = gbcode == null ? null : gbcode.trim();
    }

    public Long getGisid() {
        return gisid;
    }

    public void setGisid(Long gisid) {
        this.gisid = gisid;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Long getCheckid() {
        return checkid;
    }

    public void setCheckid(Long checkid) {
        this.checkid = checkid;
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

    public BigDecimal getLeftlatitude() {
        return leftlatitude;
    }

    public void setLeftlatitude(BigDecimal leftlatitude) {
        this.leftlatitude = leftlatitude;
    }

    public BigDecimal getLeftlongitude() {
        return leftlongitude;
    }

    public void setLeftlongitude(BigDecimal leftlongitude) {
        this.leftlongitude = leftlongitude;
    }

    public BigDecimal getRightlatitude() {
        return rightlatitude;
    }

    public void setRightlatitude(BigDecimal rightlatitude) {
        this.rightlatitude = rightlatitude;
    }

    public BigDecimal getRightlongitude() {
        return rightlongitude;
    }

    public void setRightlongitude(BigDecimal rightlongitude) {
        this.rightlongitude = rightlongitude;
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
        City other = (City) that;
        return (this.getCityid() == null ? other.getCityid() == null : this.getCityid().equals(other.getCityid()))
            && (this.getCityname() == null ? other.getCityname() == null : this.getCityname().equals(other.getCityname()))
            && (this.getFirstname() == null ? other.getFirstname() == null : this.getFirstname().equals(other.getFirstname()))
            && (this.getGbcode() == null ? other.getGbcode() == null : this.getGbcode().equals(other.getGbcode()))
            && (this.getGisid() == null ? other.getGisid() == null : this.getGisid().equals(other.getGisid()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getProvinceid() == null ? other.getProvinceid() == null : this.getProvinceid().equals(other.getProvinceid()))
            && (this.getEntertime() == null ? other.getEntertime() == null : this.getEntertime().equals(other.getEntertime()))
            && (this.getAltertime() == null ? other.getAltertime() == null : this.getAltertime().equals(other.getAltertime()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getCheckid() == null ? other.getCheckid() == null : this.getCheckid().equals(other.getCheckid()))
            && (this.getEnterid() == null ? other.getEnterid() == null : this.getEnterid().equals(other.getEnterid()))
            && (this.getAlterid() == null ? other.getAlterid() == null : this.getAlterid().equals(other.getAlterid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSortnum() == null ? other.getSortnum() == null : this.getSortnum().equals(other.getSortnum()))
            && (this.getSimplespell() == null ? other.getSimplespell() == null : this.getSimplespell().equals(other.getSimplespell()))
            && (this.getLeftlatitude() == null ? other.getLeftlatitude() == null : this.getLeftlatitude().equals(other.getLeftlatitude()))
            && (this.getLeftlongitude() == null ? other.getLeftlongitude() == null : this.getLeftlongitude().equals(other.getLeftlongitude()))
            && (this.getRightlatitude() == null ? other.getRightlatitude() == null : this.getRightlatitude().equals(other.getRightlatitude()))
            && (this.getRightlongitude() == null ? other.getRightlongitude() == null : this.getRightlongitude().equals(other.getRightlongitude()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCityid() == null) ? 0 : getCityid().hashCode());
        result = prime * result + ((getCityname() == null) ? 0 : getCityname().hashCode());
        result = prime * result + ((getFirstname() == null) ? 0 : getFirstname().hashCode());
        result = prime * result + ((getGbcode() == null) ? 0 : getGbcode().hashCode());
        result = prime * result + ((getGisid() == null) ? 0 : getGisid().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getProvinceid() == null) ? 0 : getProvinceid().hashCode());
        result = prime * result + ((getEntertime() == null) ? 0 : getEntertime().hashCode());
        result = prime * result + ((getAltertime() == null) ? 0 : getAltertime().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getCheckid() == null) ? 0 : getCheckid().hashCode());
        result = prime * result + ((getEnterid() == null) ? 0 : getEnterid().hashCode());
        result = prime * result + ((getAlterid() == null) ? 0 : getAlterid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSortnum() == null) ? 0 : getSortnum().hashCode());
        result = prime * result + ((getSimplespell() == null) ? 0 : getSimplespell().hashCode());
        result = prime * result + ((getLeftlatitude() == null) ? 0 : getLeftlatitude().hashCode());
        result = prime * result + ((getLeftlongitude() == null) ? 0 : getLeftlongitude().hashCode());
        result = prime * result + ((getRightlatitude() == null) ? 0 : getRightlatitude().hashCode());
        result = prime * result + ((getRightlongitude() == null) ? 0 : getRightlongitude().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityid=").append(cityid);
        sb.append(", cityname=").append(cityname);
        sb.append(", firstname=").append(firstname);
        sb.append(", gbcode=").append(gbcode);
        sb.append(", gisid=").append(gisid);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", provinceid=").append(provinceid);
        sb.append(", entertime=").append(entertime);
        sb.append(", altertime=").append(altertime);
        sb.append(", addtime=").append(addtime);
        sb.append(", checktime=").append(checktime);
        sb.append(", checkid=").append(checkid);
        sb.append(", enterid=").append(enterid);
        sb.append(", alterid=").append(alterid);
        sb.append(", status=").append(status);
        sb.append(", sortnum=").append(sortnum);
        sb.append(", simplespell=").append(simplespell);
        sb.append(", leftlatitude=").append(leftlatitude);
        sb.append(", leftlongitude=").append(leftlongitude);
        sb.append(", rightlatitude=").append(rightlatitude);
        sb.append(", rightlongitude=").append(rightlongitude);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}