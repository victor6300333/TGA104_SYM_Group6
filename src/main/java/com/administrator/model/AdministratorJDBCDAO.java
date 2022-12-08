package com.administrator.model;

import java.sql.*;
import java.util.*;

import com.ad.model.AdVO;


public class AdministratorJDBCDAO implements AdministratorDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String GET_ONE_MEMBER = 
		"SELECT member FROM member where memberID = ?";
	private static final String GET_ALL_MEMBER = 
		"SELECT memberID, storeID, storeName, storeAddress, phoneNumber, createDate, taxID, storeAuditStatus FROM store order by memberID";
	private static final String UPDATE = 
		"UPDATE store set storeAuditStatus=? where memberID = ?";
			
	@Override
	public AdministratorVO selectMemberID(Integer memberID) {
		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_MEMBER);
			
			pstmt.setInt(1, memberID);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				administratorVO = new AdministratorVO();
				administratorVO.setMemberID(rs.getInt("memberID"));
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
		return administratorVO;
	}

	@Override
	public void update(AdministratorVO administratorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, administratorVO.getMemberID());
			pstmt.setInt(1, administratorVO.getStoreAuditStatus());

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
	public List<AdministratorVO> getAll() {

		
		
		
		
		List<AdministratorVO> list = new ArrayList<AdministratorVO>();
		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_MEMBER);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// adVO也稱為 Domain objects
				administratorVO = new AdministratorVO();
				administratorVO.setMemberID(rs.getInt("memberID"));
				administratorVO.setStoreID(rs.getInt("storeID"));
				administratorVO.setStoreName(rs.getString("storeName"));
				administratorVO.setStoreAddress(rs.getString("storeAddress"));
				administratorVO.setPhoneNumber(rs.getString("phoneNumber"));
				administratorVO.setCreateDate(rs.getDate("createDate"));
				administratorVO.setTaxID(rs.getString("taxID"));
				administratorVO.setStoreAuditStatus(rs.getInt("storeAuditStatus"));
				
				list.add(administratorVO); // Store the row in the list
				
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

	AdministratorJDBCDAO dao = new AdministratorJDBCDAO();
//	// 修改
//	AdministratorVO empVO2 = new AdministratorVO();
//			empVO2.setStoreAuditStatus(1);
////			empVO2.setStoreAuditStatus(0);
//			dao.update(empVO2);
			
			
			
			// 查詢
	
			AdministratorVO empVO3 = dao.selectMemberID(1);
			System.out.print(empVO3.getMemberID() + ",");
			System.out.println("---------------------");

			// 查詢
			List<AdministratorVO> list = dao.getAll();
			for (AdministratorVO aEmp : list) {
				System.out.print(aEmp.getMemberID() + ",");
				System.out.print(aEmp.getStoreName() + ",");
				System.out.print(aEmp.getStoreAddress() + ",");
				System.out.print(aEmp.getPhoneNumber() + ",");
				System.out.print(aEmp.getCreateDate());
				System.out.print(aEmp.getTaxID());
				System.out.print(aEmp.getStoreAuditStatus());
				System.out.println();
				
			}
	
	
	}
	
	
}
