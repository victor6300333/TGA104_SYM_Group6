package com.groupproduct.model;

import java.util.Arrays;

public class GroupproductVO implements java.io.Serializable {

	private Integer groupBuyProductID;
	private Integer groupBuyProductPrice;
	private byte[] groupBuyProductPicture;
	private String groupBuyProductDescrip;
	
	@Override
	public String toString() {
		return "GroupproductVO [groupBuyProductID=" + groupBuyProductID + ", groupBuyProductPrice="
				+ groupBuyProductPrice + ", groupBuyProductPicture=" + Arrays.toString(groupBuyProductPicture)
				+ ", groupBuyProductDescrip=" + groupBuyProductDescrip + "]";
	}
	public Integer getGroupBuyProductID() {
		return groupBuyProductID;
	}
	public void setGroupBuyProductID(Integer groupBuyProductID) {
		this.groupBuyProductID = groupBuyProductID;
	}
	public Integer getGroupBuyProductPrice() {
		return groupBuyProductPrice;
	}
	public void setGroupBuyProductPrice(Integer groupBuyProductPrice) {
		this.groupBuyProductPrice = groupBuyProductPrice;
	}
	public byte[] getGroupBuyProductPicture() {
		return groupBuyProductPicture;
	}
	public void setGroupBuyProductPicture(byte[] groupBuyProductPicture) {
		this.groupBuyProductPicture = groupBuyProductPicture;
	}
	public String getGroupBuyProductDescrip() {
		return groupBuyProductDescrip;
	}
	public void setGroupBuyProductDescrip(String groupBuyProductDescrip) {
		this.groupBuyProductDescrip = groupBuyProductDescrip;
	}

	
}
