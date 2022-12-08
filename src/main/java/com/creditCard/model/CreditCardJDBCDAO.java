package com.creditCard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditCardJDBCDAO implements CreditCardVO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO creditCard (memberID,creditcardNumber,securityCode,exDate)"
			+ " VALUES (?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT creditCardID,memberID,creditcardNumber,securityCode,exDate FROM creditCard where memberID = ?";

//	private static final String GET_ONE_STMT = "SELECT creditCardID,memberID,creditcardNumber,securityCode,exDate FROM creditCard where memberID = ?";

	private static final String DELETE = "DELETE FROM creditCard where creditCardID = ?";

	private static final String UPDATE = "UPDATE creditCard set creditcardNumber=?, securityCode=?, exDate=? where creditCardID = ?";

	@Override
	public void insert(CreditCardVO creditCardVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, creditCardVO.getMemberId());
			pstmt.setString(2, creditCardVO.getCreditCardNumber());
			pstmt.setString(3, creditCardVO.getSecurityCode());
			pstmt.setDate(4, creditCardVO.getExDate());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(CreditCardVO creditCardVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, creditCardVO.getCreditCardNumber());
			pstmt.setString(2, creditCardVO.getSecurityCode());
			pstmt.setDate(3, creditCardVO.getExDate());
			pstmt.setInt(4, creditCardVO.getCreditCardId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer creditCardId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, creditCardId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public CreditCardVO findByPrimaryKey(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditCardVO> getAll(Integer memberId) {
		List<CreditCardVO> list = new ArrayList<CreditCardVO>();
		CreditCardVO ceditCardVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberVO 也稱為 Domain objects
				ceditCardVO = new CreditCardVO();
				ceditCardVO.setMemberId(rs.getInt("memberId"));
				ceditCardVO.setCreditCardId(rs.getInt("creditCardId"));
				ceditCardVO.setCreditCardNumber(rs.getString("creditCardNumber"));
				ceditCardVO.setSecurityCode(rs.getString("securityCode"));
				ceditCardVO.setExDate(rs.getDate("exDate"));
				list.add(ceditCardVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
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
