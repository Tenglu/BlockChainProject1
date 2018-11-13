package com.example.demo.model;

import java.util.Date;

public class WorkOrder {
    private String workOrderNumber;

    private String location;

    private String serviceType;

    private Integer assetsQty;

    private Date time;

    private String incompleteReason;

    private String remarkNotes;

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber == null ? null : workOrderNumber.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public Integer getAssetsQty() {
        return assetsQty;
    }

    public void setAssetsQty(Integer assetsQty) {
        this.assetsQty = assetsQty;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIncompleteReason() {
        return incompleteReason;
    }

    public void setIncompleteReason(String incompleteReason) {
        this.incompleteReason = incompleteReason == null ? null : incompleteReason.trim();
    }

    public String getRemarkNotes() {
        return remarkNotes;
    }

    public void setRemarkNotes(String remarkNotes) {
        this.remarkNotes = remarkNotes == null ? null : remarkNotes.trim();
    }
}