package com.grouporder.model;


import java.sql.Timestamp;


public class GrouporderVO implements java.io.Serializable {
	private Integer groupBuyOrderID;
	private Integer groupBuyID;
	private Integer memberID;
	private Integer groupBuyProductID;
	private Integer groupBuyQuantity;
	private Integer groupBuyTotal;
	private Timestamp orderTime;
	private String paymentTerm;
	private Integer paymentState;
	private Integer giftVoucher;
	private String contactNumber;
	private String shippingLocation;

	@Override
	public String toString() {
		return "GrouporderVO [groupBuyOrderID=" + groupBuyOrderID + ", groupBuyID=" + groupBuyID + ", memberID="
				+ memberID + ", groupBuyProductID=" + groupBuyProductID + ", groupBuyQuantity=" + groupBuyQuantity
				+ ", groupBuyTotal=" + groupBuyTotal + ", orderTime=" + orderTime + ", paymentTerm=" + paymentTerm
				+ ", paymentState=" + paymentState + ", giftVoucher=" + giftVoucher + ", contactNumber=" + contactNumber
				+ ", shippingLocation=" + shippingLocation + "]";
	}

	public Integer getGroupBuyOrderID() {
		return groupBuyOrderID;
	}

	public void setGroupBuyOrderID(Integer groupBuyOrderID) {
		this.groupBuyOrderID = groupBuyOrderID;
	}

	public Integer getGroupBuyID() {
		return groupBuyID;
	}

	public void setGroupBuyID(Integer groupBuyID) {
		this.groupBuyID = groupBuyID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getGroupBuyProductID() {
		return groupBuyProductID;
	}

	public void setGroupBuyProductID(Integer groupBuyProductID) {
		this.groupBuyProductID = groupBuyProductID;
	}

	public Integer getGroupBuyQuantity() {
		return groupBuyQuantity;
	}

	public void setGroupBuyQuantity(Integer groupBuyQuantity) {
		this.groupBuyQuantity = groupBuyQuantity;
	}

	public Integer getGroupBuyTotal() {
		return groupBuyTotal;
	}

	public void setGroupBuyTotal(Integer groupBuyTotal) {
		this.groupBuyTotal = groupBuyTotal;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Integer getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(Integer paymentState) {
		this.paymentState = paymentState;
	}

	public Integer getGiftVoucher() {
		return giftVoucher;
	}

	public void setGiftVoucher(Integer giftVoucher) {
		this.giftVoucher = giftVoucher;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getShippingLocation() {
		return shippingLocation;
	}

	public void setShippingLocation(String shippingLocation) {
		this.shippingLocation = shippingLocation;
	}

}
