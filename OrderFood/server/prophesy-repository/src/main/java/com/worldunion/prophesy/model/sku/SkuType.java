package com.worldunion.prophesy.model.sku;

import java.io.Serializable;

public class SkuType implements Serializable {
    private Integer skutypeid;

    private String typename;

    private String typedesc;

    private String typeaddr;

    private static final long serialVersionUID = 1L;

    public Integer getSkutypeid() {
        return skutypeid;
    }

    public void setSkutypeid(Integer skutypeid) {
        this.skutypeid = skutypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getTypedesc() {
        return typedesc;
    }

    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc;
    }

    public String getTypeaddr() {
        return typeaddr;
    }

    public void setTypeaddr(String typeaddr) {
        this.typeaddr = typeaddr == null ? null : typeaddr.trim();
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
        SkuType other = (SkuType) that;
        return (this.getSkutypeid() == null ? other.getSkutypeid() == null : this.getSkutypeid().equals(other.getSkutypeid()))
            && (this.getTypename() == null ? other.getTypename() == null : this.getTypename().equals(other.getTypename()))
            && (this.getTypedesc() == null ? other.getTypedesc() == null : this.getTypedesc().equals(other.getTypedesc()))
            && (this.getTypeaddr() == null ? other.getTypeaddr() == null : this.getTypeaddr().equals(other.getTypeaddr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSkutypeid() == null) ? 0 : getSkutypeid().hashCode());
        result = prime * result + ((getTypename() == null) ? 0 : getTypename().hashCode());
        result = prime * result + ((getTypedesc() == null) ? 0 : getTypedesc().hashCode());
        result = prime * result + ((getTypeaddr() == null) ? 0 : getTypeaddr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skutypeid=").append(skutypeid);
        sb.append(", typename=").append(typename);
        sb.append(", typedesc=").append(typedesc);
        sb.append(", typeaddr=").append(typeaddr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}