package com.group.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupJDBCDAO implements GroupDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "lucky777";

	private static final String INSERT_STMT = "INSERT INTO groupBuying (groupBuyProductID,administratorID,groupBuyProductOrderTotal,groupBuyingState,groupBuyingOnLoadDate,groupBuyingOffLoadDate,updateTime) VALUES(?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE groupBuying set groupBuyProductID=?,administratorID=?,groupBuyProductOrderTotal=?,groupBuyingState=?,groupBuyingOnLoadDate=?,groupBuyingOffLoadDate=?,updateTime= ? WHERE groupBuyID = ?";
	private static final String DELETE = "DELETE FROM groupBuying where groupBuyID = ?";
	private static final String GET_ONE_STMT = "SELECT groupBuyID,groupBuyProductID,administratorID,groupBuyProductOrderTotal,groupBuyingState,groupBuyingOnLoadDate,groupBuyingOffLoadDate,updateTime FROM groupBuying where groupBuyID = ?";
	private static final String GET_ALL_STMT = "SELECT groupBuyID,groupBuyProductID,administratorID,groupBuyProductOrderTotal,groupBuyingState,groupBuyingOnLoadDate,groupBuyingOffLoadDate,updateTime FROM groupBuying";
	private static final String UPDATE_ONE_QUA ="UPDATE groupBuying set groupBuyProductOrderTotal=? WHERE groupBuyID = ?";
	@Override
	public void insert(GroupVO groupVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1, groupVO.getGroupBuyProductID());
			pstmt.setInt(2, groupVO.getAdministratorID());
			pstmt.setInt(3, groupVO.getGroupBuyProductOrderTotal());
			pstmt.setBoolean(4, groupVO.getGroupBuyingState());
			pstmt.setTimestamp(5, groupVO.getGroupBuyingOnLoadDate());
			pstmt.setTimestamp(6, groupVO.getGroupBuyingOffLoadDate());
			pstmt.setTimestamp(7, groupVO.getUpdateTime());
			

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
	public void update(GroupVO groupVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, groupVO.getGroupBuyProductID());
			pstmt.setInt(2, groupVO.getAdministratorID());
			pstmt.setInt(3, groupVO.getGroupBuyProductOrderTotal());
			pstmt.setBoolean(4, groupVO.getGroupBuyingState());
			pstmt.setTimestamp(5, groupVO.getGroupBuyingOnLoadDate());
			pstmt.setTimestamp(6, groupVO.getGroupBuyingOffLoadDate());
			pstmt.setTimestamp(7, groupVO.getUpdateTime());
			pstmt.setInt(8, groupVO.getGroupBuyID());

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
	// 購買後更新團購總數
	@Override
	public void updateGroupQua(GroupVO groupVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_ONE_QUA);

		
			pstmt.setInt(1, groupVO.getGroupBuyProductOrderTotal());
			pstmt.setInt(2, groupVO.getGroupBuyID());

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

	// 查詢單一
	@Override
	public GroupVO findByPrimaryKey(Integer groupBuyID) {

		GroupVO groupVO = null;
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
				// empVo 也稱為 Domain objects
				groupVO = new GroupVO();

				groupVO.setGroupBuyID(rs.getInt("groupBuyID"));
				groupVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
				groupVO.setAdministratorID(rs.getInt("administratorID"));
				groupVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
				groupVO.setGroupBuyingState(rs.getBoolean("groupBuyingState"));
				groupVO.setGroupBuyingOnLoadDate(rs.getTimestamp("groupBuyingOnLoadDate"));
				groupVO.setGroupBuyingOffLoadDate(rs.getTimestamp("groupBuyingOffLoadDate"));
				groupVO.setUpdateTime(rs.getTimestamp("updateTime"));

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
		return groupVO;
	}

	public List<GroupVO> getAll() {
		List<GroupVO> list = new ArrayList<GroupVO>();
		GroupVO groupVO = null;

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

				groupVO = new GroupVO();

				groupVO.setGroupBuyID(rs.getInt("groupBuyID"));
				groupVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
				groupVO.setAdministratorID(rs.getInt("AdministratorID"));
				groupVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
				groupVO.setGroupBuyingState(rs.getBoolean("groupBuyingState"));
				groupVO.setGroupBuyingOnLoadDate(rs.getTimestamp("groupBuyingOnLoadDate"));
				groupVO.setGroupBuyingOffLoadDate(rs.getTimestamp("groupBuyingOffLoadDate"));
				groupVO.setUpdateTime(rs.getTimestamp("updateTime"));

				list.add(groupVO); // Store the row in the list
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

		GroupJDBCDAO dao = new GroupJDBCDAO();

////新增
//		GroupVO groupVO = new GroupVO();
//
//		groupVO.setGroupBuyProductID(3);
//		groupVO.setAdministratorID(1);
//		groupVO.setGroupBuyProductOrderTotal(100);
//		groupVO.setGroupBuyingState(true);
//		groupVO.setGroupBuyingOnLoadDate(java.sql.Timestamp.valueOf("1993-01-01 11:11:11"));
//		groupVO.setGroupBuyingOffLoadDate(java.sql.Timestamp.valueOf("1993-01-01 11:11:11"));
//
//		
//		dao.insert(groupVO);
////    修改		
//		
//		GroupVO groupVO2 = new GroupVO();
//	
//		groupVO2.setGroupBuyProductID(1);
//		groupVO2.setAdministratorID(1);
//		groupVO2.setGroupBuyProductOrderTotal(100);
//		groupVO2.setGroupBuyingState(false);
//		groupVO2.setGroupBuyingOnLoadDate(java.sql.Timestamp.valueOf("1993-01-01 11:11:11"));
//		groupVO2.setGroupBuyingOffLoadDate(java.sql.Timestamp.valueOf("1993-01-01 11:11:11"));
//		groupVO2.setUpdateTime(java.sql.Timestamp.valueOf("1993-01-01 11:11:11"));
//		groupVO2.setGroupBuyID(2);
//
//		dao.update(groupVO2);
				
////	刪除
//		dao.delete(4);		
////    單一查詢
//			GroupVO groupVO3 = dao.findByPrimaryKey(3);
//			
//			System.out.print(groupVO3.getGroupBuyID() + ",");
//			System.out.print(groupVO3.getGroupBuyProductID() + ",");
//			System.out.print(groupVO3.getAdministratorID()+ ",");
//			System.out.print(groupVO3.getGroupBuyProductOrderTotal() + ",");
//			System.out.print(groupVO3.getGroupBuyingState() + ",");
//			System.out.print(groupVO3.getGroupBuyingOnLoadDate() + ",");
//			System.out.print(groupVO3.getGroupBuyingOffLoadDate()+ ",");
//			System.out.print(groupVO3.getUpdateTime());
//			
//			System.out.println("---------------------");
////    查詢all
//		List<GroupVO> list = dao.getAll();
//		for (GroupVO aEmp : list) {
//
//			System.out.print(aEmp.getGroupBuyID() + ",");
//			System.out.print(aEmp.getGroupBuyProductID() + ",");
//			System.out.print(aEmp.getAdministratorID() + ",");
//			System.out.print(aEmp.getGroupBuyProductOrderTotal() + ",");
//			System.out.print(aEmp.getGroupBuyingState() + ",");
//			System.out.print(aEmp.getGroupBuyingOnLoadDate() + ",");
//			System.out.print(aEmp.getGroupBuyingOffLoadDate() + ",");
//			System.out.print(aEmp.getUpdateTime());
//
//			System.out.println();
//		}

	}
}
