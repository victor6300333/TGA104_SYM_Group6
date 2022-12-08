package com.groupBuying.model;
import java.sql.Date;
import java.sql.Timestamp;

public class GroupBuyingVO implements java.io.Serializable {
	private Integer groupBuyID;
	private Integer groupBuyProductID;
	private Integer administratorID;
	private Integer groupBuyProductOrderTotal;
	private Boolean groupBuyingState;
	private Date groupBuyingOnLoadDate;
	private Date groupBuyingOffLoadDate;
	private Timestamp updateTime;
	
	
	@Override
	public String toString() {
		return "GroupBuyingVO [groupBuyID=" + groupBuyID + ", groupBuyProductID=" + groupBuyProductID
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
	public Date getGroupBuyingOnLoadDate() {
		return groupBuyingOnLoadDate;
	}
	public void setGroupBuyingOnLoadDate(Date groupBuyingOnLoadDate) {
		this.groupBuyingOnLoadDate = groupBuyingOnLoadDate;
	}
	public Date getGroupBuyingOffLoadDate() {
		return groupBuyingOffLoadDate;
	}
	public void setGroupBuyingOffLoadDate(Date groupBuyingOffLoadDate) {
		this.groupBuyingOffLoadDate = groupBuyingOffLoadDate;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	
}
