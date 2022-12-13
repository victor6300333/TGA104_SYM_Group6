package com.groupdiscount.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupdiscountJDBCDAO implements GroupdiscountDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "lucky777";

	private static final String INSERT_STMT = "INSERT INTO groupBuyDiscount(groupBuyID,groupBuyProductOrderTotal,groupBuyCount) VALUES (?,?,?)";
	private static final String UPDATE = "UPDATE groupBuyDiscount set groupBuyID = ?, groupBuyProductOrderTotal = ?, groupBuyCount = ? where countTableID = ?";
	private static final String DELETE = "DELETE FROM groupBuyDiscount where countTableID = ?";
	private static final String GET_ONE_STMT = "SELECT countTableID,groupBuyID,groupBuyProductOrderTotal,groupBuyCount FROM groupBuyDiscount WHERE countTableID = ?;";
	private static final String GET_ONE_DISCOUNT = "SELECT countTableID,groupBuyID,groupBuyProductOrderTotal,groupBuyCount FROM groupBuyDiscount WHERE groupBuyID = ?;";
	private static final String GET_ALL_STMT = "SELECT countTableID,groupBuyID,groupBuyProductOrderTotal,groupBuyCount FROM groupBuyDiscount;";
	private static final String GET_ALL_GBID = "SELECT distinct groupBuyID FROM groupBuyDiscount;";

	@Override
	public void insert(GroupdiscountVO groupdiscountVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, groupdiscountVO.getGroupBuyID());
			pstmt.setInt(2, groupdiscountVO.getGroupBuyProductOrderTotal());
			pstmt.setDouble(3, groupdiscountVO.getGroupBuyCount());

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

	// 更新
	@Override
	public void update(GroupdiscountVO groupdiscountVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, groupdiscountVO.getGroupBuyID());
			pstmt.setInt(2, groupdiscountVO.getGroupBuyProductOrderTotal());
			pstmt.setDouble(3, groupdiscountVO.getGroupBuyCount());
			pstmt.setInt(4, groupdiscountVO.getCountTableID());

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

	// 刪除
	@Override
	public void delete(Integer countTableID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, countTableID);

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

	// 查詢單一
	@Override
	public GroupdiscountVO findByPrimaryKey(Integer countTableID) {

		GroupdiscountVO groupdiscountVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, countTableID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				groupdiscountVO = new GroupdiscountVO();

				groupdiscountVO.setCountTableID(rs.getInt("countTableID"));
				groupdiscountVO.setGroupBuyID(rs.getInt("groupBuyID"));
				groupdiscountVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
				groupdiscountVO.setGroupBuyCount(rs.getDouble("groupBuyCount"));

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
		return groupdiscountVO;
	}

	// 用groupBuyID搜尋所有countTable
	@Override
	public List<GroupdiscountVO> getAllCount(Integer groupBuyID) {

		List<GroupdiscountVO> list = new ArrayList<GroupdiscountVO>();
		GroupdiscountVO groupdiscountVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_DISCOUNT);

			pstmt.setInt(1, groupBuyID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				groupdiscountVO = new GroupdiscountVO();

				groupdiscountVO.setCountTableID(rs.getInt("countTableID"));
				groupdiscountVO.setGroupBuyID(rs.getInt("groupBuyID"));
				groupdiscountVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
				groupdiscountVO.setGroupBuyCount(rs.getDouble("groupBuyCount"));

				list.add(groupdiscountVO);
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

	public List<GroupdiscountVO> getAll() {
		List<GroupdiscountVO> list = new ArrayList<GroupdiscountVO>();
		GroupdiscountVO groupdiscountVO = null;

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

				groupdiscountVO = new GroupdiscountVO();

				groupdiscountVO.setCountTableID(rs.getInt("countTableID"));
				groupdiscountVO.setGroupBuyID(rs.getInt("groupBuyID"));
				groupdiscountVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
				groupdiscountVO.setGroupBuyCount(rs.getDouble("groupBuyCount"));

				list.add(groupdiscountVO); // Store the row in the list
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

	// 找有的groupBuyID
	public List<GroupdiscountVO> getGroupBuyID() {
		List<GroupdiscountVO> list = new ArrayList<GroupdiscountVO>();
		GroupdiscountVO groupdiscountVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_GBID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects

				groupdiscountVO = new GroupdiscountVO();

				groupdiscountVO.setGroupBuyID(rs.getInt("groupBuyID"));

				list.add(groupdiscountVO); // Store the row in the list
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

	// 找屬於某個團購編號的折扣表
	public List<GroupdiscountVO> getCountTable(Integer groupBuyID) {
		List<GroupdiscountVO> list = new ArrayList<GroupdiscountVO>();
		GroupdiscountVO groupdiscountVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_DISCOUNT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects

				groupdiscountVO = new GroupdiscountVO();

				groupdiscountVO.setGroupBuyID(rs.getInt("groupBuyID"));

				list.add(groupdiscountVO); // Store the row in the list
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

		GroupdiscountJDBCDAO dao = new GroupdiscountJDBCDAO();

////新增
//		GroupdiscountVO groupdiscountVO = new GroupdiscountVO();
//
//		groupdiscountVO.setGroupBuyID(1);
//		groupdiscountVO.setGroupBuyProductOrderTotal(1000);
//		groupdiscountVO.setGroupBuyCount(0.99);
//		
//		dao.insert(groupdiscountVO);

////    修改		
//		GroupdiscountVO groupdiscountVO2 = new GroupdiscountVO();
//	
//		groupdiscountVO2.setCountTableID(1);
//		groupdiscountVO2.setGroupBuyID(1);
//		groupdiscountVO2.setGroupBuyProductOrderTotal(1);
//		groupdiscountVO2.setGroupBuyCount(0.1);
//		
//		dao.update(groupdiscountVO2);
////	刪除
//		dao.delete(3);
//    單一查詢
		GroupdiscountVO groupdiscountVO3 = dao.findByPrimaryKey(1);
		
		System.out.print(groupdiscountVO3.getCountTableID() + ",");
		System.out.print(groupdiscountVO3.getGroupBuyID() + ",");
		System.out.print(groupdiscountVO3.getGroupBuyProductOrderTotal()+ ",");
		System.out.print(groupdiscountVO3.getGroupBuyCount() + ",");

		System.out.println("---------------------");
////    查詢all
//		List<GroupdiscountVO> list = dao.getAll();
//		for (GroupdiscountVO aEmp : list) {
//			System.out.print(aEmp.getCountTableID() + ",");
//			System.out.print(aEmp.getGroupBuyID() + ",");
//			System.out.print(aEmp.getGroupBuyProductOrderTotal() + ",");
//			System.out.print(aEmp.getGroupBuyCount());
//			
//			System.out.println();
//		}
//		查詢all
//		List<GroupdiscountVO> list = dao.getCountTable();
//		for (GroupdiscountVO aEmp : list) {
//			
//			System.out.print(aEmp.getCountTableID() + ",");
//			System.out.print(aEmp.getGroupBuyID() + ",");
//			System.out.print(aEmp.getGroupBuyProductOrderTotal() + ",");
//			System.out.print(aEmp.getGroupBuyCount());
//			
//			System.out.println();
//		}
////		 查詢groupBuyID
//			List<GroupdiscountVO> list = dao.getGroupBuyID();
//			for (GroupdiscountVO aEmp : list) {
//	
//				System.out.print(aEmp.getGroupBuyID() + ",");
//
//				
//				System.out.println();
//			}
	}
}