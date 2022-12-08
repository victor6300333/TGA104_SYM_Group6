package com.administrator.model;

import java.sql.Date;
import java.sql.Timestamp;

public class AdministratorVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer administratorID;
	private String administratorAccount;
	private String administratorPassword;
	private Timestamp buildTime;
	private Timestamp lastLogin;
	private Integer memberID;
	private Integer storeID;
	private Integer storeAuditStatus;
	private String storeName;
	private String storeAddress;
	private String phoneNumber;
	private Date createDate;
	private String taxID;
	public Integer getAdministratorID() {
		return administratorID;
	}
	public void setAdministratorID(Integer administratorID) {
		this.administratorID = administratorID;
	}
	public String getAdministratorAccount() {
		return administratorAccount;
	}
	public void setAdministratorAccount(String administratorAccount) {
		this.administratorAccount = administratorAccount;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
	public Timestamp getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Timestamp buildTime) {
		this.buildTime = buildTime;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Integer getStoreID() {
		return storeID;
	}
	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}
	public Integer getStoreAuditStatus() {
		return storeAuditStatus;
	}
	public void setStoreAuditStatus(Integer storeAuditStatus) {
		this.storeAuditStatus = storeAuditStatus;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}


