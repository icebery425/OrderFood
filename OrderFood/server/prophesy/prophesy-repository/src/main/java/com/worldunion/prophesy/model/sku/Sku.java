package com.worldunion.prophesy.model.sku;

import java.io.Serializable;

public class Sku implements Serializable {
    private Integer skuid;

    private String skuname;

    private Double skuprice;

    private String skudesc;

    private String skupicaddr;

    private Integer skutypeid;

    private String status;
    
    private Double skuamount;
    
    private Double skunum;
    
    private static final long serialVersionUID = 1L;
    
    private String promotionTag;//促销标志
    
    private Double skutotalnum;//商品总数
    
    private Double skumaxnum;//限购数量
    
    private Double skuSurplusnum;//剩余数量
    
    private String onstatus;//实时状态
    
    
    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public String getSkuname() {
        return skuname;
    }

    public void setSkuname(String skuname) {
        this.skuname = skuname == null ? null : skuname.trim();
    }

    public Double getSkuprice() {
        return skuprice;
    }

    public void setSkuprice(Double skuprice) {
        this.skuprice = skuprice;
    }

    public String getSkudesc() {
        return skudesc;
    }

    public void setSkudesc(String skudesc) {
        this.skudesc = skudesc == null ? null : skudesc.trim();
    }

    public String getSkupicaddr() {
        return skupicaddr;
    }

    public void setSkupicaddr(String skupicaddr) {
        this.skupicaddr = skupicaddr == null ? null : skupicaddr.trim();
    }

    public Integer getSkutypeid() {
        return skutypeid;
    }

    public void setSkutypeid(Integer skutypeid) {
        this.skutypeid = skutypeid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Double getSkuamount() {
		return skuamount;
	}

	public void setSkuamount(Double skuamount) {
		this.skuamount = skuamount;
	}

	public Double getSkunum() {
		return skunum;
	}

	public void setSkunum(Double skunum) {
		this.skunum = skunum;
	}

	public String getPromotionTag() {
		return promotionTag;
	}

	public void setPromotionTag(String promotionTag) {
		this.promotionTag = promotionTag;
	}

	public Double getSkutotalnum() {
		return skutotalnum;
	}

	public void setSkutotalnum(Double skutotalnum) {
		this.skutotalnum = skutotalnum;
	}

	public Double getSkumaxnum() {
		return skumaxnum;
	}

	public void setSkumaxnum(Double skumaxnum) {
		this.skumaxnum = skumaxnum;
	}

	public Double getSkuSurplusnum() {
		return skuSurplusnum;
	}

	public void setSkuSurplusnum(Double skuSurplusnum) {
		this.skuSurplusnum = skuSurplusnum;
	}

	public String getOnstatus() {
		return onstatus;
	}

	public void setOnstatus(String onstatus) {
		this.onstatus = onstatus;
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
        Sku other = (Sku) that;
        return (this.getSkuid() == null ? other.getSkuid() == null : this.getSkuid().equals(other.getSkuid()))
            && (this.getSkuname() == null ? other.getSkuname() == null : this.getSkuname().equals(other.getSkuname()))
            && (this.getSkuprice() == null ? other.getSkuprice() == null : this.getSkuprice().equals(other.getSkuprice()))
            && (this.getSkudesc() == null ? other.getSkudesc() == null : this.getSkudesc().equals(other.getSkudesc()))
            && (this.getSkupicaddr() == null ? other.getSkupicaddr() == null : this.getSkupicaddr().equals(other.getSkupicaddr()))
            && (this.getSkutypeid() == null ? other.getSkutypeid() == null : this.getSkutypeid().equals(other.getSkutypeid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSkuid() == null) ? 0 : getSkuid().hashCode());
        result = prime * result + ((getSkuname() == null) ? 0 : getSkuname().hashCode());
        result = prime * result + ((getSkuprice() == null) ? 0 : getSkuprice().hashCode());
        result = prime * result + ((getSkudesc() == null) ? 0 : getSkudesc().hashCode());
        result = prime * result + ((getSkupicaddr() == null) ? 0 : getSkupicaddr().hashCode());
        result = prime * result + ((getSkutypeid() == null) ? 0 : getSkutypeid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skuid=").append(skuid);
        sb.append(", skuname=").append(skuname);
        sb.append(", skuprice=").append(skuprice);
        sb.append(", skudesc=").append(skudesc);
        sb.append(", skupicaddr=").append(skupicaddr);
        sb.append(", skutypeid=").append(skutypeid);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}