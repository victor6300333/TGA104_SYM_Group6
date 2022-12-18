package com.group6.tibame104.memberBlockList.model;

import java.io.Serializable;

public class ViewMemberBlockListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String storeName;
	private Integer blockListID;
	private Integer memberID;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getBlockListID() {
		return blockListID;
	}

	public void setBlockListID(Integer blockListID) {
		this.blockListID = blockListID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

}