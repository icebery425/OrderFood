package com.worldunion.prophesy.model;

import java.util.Date;

/**
 * Created by liuruiyan on 2017/4/17.
 */
public class CustomerMaintenance {

    private int     serialNumber;//序号
    private String  customerName;//客户
    private String  parentCustomerName;//父客户
    private String  identification;//标识
    private String  operation;//操作
    private Date    lastUpdateDate; //最后需改时间

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getParentCustomerName() {
        return parentCustomerName;
    }

    public void setParentCustomerName(String parentCustomerName) {
        this.parentCustomerName = parentCustomerName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
