package com.shoppingGoldRecord.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingGoldRecordDAO implements ShoppingGoldRecordDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = 
		"INSERT INTO shoppingGoldRecord (memberID, useDate, obtainShoppingCoin, plusOrMinus) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT shoppingGoldRecordID, memberID, useDate, obtainShoppingCoin, plusOrMinus FROM shoppinggoldrecord order by shoppingGoldRecordID;";
	private static final String GET_ONE_STMT = 
		"SELECT shoppingGoldRecordID, memberID, useDate, obtainShoppingCoin, plusOrMinus FROM shoppinggoldrecord where memberID = ?";
	private static final String UPDATE = 
		"UPDATE shoppingGoldRecordID set shoppingGoldRecordID = ?, memberID = ?, useDate = ?, obtainShoppingCoin = ?, plusOrMinus = ? where shoppingGoldRecordID = ?";

	@Override
	public void insert(ShoppingGoldRecordVO shoppingGoldRecordVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1, shoppingGoldRecordVO.getMemberID());
			pstmt.setTimestamp(2, shoppingGoldRecordVO.getUseDate());
			pstmt.setInt(3, shoppingGoldRecordVO.getObtainShoppingCoin());
			pstmt.setInt(4, shoppingGoldRecordVO.getPlusOrMinus());

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
	public void update(ShoppingGoldRecordVO shoppingGoldRecordVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, shoppingGoldRecordVO.getShoppingGoldRecordID());
			pstmt.setInt(2, shoppingGoldRecordVO.getMemberID());
			pstmt.setTimestamp(3, shoppingGoldRecordVO.getUseDate());
			pstmt.setInt(4, shoppingGoldRecordVO.getObtainShoppingCoin());
			pstmt.setInt(5, shoppingGoldRecordVO.getPlusOrMinus());

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
	public ShoppingGoldRecordVO findByPrimaryKey(Integer ShoppingGoldRecordID) {

		ShoppingGoldRecordVO shoppingGoldRecordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, ShoppingGoldRecordID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				shoppingGoldRecordVO = new ShoppingGoldRecordVO();
				shoppingGoldRecordVO.setShoppingGoldRecordID(rs.getInt("shoppingGoldRecordID"));
				shoppingGoldRecordVO.setMemberID(rs.getInt("memberID"));
				shoppingGoldRecordVO.setUseDate(rs.getTimestamp("useDate"));
				shoppingGoldRecordVO.setObtainShoppingCoin(rs.getInt("obtainShoppingCoin"));
				shoppingGoldRecordVO.setPlusOrMinus(rs.getInt("plusOrMinus"));
				
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
		return shoppingGoldRecordVO;
	}

	@Override
	public List<ShoppingGoldRecordVO> getAll() {
		List<ShoppingGoldRecordVO> list = new ArrayList<ShoppingGoldRecordVO>();
		ShoppingGoldRecordVO shoppingGoldRecordVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// shoppinggoldrecordVO 也稱為 Domain objects
				shoppingGoldRecordVO = new ShoppingGoldRecordVO();
				shoppingGoldRecordVO.setShoppingGoldRecordID(rs.getInt("shoppingGoldRecordID"));
				shoppingGoldRecordVO.setMemberID(rs.getInt("memberID"));
				shoppingGoldRecordVO.setUseDate(rs.getTimestamp("useDate"));
				shoppingGoldRecordVO.setObtainShoppingCoin(rs.getInt("obtainShoppingCoin"));
				shoppingGoldRecordVO.setPlusOrMinus(rs.getInt("plusOrMinus"));
				list.add(shoppingGoldRecordVO); // Store the row in the list
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
	
	public List<ShoppingGoldRecordVO> getAllShoppingGoldRecord(Integer memberID) {
		List<ShoppingGoldRecordVO> list = new ArrayList<ShoppingGoldRecordVO>();
		ShoppingGoldRecordVO shoppingGoldRecordVO = null;

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
				shoppingGoldRecordVO = new ShoppingGoldRecordVO();
				shoppingGoldRecordVO.setShoppingGoldRecordID(rs.getInt("shoppingGoldRecordID"));
				shoppingGoldRecordVO.setMemberID(rs.getInt("memberID"));
				shoppingGoldRecordVO.setUseDate(rs.getTimestamp("useDate"));
				shoppingGoldRecordVO.setObtainShoppingCoin(rs.getInt("obtainShoppingCoin"));
				shoppingGoldRecordVO.setPlusOrMinus(rs.getInt("plusOrMinus"));
				list.add(shoppingGoldRecordVO); // Store the row in the list
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
//		EmpJDBCDAO dao = new EmpJDBCDAO();
//
//		// 新增
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);
//
//		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);
//
//		// 刪除
//		dao.delete(7014);
//
//		// 查詢
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");
//
//		// 查詢
//		List<EmpVO> list = dao.getAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
//			System.out.println();
//		}
//	}
}
