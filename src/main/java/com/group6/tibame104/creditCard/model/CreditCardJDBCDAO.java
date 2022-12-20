package com.group6.tibame104.creditCard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardJDBCDAO implements CreditCardDAO_interface {

	@Autowired
	private DataSource dataSource;

	private static final String INSERT_STMT = "INSERT INTO creditCard (memberID,creditcardNumber,securityCode,exDate)"
			+ " VALUES (?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT creditCardID,memberID,creditcardNumber,securityCode,exDate FROM creditCard where memberID = ?";

	private static final String DELETE = "DELETE FROM creditCard where creditCardID = ?";

	private static final String UPDATE = "UPDATE creditCard set creditcardNumber=?, securityCode=?, exDate=? where creditCardID = ?";

	@Override
	public void insert(CreditCardVO creditCardVO) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);

		) {

			pstmt.setInt(1, creditCardVO.getMemberID());
			pstmt.setString(2, creditCardVO.getCreditCardNumber());
			pstmt.setString(3, creditCardVO.getSecurityCode());
			pstmt.setDate(4, creditCardVO.getExDate());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CreditCardVO creditCardVO) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE);

		) {

			pstmt.setString(1, creditCardVO.getCreditCardNumber());
			pstmt.setString(2, creditCardVO.getSecurityCode());
			pstmt.setDate(3, creditCardVO.getExDate());
			pstmt.setInt(4, creditCardVO.getCreditCardID());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer creditCardID) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(DELETE);

		) {

			pstmt.setInt(1, creditCardID);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CreditCardVO findByPrimaryKey(Integer memberID) {
		return null;
	}

	@Override
	public List<CreditCardVO> getAll(Integer memberID) {
		CreditCardVO ceditCardVO = null;
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);) {
			pstmt.setInt(1, memberID);
			try (ResultSet rs = pstmt.executeQuery();) {
				List<CreditCardVO> list = new ArrayList<CreditCardVO>();

				while (rs.next()) {

					ceditCardVO = new CreditCardVO();
					ceditCardVO.setMemberID(rs.getInt("memberID"));
					ceditCardVO.setCreditCardID(rs.getInt("creditCardID"));
					ceditCardVO.setCreditCardNumber(rs.getString("creditCardNumber"));
					ceditCardVO.setSecurityCode(rs.getString("securityCode"));
					ceditCardVO.setExDate(rs.getDate("exDate"));
					list.add(ceditCardVO); // Store the row in the list
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// test
//	public static void main(String[] args) {
//
//		CreditCardJDBCDAO dao = new CreditCardJDBCDAO();
//
//		// 新增
//		CreditCardVO crdVO1 = new CreditCardVO();
//		crdVO1.setMemberId(1);
//		crdVO1.setCreditCardNumber("QWER4534522");
//		crdVO1.setSecurityCode("567");
//		crdVO1.setExDate(java.sql.Date.valueOf("1993-01-02"));
//		dao.insert(crdVO1);

////		 修改
//		CreditCardVO crdVO2 = new CreditCardVO();
//		crdVO2.setCreditCardNumber("ASD2325245");
//		crdVO2.setSecurityCode("ddd");
//		crdVO2.setExDate(java.sql.Date.valueOf("2023-01-02"));
//		crdVO2.setCreditCardId(2);
//		dao.update(crdVO2);

//		// 刪除
//		dao.delete(9);

//		// 查詢
//		List<CreditCardVO> list = dao.getAll(1);
//		for (CreditCardVO amem : list) {
//			System.out.print(amem.getCreditCardId() + ",");
//			System.out.print(amem.getMemberId() + ",");
//			System.out.print(amem.getCreditCardNumber() + ",");
//			System.out.print(amem.getSecurityCode() + ",");
//			System.out.println(amem.getExDate() + ",");
//			System.out.println("---------------------");
//		}
//	}

}
