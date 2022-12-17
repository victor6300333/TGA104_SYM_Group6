package com.coupon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CouponJDBCDAO implements CouponDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO coupon (couponName,startDate,endDate,discount,discountAmount,fullCondition,couponTimeBegins,couponTimeEnd,exchangeAmount,couponDescription) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String GET_ALL_STMT = "SELECT couponID,couponName,startDate,endDate,discount,discountAmount,fullCondition,couponTimeBegins,couponTimeEnd,exchangeAmount,couponDescription FROM coupon";
	private static final String GET_ONE_STMT = "SELECT couponID,couponName,startDate,endDate,discount,discountAmount,fullCondition,couponTimeBegins,couponTimeEnd,exchangeAmount,couponDescription FROM coupon where couponID=?;";

	private static final String DELETE_DEPT = "DELETE FROM coupon where couponID = ?;";

	private static final String UPDATE = "UPDATE coupon set couponName=?,startDate=?,endDate=?,discount=?,discountAmount=?,fullCondition=?,couponTimeBegins=?,couponTimeEnd=?,exchangeAmount=?,couponDescription=? where couponID=?;";

	private static final String GET_ALL_STMT_BY_CouponUsage ="select m.memberID,m.userAccount,m.userName,\r\n"
			+ "cuh.couponID,cuh.usageRecord,\r\n"
			+ "c.couponName,c.discount,c.discountAmount,c.fullCondition,c.couponDescription\r\n"
			+ "from member m \r\n"
			+ "left join couponUsageHistory cuh\r\n"
			+ "on m.memberID = cuh.memberID\r\n"
			+ "left join coupon c\r\n"
			+ "on cuh.couponID = c.couponID\r\n"
			+ "where cuh.usageRecord=1;";
	
	@Override
	public void insert(CouponVO couponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, couponVO.getCouponName());
			pstmt.setDate(2, couponVO.getStartDate());
			pstmt.setDate(3, couponVO.getEndDate());
			pstmt.setDouble(4, couponVO.getDiscount());
			pstmt.setInt(5, couponVO.getDiscountAmount());
			pstmt.setInt(6, couponVO.getFullCondition());
			pstmt.setDate(7, couponVO.getCouponTimeBegins());
			pstmt.setDate(8, couponVO.getCouponTimeEnd());
			pstmt.setInt(9, couponVO.getExchangeAmount());
//			pstmt.setBytes(10, couponVO.getCouponPicture());
			pstmt.setString(10, couponVO.getCouponDescription());

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
//
	@Override
	public void update(CouponVO couponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, couponVO.getCouponName());
			pstmt.setDate(2, couponVO.getStartDate());
			pstmt.setDate(3, couponVO.getEndDate());
			pstmt.setDouble(4, couponVO.getDiscount());
			pstmt.setInt(5, couponVO.getDiscountAmount());
			pstmt.setInt(6, couponVO.getFullCondition());
			pstmt.setDate(7, couponVO.getCouponTimeBegins());
			pstmt.setDate(8, couponVO.getCouponTimeEnd());
			pstmt.setInt(9, couponVO.getExchangeAmount());
			pstmt.setString(10, couponVO.getCouponDescription());
			pstmt.setInt(11, couponVO.getCouponID());
			

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
	public void delete(Integer couponID) {
		int updateCount_EMPs = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			// 1���]�w�� pstm.executeUpdate()���e
			con.setAutoCommit(false);

			
			
			pstmt = con.prepareStatement(DELETE_DEPT);
			pstmt.setInt(1, couponID);
			pstmt.executeUpdate();

			// 2���]�w�� pstm.executeUpdate()����
			con.commit();
			con.setAutoCommit(true);
			System.out.println(couponID);
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3���]�w���exception�o�ͮɤ�catch�϶���
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public CouponVO findByPrimaryKey(Integer couponID) {

		CouponVO couponVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, couponID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO �]�٬� Domain objects
				couponVO = new CouponVO();
				couponVO.setCouponID(rs.getInt("couponID"));
				couponVO.setCouponName(rs.getString("couponName"));
				couponVO.setStartDate(rs.getDate("startDate"));
				couponVO.setEndDate(rs.getDate("endDate"));
				couponVO.setDiscount(rs.getDouble("discount")); 
				couponVO.setDiscountAmount(rs.getInt("discountAmount"));
				couponVO.setFullCondition(rs.getInt("fullCondition"));
				couponVO.setCouponTimeBegins(rs.getDate("couponTimeBegins"));
				couponVO.setCouponTimeEnd(rs.getDate("couponTimeEnd"));
				couponVO.setExchangeAmount(rs.getInt("exchangeAmount"));
