package com.group6.tibame104.memberBlockList.model;

import java.io.Serializable;

public class MemberBlockListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer blockListID;
	private Integer memberID;
	private Integer storeID;

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

	public Integer getStoreID() {
		return storeID;
	}

	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}

}
