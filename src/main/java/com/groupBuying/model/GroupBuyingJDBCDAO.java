package com.groupBuying.model;

import java.util.*;
import java.sql.*;

public class GroupBuyingJDBCDAO implements GroupBuyingDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
	"INSERT INTO groupBuying (groupBuyProductID, administratorID, groupBuyProductOrderTotal, groupBuyingState, groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT groupBuyID, groupBuyProductID, administratorID, groupBuyProductOrderTotal, groupBuyingState, groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime FROM groupBuying order by groupBuyID";
	private static final String GET_ONE_STMT = 
		"SELECT groupBuyID, groupBuyProductID, administratorID, groupBuyProductOrderTotal, groupBuyingState, groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime FROM groupBuying where groupBuyID = ?";
	private static final String DELETE = 
		"DELETE FROM groupBuying where groupBuyID = ?";
	private static final String UPDATE = 
		"UPDATE groupBuying set groupBuyProductID=?, administratorID=?, groupBuyProductOrderTotal=?, groupBuyingState=?, groupBuyingOnLoadDate=?, groupBuyingOffLoadDate=?, updateTime=? where groupBuyID = ?";

	
	@Override
	public void insert(GroupBuyingVO groupBuyingVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, groupBuyingVO.getGroupBuyProductID());
			pstmt.setInt(2, groupBuyingVO.getAdministratorID());
			pstmt.setInt(3, groupBuyingVO.getGroupBuyProductOrderTotal());
			pstmt.setBoolean(4, groupBuyingVO.getGroupBuyingState());
			pstmt.setDate(5, groupBuyingVO.getGroupBuyingOnLoadDate());
			pstmt.setDate(6, groupBuyingVO.getGroupBuyingOffLoadDate());
			pstmt.setTimestamp(7, groupBuyingVO.getUpdateTime());

			pstmt.executeUpdate();

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
	public void update(GroupBuyingVO groupBuyingVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, groupBuyingVO.getGroupBuyProductID());
			pstmt.setInt(2, groupBuyingVO.getAdministratorID());
			pstmt.setInt(3, groupBuyingVO.getGroupBuyProductOrderTotal());
			pstmt.setBoolean(4, groupBuyingVO.getGroupBuyingState());
			pstmt.setDate(5, groupBuyingVO.getGroupBuyingOnLoadDate());
			pstmt.setDate(6, groupBuyingVO.getGroupBuyingOffLoadDate());
			pstmt.setTimestamp(7, groupBuyingVO.getUpdateTime());

			pstmt.executeUpdate();

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
	public void delete(Integer groupBuyID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, groupBuyID);

			pstmt.executeUpdate();

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
	public GroupBuyingVO findByPrimaryKey(Integer groupBuyID) {

		GroupBuyingVO groupBuyingVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, groupBuyID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// groupBuyingVO 也稱為 Domain objects
				groupBuyingVO = new GroupBuyingVO();
				groupBuyingVO.setGroupBuyProductID(rs.getInt("getGroupBuyProductID"));
				groupBuyingVO.setAdministratorID(rs.getInt("administratorID"));
				groupBuyingVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
				groupBuyingVO.setGroupBuyingState(rs.getBoolean("groupBuyingState"));
				groupBuyingVO.setGroupBuyingOnLoadDate(rs.getDate("groupBuyingOnLoadDate"));
				groupBuyingVO.setGroupBuyingOffLoadDate(rs.getDate("groupBuyingOffLoadDate"));
				groupBuyingVO.setUpdateTime(rs.getTimestamp("updateTim"));

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
		return groupBuyingVO;
	}

	
	
	@Override
	public List<GroupBuyingVO> getAll() {
		List<GroupBuyingVO> list = new ArrayList<GroupBuyingVO>();
		GroupBuyingVO groupBuyingVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// groupBuyingVO 也稱為 Domain objects
				groupBuyingVO = new GroupBuyingVO();
				groupBuyingVO.setGroupBuyProductID(rs.getInt("getGroupBuyProductID"));
				groupBuyingVO.setAdministratorID(rs.getInt("administratorID"));
				groupBuyingVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
				groupBuyingVO.setGroupBuyingState(rs.getBoolean("groupBuyingState"));
				groupBuyingVO.setGroupBuyingOnLoadDate(rs.getDate("groupBuyingOnLoadDate"));
				groupBuyingVO.setGroupBuyingOffLoadDate(rs.getDate("groupBuyingOffLoadDate"));
				groupBuyingVO.setUpdateTime(rs.getTimestamp("updateTim"));
				list.add(groupBuyingVO); // Store the row in the list
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
		return list;
	}
	
	
	public static void main(String[] args) {
		GroupBuyingJDBCDAO dao = new GroupBuyingJDBCDAO();
		
		// 新增
		GroupBuyingVO GroupVO1 = new GroupBuyingVO();
		GroupVO1.setGroupBuyProductID(1);
		GroupVO1.setAdministratorID(1);
		GroupVO1.setGroupBuyProductOrderTotal(1);
		GroupVO1.setGroupBuyingState(true);
		GroupVO1.setGroupBuyingOnLoadDate(java.sql.Date.valueOf("2022-11-11"));
		GroupVO1.setGroupBuyingOffLoadDate(java.sql.Date.valueOf("2022-11-20"));
		dao.insert(GroupVO1);
		
	

		// 修改
		GroupBuyingVO GroupVO2 = new GroupBuyingVO();
		GroupVO2.setGroupBuyID(1);
		GroupVO2.setGroupBuyProductID(1);
		GroupVO2.setAdministratorID(1);
		GroupVO2.setGroupBuyProductOrderTotal(1);
		GroupVO2.setGroupBuyingState(false);
		GroupVO2.setGroupBuyingOnLoadDate(java.sql.Date.valueOf("2022-10-10"));
		GroupVO2.setGroupBuyingOffLoadDate(java.sql.Date.valueOf("2022-10-20"));
		dao.update(GroupVO2);

		// 刪除
		dao.delete(1);

		// 查詢
		GroupBuyingVO GroupVO3 = dao.findByPrimaryKey(1);
		System.out.print(GroupVO3.getGroupBuyID() + ",");
		System.out.print(GroupVO3.getGroupBuyProductID() + ",");
		System.out.print(GroupVO3.getAdministratorID() + ",");
		System.out.print(GroupVO3.getGroupBuyProductOrderTotal() + ",");
		System.out.print(GroupVO3.getGroupBuyingState() + ",");
		System.out.print(GroupVO3.getGroupBuyingOnLoadDate() + ",");
		System.out.println(GroupVO3.getGroupBuyingOffLoadDate());
		System.out.println("---------------------");

		// 查詢
		List<GroupBuyingVO> list = dao.getAll();
		for (GroupBuyingVO aGroup : list) {
			System.out.print(aGroup.getGroupBuyID() + ",");
			System.out.print(aGroup.getGroupBuyProductID() + ",");
			System.out.print(aGroup.getAdministratorID() + ",");
			System.out.print(aGroup.getGroupBuyProductOrderTotal() + ",");
			System.out.print(aGroup.getGroupBuyingState() + ",");
			System.out.print(aGroup.getGroupBuyingOnLoadDate() + ",");
			System.out.print(aGroup.getGroupBuyingOffLoadDate());
			System.out.println();
		}
		
		
	}
	
}
