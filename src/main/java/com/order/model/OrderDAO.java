package com.order.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.orderlist.model.OrderlistDAO;
import com.orderlist.model.OrderlistVO;
import com.product.model.ProductVO;






public class OrderDAO implements OrderDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO `order` (storeID, storeName, memberID, "
			+ "orderDate ,orderStatus,receiver, phone,creditcardNumber,"
			+ "address, payType, couponID, originalTotal, useShoppingGold, useCouponGold, finalTotal) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	private static final String GET_ONE_STMT = "SELECT orderID, storeID, storeName, memberID, orderDate ,orderStatus,receiver, phone,"
			+ "	creditcardNumber, address, payType, couponID, originalTotal, useShoppingGold,"
			+ "	useCouponGold, finalTotal FROM `order` where orderID = ?";
	private static final String GET_ALL = "SELECT orderID, storeID, storeName, memberID, orderDate ,orderStatus,receiver, phone,"
			+ "	creditcardNumber, address, payType, couponID, originalTotal, useShoppingGold,"
			+ "	useCouponGold, finalTotal FROM `order`";
	@Override
	public void insert(OrderVO orderVO, List<OrderlistVO> buylist) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT,Statement.RETURN_GENERATED_KEYS);

//			con.setAutoCommit(false);
			
//			pstmt.setInt(1, orderVO.getOrderID());
			pstmt.setInt(1,orderVO.getStoreID());
			pstmt.setString(2,orderVO.getStoreName());
			pstmt.setInt(3, orderVO.getMemberID());
			pstmt.setTimestamp(4, orderVO.getOrderDate());
			pstmt.setInt(5, orderVO.getOrderStatus());
			pstmt.setString(6, orderVO.getReceiver());
			pstmt.setString(7, orderVO.getPhone());
			pstmt.setString(8, orderVO.getCreditcardNumber());
			pstmt.setString(9, orderVO.getAddress());
			pstmt.setString(10, orderVO.getPayType());
			pstmt.setInt(11, orderVO.getCouponID());
			pstmt.setInt(12, orderVO.getOriginalTotal());
			pstmt.setInt(13, orderVO.getUseShoppingGold());
			pstmt.setInt(14, orderVO.getUseCouponGold());
			pstmt.setInt(15, orderVO.getFinalTotal());
//			Statement stmt=	con.createStatement();
			pstmt.executeUpdate();
			
			//掘取對應的自增主鍵值
			String next_deptno = null;
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				next_deptno = rs.getString(1);
				System.out.println("自增主鍵值= " + next_deptno +"(剛新增成功的部門編號)");
			} else {
				System.out.println("未取得自增主鍵值");
			}
			rs.close();
			
			orderVO.setOrderID(Integer.parseInt(next_deptno));
			
			OrderlistDAO dao = new OrderlistDAO();
//			System.out.println("list.size()-A="+list.size());
			for (OrderlistVO orderlist : buylist) {
				orderlist.setOrderID(new Integer(next_deptno));
				dao.insert(orderlist);
			}
			
//			con.commit();
//			con.setAutoCommit(true);


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
	public OrderVO getbyOrderID(Integer orderID) {
		OrderVO orderVO = null;
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
			
				orderVO = new OrderVO();
				orderVO.setOrderID(rs.getInt("orderID"));
				orderVO.setStoreID(rs.getInt("storeID"));
				orderVO.setStoreName(rs.getString("storeName"));
				orderVO.setMemberID(rs.getInt("memberID"));
				orderVO.setOrderDate(rs.getTimestamp("orderDate"));
				orderVO.setOrderStatus(rs.getInt("orderStatus"));
				orderVO.setReceiver(rs.getString("receiver"));
				orderVO.setPhone(rs.getString("phone"));
				orderVO.setCreditcardNumber(rs.getString("creditcardNumber"));
				orderVO.setAddress(rs.getString("address"));
				orderVO.setPayType(rs.getString("payType"));
				orderVO.setCouponID(rs.getInt("couponID"));
				orderVO.setOriginalTotal(rs.getInt("originalTotal"));
				orderVO.setUseShoppingGold(rs.getInt("useShoppingGold"));
				orderVO.setUseCouponGold(rs.getInt("useCouponGold"));
				orderVO.setFinalTotal(rs.getInt("finalTotal"));
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
		return orderVO;
	}




	@Override
	public List<OrderVO> getAll() {
		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL);

	

			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				orderVO = new OrderVO();
				orderVO.setOrderID(rs.getInt("orderID"));
				orderVO.setStoreID(rs.getInt("storeID"));
				orderVO.setStoreName(rs.getString("storeName"));
				orderVO.setMemberID(rs.getInt("memberID"));
				orderVO.setOrderDate(rs.getTimestamp("orderDate"));
				orderVO.setOrderStatus(rs.getInt("orderStatus"));
				orderVO.setReceiver(rs.getString("receiver"));
				orderVO.setPhone(rs.getString("phone"));
				orderVO.setCreditcardNumber(rs.getString("creditcardNumber"));
				orderVO.setAddress(rs.getString("address"));
				orderVO.setPayType(rs.getString("payType"));
				orderVO.setCouponID(rs.getInt("couponID"));
				orderVO.setOriginalTotal(rs.getInt("originalTotal"));
				orderVO.setUseShoppingGold(rs.getInt("useShoppingGold"));
				orderVO.setUseCouponGold(rs.getInt("useCouponGold"));
				orderVO.setFinalTotal(rs.getInt("finalTotal"));
				list.add(orderVO);
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
	public List<OrderVO> getAllByComposite(Map<String, String[]> map ) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
		
			String finalSQL = "select * from `order` "
		          + jdbcUtil_CompositeQuery_Emp2.get_WhereCondition(map);
			pstmt = con.prepareStatement(finalSQL);
			System.out.println(finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderID(rs.getInt("orderID"));
				orderVO.setStoreID(rs.getInt("storeID"));
				orderVO.setStoreName(rs.getString("storeName"));
				orderVO.setMemberID(rs.getInt("memberID"));
				orderVO.setOrderDate(rs.getTimestamp("orderDate"));
				orderVO.setOrderStatus(rs.getInt("orderStatus"));
				orderVO.setReceiver(rs.getString("receiver"));
				orderVO.setPhone(rs.getString("phone"));
				orderVO.setCreditcardNumber(rs.getString("creditcardNumber"));
				orderVO.setAddress(rs.getString("address"));
				orderVO.setPayType(rs.getString("payType"));
				orderVO.setCouponID(rs.getInt("couponID"));
				orderVO.setOriginalTotal(rs.getInt("originalTotal"));
				orderVO.setUseShoppingGold(rs.getInt("useShoppingGold"));
				orderVO.setUseCouponGold(rs.getInt("useCouponGold"));
				orderVO.setFinalTotal(rs.getInt("finalTotal"));
				list.add(orderVO);
			}
	
			// Handle any SQL errors
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
}
