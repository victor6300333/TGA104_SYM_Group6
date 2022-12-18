package com.group6.tibame104.member.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class MemberVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer memberID;
	private String userAccount;
	private String userPassword;
	private String userName;
	private String phone;
	private String mail;
	private String gender;
	private Date birthday;
	private byte[] userPhoto;
	private Timestamp registrationTime;
	private Boolean mailCertification;
	private String idNumber;
	private String address;
	private Boolean sellerAuditApprovalState;
	private Integer currentShoppingCoin;

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public byte[] getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Timestamp getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Boolean getMailCertification() {
		return mailCertification;
	}

	public void setMailCertification(Boolean mailCertification) {
		this.mailCertification = mailCertification;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getSellerAuditApprovalState() {
		return sellerAuditApprovalState;
	}

	public void setSellerAuditApprovalState(Boolean sellerAuditApprovalState) {
		this.sellerAuditApprovalState = sellerAuditApprovalState;
	}

	public Integer getCurrentShoppingCoin() {
		return currentShoppingCoin;
	}

	public void setCurrentShoppingCoin(Integer currentShoppingCoin) {
		this.currentShoppingCoin = currentShoppingCoin;
	}

}