//				couponVO.setCouponPicture(rs.getBytes("couponPicture"));
				couponVO.setCouponDescription(rs.getString("couponDescription"));
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
		return couponVO;
	}

	@Override
	public List<CouponVO> getAll() {
		List<CouponVO> list = new ArrayList<CouponVO>();
		CouponVO couponVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				couponVO = new CouponVO();
				couponVO.setCouponID(rs.getInt("couponID"));
				couponVO.setCouponName(rs.getString("couponName"));
				couponVO.setStartDate(rs.getDate("startDate"));
				couponVO.setEndDate(rs.getDate("endDate"));
				couponVO.setDiscount(rs.getDouble("discount"));
				couponVO.setDiscountAmount(rs.getInt("discountAmount"));
				couponVO.setFullCondition(rs.getInt("fullCondition"));
				couponVO.setCouponTimeBegins(rs.getDate("couponTimeBegins"));
				couponVO.setCouponTimeEnd(rs.getDate("couponTimeEnd"));
				couponVO.setExchangeAmount(rs.getInt("exchangeAmount"));
//				couponVO.setCouponPicture(rs.getBytes("couponPicture"));
				couponVO.setCouponDescription(rs.getString("couponDescription"));
				list.add(couponVO); // Store the row in the list
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
	public List<CouponVO2> getAllByCouponUsage() {
		List<CouponVO2> list = new ArrayList<CouponVO2>();
		CouponVO2 couponVO2 = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT_BY_CouponUsage);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				couponVO2 = new CouponVO2();
				couponVO2.setMemberID(rs.getInt("memberID"));
				couponVO2.setUserAccount(rs.getString("userAccount"));
				couponVO2.setUserName(rs.getString("userName"));
				couponVO2.setCouponID(rs.getInt("couponID"));
				couponVO2.setUsageRecord(rs.getInt("usageRecord"));
				couponVO2.setCouponName(rs.getString("couponName"));
				couponVO2.setDiscount(rs.getDouble("discount"));
				couponVO2.setDiscountAmount(rs.getInt("discountAmount"));
				couponVO2.setFullCondition(rs.getInt("fullCondition"));
				couponVO2.setCouponDescription(rs.getString("couponDescription"));
				list.add(couponVO2); // Store the row in the list
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
	
	public static void main(String[] args) {

		CouponJDBCDAO dao = new CouponJDBCDAO();
		List<CouponVO2> allByCouponUsage = dao.getAllByCouponUsage();
		for(CouponVO2 s:allByCouponUsage) {
			System.out.println(s);
		}
/*
		// �s�W
		CouponVO couponVO1 = new CouponVO();
		couponVO1.setCouponName("nick");
		couponVO1.setStartDate(java.sql.Date.valueOf("2007-01-02"));
		couponVO1.setEndDate(java.sql.Date.valueOf("2008-01-02"));
		couponVO1.setDiscount(0.85);
		couponVO1.setDiscountAmount(1);
		couponVO1.setFullCondition(1);
		couponVO1.setCouponTimeBegins(java.sql.Date.valueOf("1993-01-02"));
		couponVO1.setCouponTimeEnd(java.sql.Date.valueOf("1993-01-02"));
		couponVO1.setExchangeAmount(1);
//		couponVO1.setCouponPicture(null);
		couponVO1.setCouponDescription("");
		
		dao.insert(couponVO1);

//		 �ק�
		CouponVO couponVO2 = new CouponVO();
		couponVO2.setCouponName("");
		couponVO2.setStartDate(java.sql.Date.valueOf("1993-01-02"));
		couponVO2.setEndDate(java.sql.Date.valueOf("1993-01-11"));
		couponVO2.setDiscount(0.85);
		couponVO2.setDiscountAmount(1);
		couponVO2.setFullCondition(1);
		couponVO2.setCouponTimeBegins(java.sql.Date.valueOf("1993-01-02"));
		couponVO2.setCouponTimeEnd(java.sql.Date.valueOf("1993-01-02"));
		couponVO2.setExchangeAmount(1);
//		couponVO2.setCouponPicture(null);
		couponVO2.setCouponDescription("");
		couponVO2.setCouponID(9);
		

		dao.update(couponVO2);

		// �R��
		dao.delete(9);

		// �d��
		CouponVO couponVO3 = dao.findByPrimaryKey(1);
		System.out.print(couponVO3.getCouponID() + ",");
		System.out.print(couponVO3.getCouponName() + ",");
		System.out.println(couponVO3.getStartDate());
		System.out.println(couponVO3.getEndDate());
		System.out.println(couponVO3.getDiscount());
		System.out.println(couponVO3.getDiscountAmount());
		System.out.println(couponVO3.getFullCondition());
		System.out.println(couponVO3.getCouponTimeBegins());
		System.out.println(couponVO3.getCouponTimeEnd());
		System.out.println(couponVO3.getExchangeAmount());
//		System.out.println(couponVO3.getCouponPicture());
		System.out.println(couponVO3.getCouponDescription());
		System.out.println("---------------------");

		// �d�ߥ���
		List<CouponVO> list = dao.getAll();
		for (CouponVO aDept : list) {
			System.out.print(aDept.getCouponID() + ",");
			System.out.print(aDept.getCouponName() + ",");
			System.out.println(aDept.getStartDate());
			System.out.println(aDept.getEndDate());
			System.out.println(aDept.getDiscount());
			System.out.println(aDept.getDiscountAmount());
			System.out.println(aDept.getFullCondition());
			System.out.println(aDept.getCouponTimeBegins());
			System.out.println(aDept.getCouponTimeEnd());
			System.out.println(aDept.getExchangeAmount());
//			System.out.println(aDept.getCouponPicture());
			System.out.println(aDept.getCouponDescription());
			System.out.println("---------------------");

				}
*/		
				

	}


}