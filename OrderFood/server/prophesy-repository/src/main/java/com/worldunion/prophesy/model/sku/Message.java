package com.worldunion.prophesy.model.sku;

import java.io.Serializable;

public class Message implements Serializable {
    private Integer messageid;

    private Integer messagetypeid;

    private String messagetitle;

    private String messagedesc;
    
    private String isRead;
    
    private Integer userid;
    

    private static final long serialVersionUID = 1L;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getMessagetypeid() {
        return messagetypeid;
    }

    public void setMessagetypeid(Integer messagetypeid) {
        this.messagetypeid = messagetypeid;
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle == null ? null : messagetitle.trim();
    }

    public String getMessagedesc() {
        return messagedesc;
    }

    public void setMessagedesc(String messagedesc) {
        this.messagedesc = messagedesc == null ? null : messagedesc.trim();
    }

    public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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
        Message other = (Message) that;
        return (this.getMessageid() == null ? other.getMessageid() == null : this.getMessageid().equals(other.getMessageid()))
            && (this.getMessagetypeid() == null ? other.getMessagetypeid() == null : this.getMessagetypeid().equals(other.getMessagetypeid()))
            && (this.getMessagetitle() == null ? other.getMessagetitle() == null : this.getMessagetitle().equals(other.getMessagetitle()))
            && (this.getMessagedesc() == null ? other.getMessagedesc() == null : this.getMessagedesc().equals(other.getMessagedesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageid() == null) ? 0 : getMessageid().hashCode());
        result = prime * result + ((getMessagetypeid() == null) ? 0 : getMessagetypeid().hashCode());
        result = prime * result + ((getMessagetitle() == null) ? 0 : getMessagetitle().hashCode());
        result = prime * result + ((getMessagedesc() == null) ? 0 : getMessagedesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageid=").append(messageid);
        sb.append(", messagetypeid=").append(messagetypeid);
        sb.append(", messagetitle=").append(messagetitle);
        sb.append(", messagedesc=").append(messagedesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}