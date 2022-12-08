package com.orderlist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class OrderlistDAO implements OrderlistDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	Integer orderDetailID;
	Integer orderID;
    Integer productID;
    Integer quantity;
    Integer price;
    Integer subTotal;
    String shopReview;
    String shopComment;
    String buyerReview;
    String buyerComment;
	
	private static final String INSERT_STMT = "INSERT INTO orderDetail (orderID, productID,"
			+ "			quantity ,price ,subTotal, shopReview,shopComment, buyerReview, buyerComment)"
			+ "			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	private static final String GET_ALL_STMT = 
//		"SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 order by empno";
	private static final String GET_ONE_STMT = "SELECT orderDetailID, orderID, productID, quantity ,price ,"
			+ "			subTotal, shopReview,shopComment, buyerReview, buyerComment "
			+ "				FROM orderDetail where orderID = ?";
//	private static final String DELETE = 
//		"DELETE FROM emp2 where empno = ?";
	private static final String UPDATE = 
		"UPDATE Project_test.orderDetail set buyerReview=?, buyerComment=? where orderDetailID = ?";

	public List<OrderlistVO> findByOrderID(Integer orderID) {
		List<OrderlistVO> list = new ArrayList<OrderlistVO>();
		OrderlistVO orderlistVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, orderID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// orderlistVo 也稱為 Domain objects
				orderlistVO = new OrderlistVO();
				orderlistVO.setOrderDetailID(rs.getInt("orderDetailID"));
				orderlistVO.setOrderID(rs.getInt("orderID"));			
				orderlistVO.setProductID(rs.getInt("productID"));
				orderlistVO.setQuantity(rs.getInt("quantity"));
				orderlistVO.setPrice(rs.getInt("price"));
				orderlistVO.setSubTotal(rs.getInt("subTotal"));
				orderlistVO.setShopReview(rs.getString("shopReview"));
				orderlistVO.setShopComment(rs.getString("shopComment"));
				orderlistVO.setBuyerReview(rs.getString("buyerReview"));
				orderlistVO.setBuyerComment(rs.getString("buyerComment"));
				list.add(orderlistVO);

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
	public void insert(OrderlistVO orderlistVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1,orderlistVO.getOrderID());
			pstmt.setInt(2, orderlistVO.getProductID());
			pstmt.setInt(3, orderlistVO.getQuantity());
			pstmt.setInt(4, orderlistVO.getPrice());
			pstmt.setInt(5, orderlistVO.getSubTotal());
			pstmt.setString(6, orderlistVO.getShopReview());
			pstmt.setString(7, orderlistVO.getShopComment());
			pstmt.setString(8, orderlistVO.getBuyerReview());
			pstmt.setString(9, orderlistVO.getBuyerComment());
			
			
			

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
	public void update(OrderlistVO orderlistVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, orderlistVO.getBuyerReview());
			pstmt.setString(2, orderlistVO.getBuyerComment());
			pstmt.setInt(3, orderlistVO.getOrderDetailID());
	

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







	
//	public static void main(String[] args) {
//		OrderlistDAO dao = new OrderlistDAO();
//		List<OrderlistVO> list = dao.findByOrderID(12);
//		for (OrderlistVO orderlistVO : list) {
//			System.out.print(orderlistVO.getOrderDetailID() + ",");
//			System.out.print(orderlistVO.getOrderID() + ",");
//			System.out.print(orderlistVO.getProductID() + ",");
//			System.out.print(orderlistVO.getQuantity() + ",");
//			System.out.print(orderlistVO.getPrice() + ",");
//			System.out.print(orderlistVO.getSubTotal() + ",");
//			System.out.print(orderlistVO.getShopReview() + ",");
//			System.out.print(orderlistVO.getShopComment()+ ",");
//			System.out.print(orderlistVO.getBuyerReview()+ ",");
//			System.out.print(orderlistVO.getBuyerComment()+ ",");
//			System.out.println();
//			
//			
//			
//		}
	

	}
	

