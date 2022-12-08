package com.creditCard.model;

import java.sql.Date;
import java.util.List;

public class CreditCardService {

	private CreditCardVO_interface dao;

	public CreditCardService() {
		dao = new CreditCardJDBCDAO();
	}

	public CreditCardVO addCreditCard(Integer memberId, String creditCardNumber, String securityCode, Date exDate) {

		CreditCardVO creditCardVO = new CreditCardVO();

		creditCardVO.setMemberId(memberId);
		creditCardVO.setCreditCardNumber(creditCardNumber);
		creditCardVO.setSecurityCode(securityCode);
		creditCardVO.setExDate(exDate);
		dao.insert(creditCardVO);

		return creditCardVO;
	}

	public CreditCardVO updateCreditCard(String creditCardNumber, String securityCode, Date exDate,
			Integer creditCardId) {
		CreditCardVO creditCardVO = new CreditCardVO();

		creditCardVO.setCreditCardNumber(creditCardNumber);
		creditCardVO.setSecurityCode(securityCode);
		creditCardVO.setExDate(exDate);
		creditCardVO.setMemberId(creditCardId);

		dao.update(creditCardVO);

		return creditCardVO;
	}

	public void deletecreditCard(Integer creditCardId) {
		dao.delete(creditCardId);
	}

	public List<CreditCardVO> getAll(Integer memberId) {
		return dao.getAll(memberId);
	}

//	public static void main(String[] args) {
//		CreditCardService creditCardService = new CreditCardService();
//
//		creditCardService.addCreditCard(2, "hh", "hh", java.sql.Date.valueOf("1993-01-02"));

//	}

}
