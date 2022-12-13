package com.memberBlockList.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.model.StoreVO;

public class MemberBlockListJDBCDAO implements MemberBlockListVO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO memberBlockList (memberID,storeID) VALUES(?, ?)";

	private static final String GET_ALL_STMT = "select storeName, blockListID from v_memberblocklist where  memberID = ?";

	private static final String DELETE = "DELETE FROM memberBlockList where blockListID = ?";

	@Override
	public void insert(MemberBlockListVO MemberBlockListVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, MemberBlockListVO.getMemberID());
			pstmt.setInt(2, MemberBlockListVO.getStoreID());

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
	public void delete(Integer blockListID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, blockListID);

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
	public List<ViewMemberBlockListVO> getAll(Integer memberID) {
		List<ViewMemberBlockListVO> list = new ArrayList<ViewMemberBlockListVO>();
		ViewMemberBlockListVO viewMemberBlockListVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			pstmt.setInt(1, memberID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// VO 也稱為 Domain objects
				viewMemberBlockListVO = new ViewMemberBlockListVO();
				viewMemberBlockListVO.setStoreName(rs.getString("storeName"));
				viewMemberBlockListVO.setBlockListID(rs.getInt("blockListID"));
				list.add(viewMemberBlockListVO); // Store the row in the list
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
////
//		MemberBlockListJDBCDAO dao = new MemberBlockListJDBCDAO();

//		// 新增
//		MemberBlockListVO mblVO1 = new MemberBlockListVO();
//		mblVO1.setMemberID(3);
//		mblVO1.setStoreID(2);
//		dao.insert(mblVO1);

//		// 刪除
//		dao.delete(2);

//		// 查詢
//		List<ViewMemberBlockListVO> list = dao.getAll(23);
//		for (ViewMemberBlockListVO mbl : list) {
//			System.out.print(mbl.getBlockListID() + ",");
//
//			System.out.print(mbl.getStoreName() + ",");
//			System.out.println("---------------------");
//		}
//	}

}
