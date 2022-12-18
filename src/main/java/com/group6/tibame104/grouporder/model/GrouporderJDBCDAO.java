package com.group6.tibame104.grouporder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GrouporderJDBCDAO implements GrouporderDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO groupBuyOrder (groupBuyID,groupBuyProductID,memberID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT groupBuyOrderID,groupBuyID,memberID,groupBuyProductID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation FROM groupBuyOrder";
	private static final String GET_ONE_STMT = 
			"SELECT groupBuyOrderID,groupBuyID,memberID,groupBuyProductID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation FROM groupBuyOrder where groupBuyOrderID = ?";
	private static final String GET_BY_MEMID ="SELECT groupBuyOrderID,groupBuyID,memberID,groupBuyProductID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation FROM groupBuyOrder where memberID = ?";
	private static final String UPDATE = "UPDATE groupBuyOrder set groupBuyID=? ,memberID=? ,groupBuyProductID=? ,groupBuyQuantity=? ,groupBuyTotal=? ,orderTime=?,paymentTerm=? ,paymentState=? ,giftVoucher=? ,contactNumber=? ,shippingLocation=?  where groupBuyOrderID = ?";
	private static final String DELETE = "DELETE FROM groupBuyOrder where groupBuyOrderID = ?";

//新增
	@Override
	public void insert(GrouporderVO grouporderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			System.out.println();
			pstmt.setInt(1, grouporderVO.getGroupBuyID());
			pstmt.setInt(2, grouporderVO.getGroupBuyProductID());
			pstmt.setInt(3, grouporderVO.getMemberID());
			pstmt.setInt(4, grouporderVO.getGroupBuyQuantity());
			pstmt.setInt(5, grouporderVO.getGroupBuyTotal());
			pstmt.setTimestamp(6, grouporderVO.getOrderTime());
			pstmt.setString(7, grouporderVO.getPaymentTerm());
			pstmt.setInt(8, grouporderVO.getPaymentState());
			pstmt.setInt(9, grouporderVO.getGiftVoucher());
			pstmt.setString(10, grouporderVO.getContactNumber());
			pstmt.setString(11, grouporderVO.getShippingLocation());

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

//更新
	@Override
	public void update(GrouporderVO grouporderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, grouporderVO.getGroupBuyID());
			pstmt.setInt(2, grouporderVO.getMemberID());
			pstmt.setInt(3, grouporderVO.getGroupBuyProductID());
			pstmt.setInt(4, grouporderVO.getGroupBuyQuantity());
			pstmt.setInt(5, grouporderVO.getGroupBuyTotal());
			pstmt.setTimestamp(6, grouporderVO.getOrderTime());
			pstmt.setString(7, grouporderVO.getPaymentTerm());
			pstmt.setInt(8, grouporderVO.getPaymentState());
			pstmt.setInt(9, grouporderVO.getGiftVoucher());
			pstmt.setString(10, grouporderVO.getContactNumber());
			pstmt.setString(11, grouporderVO.getShippingLocation());
			pstmt.setInt(12, grouporderVO.getGroupBuyOrderID());

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

//刪除
	@Override
	public void delete(Integer grouporderID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, grouporderID);

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

//查詢單一團購訂單
	@Override
	public GrouporderVO findByPrimaryKey(Integer groupBuyOrderID) {

		GrouporderVO grouporderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, groupBuyOrderID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				grouporderVO = new GrouporderVO();

				grouporderVO.setGroupBuyOrderID(rs.getInt("groupBuyOrderID"));
				grouporderVO.setGroupBuyID(rs.getInt("groupBuyID"));
				grouporderVO.setMemberID(rs.getInt("memberID"));
				grouporderVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
				grouporderVO.setGroupBuyQuantity(rs.getInt("groupBuyQuantity"));
				grouporderVO.setGroupBuyTotal(rs.getInt("groupBuyTotal"));
				grouporderVO.setOrderTime(rs.getTimestamp("orderTime"));
				grouporderVO.setPaymentTerm(rs.getString("paymentTerm"));
				grouporderVO.setPaymentState(rs.getInt("paymentState"));
				grouporderVO.setGiftVoucher(rs.getInt("giftVoucher"));
				grouporderVO.setContactNumber(rs.getString("contactNumber"));
				grouporderVO.setShippingLocation(rs.getString("shippingLocation"));

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
		return grouporderVO;
	}
	//用會員編號查詢所有訂單
	public List<GrouporderVO> getAllByMemID(Integer memberID) {
		List<GrouporderVO> list = new ArrayList<GrouporderVO>();
		GrouporderVO grouporderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_BY_MEMID);
			pstmt.setInt(1, memberID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects

				grouporderVO = new GrouporderVO();

				grouporderVO.setGroupBuyOrderID(rs.getInt("groupBuyOrderID"));
				grouporderVO.setGroupBuyID(rs.getInt("groupBuyID"));
				grouporderVO.setMemberID(rs.getInt("memberID"));
				grouporderVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
				grouporderVO.setGroupBuyQuantity(rs.getInt("groupBuyQuantity"));
				grouporderVO.setGroupBuyTotal(rs.getInt("groupBuyTotal"));
				grouporderVO.setOrderTime(rs.getTimestamp("orderTime"));
				grouporderVO.setPaymentTerm(rs.getString("paymentTerm"));
				grouporderVO.setPaymentState(rs.getInt("paymentState"));
				grouporderVO.setGiftVoucher(rs.getInt("giftVoucher"));
				grouporderVO.setContactNumber(rs.getString("contactNumber"));
				grouporderVO.setShippingLocation(rs.getString("shippingLocation"));

				list.add(grouporderVO); // Store the row in the list
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
// 查詢ALL

	public List<GrouporderVO> getAll() {
		List<GrouporderVO> list = new ArrayList<GrouporderVO>();
		GrouporderVO grouporderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects

				grouporderVO = new GrouporderVO();

				grouporderVO.setGroupBuyOrderID(rs.getInt("groupBuyOrderID"));
				grouporderVO.setGroupBuyID(rs.getInt("groupBuyID"));
				grouporderVO.setMemberID(rs.getInt("memberID"));
				grouporderVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
				grouporderVO.setGroupBuyQuantity(rs.getInt("groupBuyQuantity"));
				grouporderVO.setGroupBuyTotal(rs.getInt("groupBuyTotal"));
				grouporderVO.setOrderTime(rs.getTimestamp("orderTime"));
				grouporderVO.setPaymentTerm(rs.getString("paymentTerm"));
				grouporderVO.setPaymentState(rs.getInt("paymentState"));
				grouporderVO.setGiftVoucher(rs.getInt("giftVoucher"));
				grouporderVO.setContactNumber(rs.getString("contactNumber"));
				grouporderVO.setShippingLocation(rs.getString("shippingLocation"));

				list.add(grouporderVO); // Store the row in the list
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

	public static void main(String[] args) {

		GrouporderJDBCDAO dao = new GrouporderJDBCDAO();

//    新增
		GrouporderVO grouporderVO = new GrouporderVO();

		grouporderVO.setGroupBuyID(1);
		grouporderVO.setMemberID(1);
		grouporderVO.setGroupBuyProductID(1);
		grouporderVO.setGroupBuyQuantity(50);
		grouporderVO.setGroupBuyTotal(2000);
		grouporderVO.setOrderTime(java.sql.Timestamp.valueOf("1993-01-02 11:11:11"));
		grouporderVO.setPaymentTerm("信用卡");
		grouporderVO.setPaymentState(1);
		grouporderVO.setGiftVoucher(50);
		grouporderVO.setContactNumber("0932777172");
		grouporderVO.setShippingLocation("台南");
		dao.insert(grouporderVO);
//
////    修改		
//		GrouporderVO grouporderVO2 = new GrouporderVO();
//	
//		grouporderVO2.setGroupBuyOrderID(5);
//		grouporderVO2.setGroupBuyID(1);
//		grouporderVO2.setMemberID(1);
//		grouporderVO2.setGroupBuyProductID(1);
//		grouporderVO2.setGroupBuyQuantity(210);
//		grouporderVO2.setGroupBuyTotal(0);	
//		grouporderVO2.setOrderTime(java.sql.Date.valueOf("2020-01-02"));
//		grouporderVO2.setPaymentTerm("信用卡");
//		grouporderVO2.setPaymentState(1);
//		grouporderVO2.setGiftVoucher(0);
//		grouporderVO2.setContactNumber("0001");
//		grouporderVO2.setShippingLocation("台南");
//		dao.update(grouporderVO2);
		
////	刪除
//		dao.delete(2);
////    單一查詢
//		GrouporderVO grouporderVO3 = dao.findByPrimaryKey(3);
//		
//		System.out.print(grouporderVO3.getGroupBuyOrderID() + ",");
//		System.out.print(grouporderVO3.getGroupBuyID() + ",");
//		System.out.print(grouporderVO3.getMemberID()+ ",");
//		System.out.print(grouporderVO3.getGroupBuyProductID() + ",");
//		System.out.print(grouporderVO3.getGroupBuyQuantity() + ",");
//		System.out.print(grouporderVO3.getOrderTime() + ",");
//		System.out.print(grouporderVO3.getPaymentTerm()+ ",");
//		System.out.print(grouporderVO3.getPaymentState()+ ",");
//		System.out.print(grouporderVO3.getGiftVoucher()+ ",");
//		System.out.print(grouporderVO3.getContactNumber()+ ",");
//		System.out.println(grouporderVO3.getShippingLocation());
//		System.out.println("---------------------");
		
////    查詢all
//		List<GrouporderVO> list = dao.getAll();
//		for (GrouporderVO aEmp : list) {
//			System.out.print(aEmp.getGroupBuyOrderID() + ",");
//			System.out.print(aEmp.getGroupBuyID() + ",");
//			System.out.print(aEmp.getMemberID() + ",");
//			System.out.print(aEmp.getGroupBuyProductID() + ",");
//			System.out.print(aEmp.getGroupBuyQuantity() + ",");
//			System.out.print(aEmp.getGroupBuyTotal() + ",");
//			System.out.print(aEmp.getOrderTime() + ",");
//			System.out.print(aEmp.getPaymentTerm() + ",");
//			System.out.print(aEmp.getPaymentState() + ",");
//			System.out.print(aEmp.getGiftVoucher() + ",");
//			System.out.print(aEmp.getContactNumber() + ",");
//			System.out.print(aEmp.getShippingLocation());
//			System.out.println();
//		}
	}

}
