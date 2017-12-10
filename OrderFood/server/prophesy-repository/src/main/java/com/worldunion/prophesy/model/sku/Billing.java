package com.worldunion.prophesy.model.sku;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Billing implements Serializable {
    private Integer billid;

    private String billcode;

    private Double totalprice;

    private String custmessage;

    private String sengtype;

    private Integer userid;

    private String contactway;

    private String shippingaddress;

    private String status;

    private String paystatus;

    private String paytype;

    private String contactname;

    private Date shippingdate;

    private Date createdate;
    
    private Double freightAmount;
    private Double discountAmount;
    private Double paidAmount;
    private List<Sku> items;
    private String WeChatnickname;
    private String	mobile;
    private static final long serialVersionUID = 1L;

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode == null ? null : billcode.trim();
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getCustmessage() {
        return custmessage;
    }

    public void setCustmessage(String custmessage) {
        this.custmessage = custmessage == null ? null : custmessage.trim();
    }

    public String getSengtype() {
        return sengtype;
    }

    public void setSengtype(String sengtype) {
        this.sengtype = sengtype == null ? null : sengtype.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContactway() {
        return contactway;
    }

    public void setContactway(String contactway) {
        this.contactway = contactway == null ? null : contactway.trim();
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress == null ? null : shippingaddress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    public Date getShippingdate() {
        return shippingdate;
    }

    public void setShippingdate(Date shippingdate) {
        this.shippingdate = shippingdate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Double getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(Double freightAmount) {
		this.freightAmount = freightAmount;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public List<Sku> getItems() {
		return items;
	}

	public void setItems(List<Sku> items) {
		this.items = items;
	}

	public String getWeChatnickname() {
		return WeChatnickname;
	}

	public void setWeChatnickname(String weChatnickname) {
		WeChatnickname = weChatnickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
        Billing other = (Billing) that;
        return (this.getBillid() == null ? other.getBillid() == null : this.getBillid().equals(other.getBillid()))
            && (this.getBillcode() == null ? other.getBillcode() == null : this.getBillcode().equals(other.getBillcode()))
            && (this.getTotalprice() == null ? other.getTotalprice() == null : this.getTotalprice().equals(other.getTotalprice()))
            && (this.getCustmessage() == null ? other.getCustmessage() == null : this.getCustmessage().equals(other.getCustmessage()))
            && (this.getSengtype() == null ? other.getSengtype() == null : this.getSengtype().equals(other.getSengtype()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getContactway() == null ? other.getContactway() == null : this.getContactway().equals(other.getContactway()))
            && (this.getShippingaddress() == null ? other.getShippingaddress() == null : this.getShippingaddress().equals(other.getShippingaddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPaystatus() == null ? other.getPaystatus() == null : this.getPaystatus().equals(other.getPaystatus()))
            && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()))
            && (this.getContactname() == null ? other.getContactname() == null : this.getContactname().equals(other.getContactname()))
            && (this.getShippingdate() == null ? other.getShippingdate() == null : this.getShippingdate().equals(other.getShippingdate()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillid() == null) ? 0 : getBillid().hashCode());
        result = prime * result + ((getBillcode() == null) ? 0 : getBillcode().hashCode());
        result = prime * result + ((getTotalprice() == null) ? 0 : getTotalprice().hashCode());
        result = prime * result + ((getCustmessage() == null) ? 0 : getCustmessage().hashCode());
        result = prime * result + ((getSengtype() == null) ? 0 : getSengtype().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getContactway() == null) ? 0 : getContactway().hashCode());
        result = prime * result + ((getShippingaddress() == null) ? 0 : getShippingaddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPaystatus() == null) ? 0 : getPaystatus().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        result = prime * result + ((getContactname() == null) ? 0 : getContactname().hashCode());
        result = prime * result + ((getShippingdate() == null) ? 0 : getShippingdate().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billid=").append(billid);
        sb.append(", billcode=").append(billcode);
        sb.append(", totalprice=").append(totalprice);
        sb.append(", custmessage=").append(custmessage);
        sb.append(", sengtype=").append(sengtype);
        sb.append(", userid=").append(userid);
        sb.append(", contactway=").append(contactway);
        sb.append(", shippingaddress=").append(shippingaddress);
        sb.append(", status=").append(status);
        sb.append(", paystatus=").append(paystatus);
        sb.append(", paytype=").append(paytype);
        sb.append(", contactname=").append(contactname);
        sb.append(", shippingdate=").append(shippingdate);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}