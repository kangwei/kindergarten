package com.titian.core.domain;

import java.util.Date;

public class Organization {
    private String orgId;

    private String orgName;

    private String motto;

    private String introduce;

    private Date createTime;

    private Date updateTime;

    private String status;

    private String orgType;

    private String orgAddress;

    private String orgMaster;

    private String orgMasterMobile;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto == null ? null : motto.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public String getOrgMaster() {
        return orgMaster;
    }

    public void setOrgMaster(String orgMaster) {
        this.orgMaster = orgMaster == null ? null : orgMaster.trim();
    }

    public String getOrgMasterMobile() {
        return orgMasterMobile;
    }

    public void setOrgMasterMobile(String orgMasterMobile) {
        this.orgMasterMobile = orgMasterMobile == null ? null : orgMasterMobile.trim();
    }
}