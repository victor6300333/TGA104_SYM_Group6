package com.group6.tibame104.group.model;

import java.sql.Timestamp;

public class GroupVO {

	private Integer groupBuyID;
	private Integer groupBuyProductID;
	private Integer administratorID;
	private Integer groupBuyProductOrderTotal;
	private Boolean groupBuyingState;
	private Timestamp groupBuyingOnLoadDate;
	private Timestamp groupBuyingOffLoadDate;
	private Timestamp updateTime;

	@Override
	public String toString() {
		return "groupVO [groupBuyID=" + groupBuyID + ", groupBuyProductID=" + groupBuyProductID
				+ ", administratorID=" + administratorID + ", groupBuyProductOrderTotal=" + groupBuyProductOrderTotal
				+ ", groupBuyingState=" + groupBuyingState + ", groupBuyingOnLoadDate=" + groupBuyingOnLoadDate
				+ ", groupBuyingOffLoadDate=" + groupBuyingOffLoadDate + ", updateTime=" + updateTime + "]";
	}

	public Integer getGroupBuyID() {
		return groupBuyID;
	}

	public void setGroupBuyID(Integer groupBuyID) {
		this.groupBuyID = groupBuyID;
	}

	public Integer getGroupBuyProductID() {
		return groupBuyProductID;
	}

	public void setGroupBuyProductID(Integer groupBuyProductID) {
		this.groupBuyProductID = groupBuyProductID;
	}

	public Integer getAdministratorID() {
		return administratorID;
	}

	public void setAdministratorID(Integer administratorID) {
		this.administratorID = administratorID;
	}

	public Integer getGroupBuyProductOrderTotal() {
		return groupBuyProductOrderTotal;
	}

	public void setGroupBuyProductOrderTotal(Integer groupBuyProductOrderTotal) {
		this.groupBuyProductOrderTotal = groupBuyProductOrderTotal;
	}

	public Boolean getGroupBuyingState() {
		return groupBuyingState;
	}

	public void setGroupBuyingState(Boolean groupBuyingState) {
		this.groupBuyingState = groupBuyingState;
	}

	public Timestamp getGroupBuyingOnLoadDate() {
		return groupBuyingOnLoadDate;
	}

	public void setGroupBuyingOnLoadDate(Timestamp groupBuyingOnLoadDate) {
		this.groupBuyingOnLoadDate = groupBuyingOnLoadDate;
	}

	public Timestamp getGroupBuyingOffLoadDate() {
		return groupBuyingOffLoadDate;
	}

	public void setGroupBuyingOffLoadDate(Timestamp groupBuyingOffLoadDate) {
		this.groupBuyingOffLoadDate = groupBuyingOffLoadDate;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
