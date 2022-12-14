package com.creditCard.model;

import java.io.Serializable;
import java.sql.Date;

public class CreditCardVO implements Serializable {

	private Integer creditCardID;
	private Integer memberID;
	private String creditCardNumber;
	private String securityCode;
	private Date exDate;

	public Integer getCreditCardID() {
		return creditCardID;
	}

	public void setCreditCardID(Integer creditCardID) {
		this.creditCardID = creditCardID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}

}
