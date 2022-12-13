package com.groupproduct.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.grouporder.model.GrouporderJDBCDAO;
import com.grouporder.model.GrouporderVO;
import com.groupproduct.model.GroupproductVO;

public class GroupproductJDBCDAO implements GroupproductDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "lucky777";

	private static final String INSERT_STMT = "INSERT INTO groupBuyProduct(groupBuyProductPrice,groupBuyProductPicture,groupBuyProductDescrip) VALUES (?, ?, ?)";
	private static final String UPDATE = "UPDATE groupBuyProduct set groupBuyProductPrice=?,groupBuyProductPicture = Coalesce (?,groupBuyProductPicture),groupBuyProductDescrip= ? WHERE groupBuyProductID=?";
	private static final String DELETE = "DELETE FROM groupBuyProduct where groupbuyProductID = ?;";
	private static final String GET_ONE_STMT = "SELECT groupBuyProductID ,groupBuyProductPrice ,groupBuyProductPicture ,groupBuyProductDescrip FROM groupBuyProduct WHERE groupBuyProductID = ?;";
	private static final String GET_ALL_STMT = "SELECT groupBuyProductID ,groupBuyProductPrice ,groupBuyProductPicture ,groupBuyProductDescrip FROM groupBuyProduct";

	@Override
	public void insert(GroupproductVO groupproductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, groupproductVO.getGroupBuyProductPrice());
			pstmt.setBytes(2, groupproductVO.getGroupBuyProductPicture());
			pstmt.setString(3, groupproductVO.getGroupBuyProductDescrip());

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
	public void update(GroupproductVO groupproductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, groupproductVO.getGroupBuyProductPrice());
			pstmt.setBytes(2, groupproductVO.getGroupBuyProductPicture());
			pstmt.setString(3, groupproductVO.getGroupBuyProductDescrip());
			pstmt.setInt(4, groupproductVO.getGroupBuyProductID());

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
	public void delete(Integer groupBuyProductID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, groupBuyProductID);

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
	public GroupproductVO findByPrimaryKey(Integer groupBuyProductID) {

		GroupproductVO groupproductVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, groupBuyProductID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				groupproductVO = new GroupproductVO();

				groupproductVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
				groupproductVO.setGroupBuyProductPrice(rs.getInt("groupbuyProductPrice"));
				groupproductVO.setGroupBuyProductPicture(rs.getBytes("groupbuyProductPicture"));
				groupproductVO.setGroupBuyProductDescrip(rs.getString("groupbuyProductDescrip"));

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
		return groupproductVO;
	}
	// 查詢ALL

	public List<GroupproductVO> getAll() {
		List<GroupproductVO> list = new ArrayList<GroupproductVO>();
		GroupproductVO groupproductVO = null;

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

				groupproductVO = new GroupproductVO();

				groupproductVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
				groupproductVO.setGroupBuyProductPrice(rs.getInt("groupBuyProductPrice"));
				groupproductVO.setGroupBuyProductPicture(rs.getBytes("groupBuyProductPicture"));
				groupproductVO.setGroupBuyProductDescrip(rs.getString("groupBuyProductDescrip"));
				

				list.add(groupproductVO); // Store the row in the list
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

		GroupproductJDBCDAO dao = new GroupproductJDBCDAO();

////    新增
//		GroupproductVO groupproductVO = new GroupproductVO();
//
//		
//		groupproductVO.setGroupBuyProductPrice(32122);
//		groupproductVO.setGroupBuyProductPicture(null);
//		groupproductVO.setGroupBuyProductDescrip("123");
//		
//		dao.insert(groupproductVO);
//		
//    修改		
		GroupproductVO groupproductVO2 = new GroupproductVO();
	
		groupproductVO2.setGroupBuyProductID(1);
		groupproductVO2.setGroupBuyProductPrice(1);
		groupproductVO2.setGroupBuyProductPicture(null);
		groupproductVO2.setGroupBuyProductDescrip("ggg");
		
		dao.update(groupproductVO2);

////	刪除
//		dao.delete(2);

////    單一查詢
//		GroupproductVO groupproductVO3 = dao.findByPrimaryKey(1);
//		
//		System.out.print(groupproductVO3.getGroupBuyProductID() + ",");
//		System.out.print(groupproductVO3.getGroupBuyProductPrice() + ",");
//		System.out.print(groupproductVO3.getGroupBuyProductPicture()+ ",");
//		System.out.println(groupproductVO3.getGroupBuyProductDescrip());
//		System.out.println("---------------------");

////    查詢all
//		List<GroupproductVO> list = dao.getAll();
//		for (GroupproductVO aEmp : list) {
//			System.out.print(aEmp.getGroupBuyProductID() + ",");
//			System.out.print(aEmp.getGroupBuyProductPrice() + ",");
//			System.out.print(aEmp.getGroupBuyProductPicture() + ",");
//			System.out.print(aEmp.getGroupBuyProductDescrip() + ",");
//
//			System.out.println();
//		}

	}
}
