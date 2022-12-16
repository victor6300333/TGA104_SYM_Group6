package com.couponUsageHistory.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CouponUsageHistoryJDBCDAO implements CouponUsageHistoryDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = "INSERT INTO couponUsageHistory (memberID, couponID, usageRecord, useDate) VALUES (?, ?, ?, ?);";
	private static final String GET_ALL_STMT = "SELECT memberID,couponID,usageRecord,useDate FROM couponUsageHistory;";
	private static final String GET_ONE_STMT = "SELECT memberID, couponID, usageRecord, useDate FROM couponUsageHistory where memberID=?;";
	
	@Override
	public void insert(CouponUsageHistoryVO couponUsageHistoryVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, couponUsageHistoryVO.getMemberID());
			pstmt.setInt(2, couponUsageHistoryVO.getCouponID());
			pstmt.setInt(3, couponUsageHistoryVO.getUsageRecord());
			pstmt.setTimestamp(4, couponUsageHistoryVO.getUseDate());
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
	public CouponUsageHistoryVO findByPrimaryKey(Integer memberID) {

		CouponUsageHistoryVO couponUsageHistoryVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO 也稱為 Domain objects
				couponUsageHistoryVO = new CouponUsageHistoryVO();
				couponUsageHistoryVO.setMemberID(rs.getInt("memberID"));
				couponUsageHistoryVO.setCouponID(rs.getInt("couponID"));
				couponUsageHistoryVO.setUsageRecord(rs.getInt("usageRecord"));
				couponUsageHistoryVO.setUseDate(rs.getTimestamp("useDate"));			
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return couponUsageHistoryVO;
	}
	
	@Override
	public List<CouponUsageHistoryVO> getAll(Integer memberID) {
		List<CouponUsageHistoryVO> list = new ArrayList<CouponUsageHistoryVO>();
		CouponUsageHistoryVO couponUsageHistoryVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, memberID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				couponUsageHistoryVO = new CouponUsageHistoryVO();
				couponUsageHistoryVO.setMemberID(rs.getInt("memberID"));
				couponUsageHistoryVO.setCouponID(rs.getInt("couponID"));
				couponUsageHistoryVO.setUsageRecord(rs.getInt("usageRecord"));
				couponUsageHistoryVO.setUseDate(rs.getTimestamp("useDate"));			
				list.add(couponUsageHistoryVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	@Override
	public List<CouponUsageHistoryVO> getAll2() {
		List<CouponUsageHistoryVO> list = new ArrayList<CouponUsageHistoryVO>();
		CouponUsageHistoryVO couponUsageHistoryVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				couponUsageHistoryVO = new CouponUsageHistoryVO();
				couponUsageHistoryVO.setMemberID(rs.getInt("memberID"));
				couponUsageHistoryVO.setCouponID(rs.getInt("couponID"));
				couponUsageHistoryVO.setUsageRecord(rs.getInt("usageRecord"));
				couponUsageHistoryVO.setUseDate(rs.getTimestamp("useDate"));			
				list.add(couponUsageHistoryVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
//	public static void main(String[] args) {
//
//		CouponUsageHistoryJDBCDAO dao = new CouponUsageHistoryJDBCDAO();
//
//		// 新增
//		CouponUsageHistoryVO couponUsageHistoryVO = new CouponUsageHistoryVO();
//		couponUsageHistoryVO.setMemberID(1);
//		couponUsageHistoryVO.setCouponID(5);
//		couponUsageHistoryVO.setUsageRecord(1);
//		couponUsageHistoryVO.setUseDate(java.sql.Timestamp.valueOf("1999-11-11 11:11:11"));
//		
//		
//		dao.insert(couponUsageHistoryVO);
//	}

}
