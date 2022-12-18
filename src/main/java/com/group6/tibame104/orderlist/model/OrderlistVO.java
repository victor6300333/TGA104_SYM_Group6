package com.group6.tibame104.orderlist.model;

public class OrderlistVO {
	Integer orderDetailID;
	Integer orderID;
    Integer productID;
    String productName;
	Integer quantity;
    Integer price;
    Integer subTotal;
    String shopReview;
    String shopComment;
    String buyerReview;
    String buyerComment;
    
  
    
    public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(Integer orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
	public String getShopReview() {
		return shopReview;
	}
	public void setShopReview(String shopReview) {
		this.shopReview = shopReview;
	}
	public String getShopComment() {
		return shopComment;
	}
	public void setShopComment(String shopComment) {
		this.shopComment = shopComment;
	}
	public String getBuyerReview() {
		return buyerReview;
	}
	public void setBuyerReview(String buyerReview) {
		this.buyerReview = buyerReview;
	}
	public String getBuyerComment() {
		return buyerComment;
	}
	public void setBuyerComment(String buyerComment) {
		this.buyerComment = buyerComment;
	}
}
