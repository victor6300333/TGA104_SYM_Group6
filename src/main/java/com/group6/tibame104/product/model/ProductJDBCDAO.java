package com.group6.tibame104.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBCDAO implements ProductDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO product (storeID,productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,insertTime,productStatus,commentTotal,commentAvgStar) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, 0, 0)";

	private static final String GET_ALL_STMT = "SELECT productID , storeID , productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,productStatus,commentTotal,commentAvgStar FROM product";

	private static final String GET_ALL_STMT_BY_PRODUCT_NAME = "SELECT productID , storeID , productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,productStatus,commentTotal,commentAvgStar FROM product where productName like ?";

	private static final String GET_ONE_STMT = "SELECT productID , storeID , productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,productStatus,commentTotal,commentAvgStar FROM product where productID = ?";

	private static final String UPDATE = "UPDATE product set productSecID=?, productName=?, productStock=?, productPrice=?, productDesc=?, source=?, productImg=?,"
			+ "productImg2=?,productImg3=? where productID = ?";

	private static final String GET_MAX_ID = "select max(productID) as productID from product";
	
	private static final String UPDATE_PUT_ON = "UPDATE product set productStatus= 1 where productID = ?";

	private static final String UPDATE_PUT_OFF = "UPDATE product set productStatus= 0 where productID = ?";
	@Override
	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			// InputStream in = Files.newInputStream(Path.of("index.jpg"));

			pstmt.setInt(1, productVO.getStoreID());
			pstmt.setInt(2, productVO.getProductSecID());
			pstmt.setString(3, productVO.getProductName());
			pstmt.setInt(4, productVO.getProductStock());
			pstmt.setInt(5, productVO.getProductPrice());
			pstmt.setString(6, productVO.getProductDesc());
			pstmt.setString(7, productVO.getSource());
			pstmt.setBytes(8, productVO.getProductImg());
			pstmt.setBytes(9, productVO.getProductImg2());
			pstmt.setBytes(10, productVO.getProductImg3());
			pstmt.setBoolean(11, productVO.getProductStatus());
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
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productVO.getProductSecID());
			pstmt.setString(2, productVO.getProductName());
			pstmt.setInt(3, productVO.getProductStock());
			pstmt.setInt(4, productVO.getProductPrice());
			pstmt.setString(5, productVO.getProductDesc());
			pstmt.setString(6, productVO.getSource());
			pstmt.setBytes(7, productVO.getProductImg());
			pstmt.setBytes(8, productVO.getProductImg2());
			pstmt.setBytes(9, productVO.getProductImg3());
			pstmt.setInt(10, productVO.getProductID());
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
	public ProductVO findByPrimaryKey(Integer ProductID) {

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, ProductID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				productVO = new ProductVO();
				productVO.setProductID(rs.getInt("productID"));
				productVO.setStoreID(rs.getInt("storeID"));
				productVO.setProductSecID(rs.getInt("productSecID"));
				productVO.setProductName(rs.getString("productName"));
				productVO.setProductStock(rs.getInt("productStock"));
				productVO.setProductPrice(rs.getInt("productPrice"));
				productVO.setProductDesc(rs.getString("productDesc"));
				productVO.setSource(rs.getString("source"));
				productVO.setProductImg(rs.getBytes("productImg"));
				productVO.setProductImg2(rs.getBytes("productImg2"));
				productVO.setProductImg3(rs.getBytes("productImg3"));
				productVO.setProductStatus(rs.getBoolean("productStatus"));
				productVO.setCommentTotal(rs.getInt("commentTotal"));
				productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
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
		return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 嚙稽嚙誶穿蕭 Domain objects
				productVO = new ProductVO();
				productVO.setProductID(rs.getInt("productID"));
				productVO.setStoreID(rs.getInt("storeID"));
				productVO.setProductSecID(rs.getInt("productSecID"));
				productVO.setProductName(rs.getString("productName"));
				productVO.setProductStock(rs.getInt("productStock"));
				productVO.setProductPrice(rs.getInt("productPrice"));
				productVO.setProductDesc(rs.getString("productDesc"));
				productVO.setSource(rs.getString("source"));
				productVO.setProductImg(rs.getBytes("productImg"));
				productVO.setProductImg2(rs.getBytes("productImg2"));
				productVO.setProductImg3(rs.getBytes("productImg3"));
				productVO.setProductStatus(rs.getBoolean("productStatus"));
				productVO.setCommentTotal(rs.getInt("commentTotal"));
				productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
				list.add(productVO); // Store the row in the list
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

	@Override
	public List<ProductVO> getAll(String productName) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT_BY_PRODUCT_NAME);
			pstmt.setString(1, "%" + productName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 嚙稽嚙誶穿蕭 Domain objects
				productVO = new ProductVO();
				productVO.setProductID(rs.getInt("productID"));
				productVO.setStoreID(rs.getInt("storeID"));
				productVO.setProductSecID(rs.getInt("productSecID"));
				productVO.setProductName(rs.getString("productName"));
				productVO.setProductStock(rs.getInt("productStock"));
				productVO.setProductPrice(rs.getInt("productPrice"));
				productVO.setProductDesc(rs.getString("productDesc"));
				productVO.setSource(rs.getString("source"));
				productVO.setProductImg(rs.getBytes("productImg"));
				productVO.setProductImg2(rs.getBytes("productImg2"));
				productVO.setProductImg3(rs.getBytes("productImg3"));
				productVO.setProductStatus(rs.getBoolean("productStatus"));
				productVO.setCommentTotal(rs.getInt("commentTotal"));
				productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
				list.add(productVO); // Store the row in the list
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

	@Override
	public Integer findMaxID() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_MAX_ID);

			rs = pstmt.executeQuery();

			Integer productID = null;
			while (rs.next()) {
				productID = rs.getInt("productID");
			}
			return productID;

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
	}

	@Override
	public List<ProductVO> getAllByCond(String quryString) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			pstmt = con.prepareStatement(GET_ALL_STMT + quryString);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 嚙稽嚙誶穿蕭 Domain objects
				productVO = new ProductVO();
				productVO.setProductID(rs.getInt("productID"));
				productVO.setStoreID(rs.getInt("storeID"));
				productVO.setProductSecID(rs.getInt("productSecID"));
				productVO.setProductName(rs.getString("productName"));
				productVO.setProductStock(rs.getInt("productStock"));
				productVO.setProductPrice(rs.getInt("productPrice"));
				productVO.setProductDesc(rs.getString("productDesc"));
				productVO.setSource(rs.getString("source"));
				productVO.setProductImg(rs.getBytes("productImg"));
				productVO.setProductImg2(rs.getBytes("productImg2"));
				productVO.setProductImg3(rs.getBytes("productImg3"));
				productVO.setProductStatus(rs.getBoolean("productStatus"));
				productVO.setCommentTotal(rs.getInt("commentTotal"));
				productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
				list.add(productVO); // Store the row in the list
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

	@Override
	public void putOn(Integer productID) {
		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_PUT_ON);

			pstmt.setInt(1, productID);

			pstmt.executeUpdate();

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
	public void putOff(Integer productID) {
		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_PUT_OFF);

			pstmt.setInt(1, productID);

			pstmt.executeUpdate();

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
	
	public static void main(String[] args) {

//		ProductJDBCDAO dao = new ProductJDBCDAO();

		// insert ����
		/*
		 * C:\\Users\\Tibame_T14\\Desktop\\���\001.jpg
		 * 
		 * 
		 */
		/*
		 * byte[] pictureByteArray = null; try { pictureByteArray =
		 * Tool.getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\���\001.jpg"); }
		 * catch (IOException e) { 
		 * e.printStackTrace(); }
		 */
		// insert
		/*
		 * ProductVO productVO = new ProductVO(); productVO.setStoreID(1);
		 * productVO.setProductSecID(1); productVO.setProductName("�憸冽��");
		 * productVO.setProductStock(1000); productVO.setProductDesc("�����");
		 * productVO.setSource("撠�犖���"); productVO.setProductImg(pictureByteArray);
		 * productVO.setProductImg2(null); productVO.setProductImg3(null);
		 * productVO.setProductStatus(false); dao.insert(productVO);
		 */
		// update
		/*
		 * ProductVO productVO2 = new ProductVO(); productVO2.setProductSecID(1);
		 * productVO2.setProductName("�憸冽��"); productVO2.setProductStock(1000);
		 * productVO2.setProductDesc("敺�"); productVO2.setSource("撠�犖���");
		 * productVO2.setProductImg(null); productVO2.setProductImg2(null);
		 * productVO2.setProductImg3(null); productVO2.setProductStatus(false);
		 * productVO2.setProductID(2); dao.update(productVO2);
		 */
		// delete
//		dao.delete(7014);

		// findByPrimaryKey
		/*
		 * ProductVO productVO3 = dao.findByPrimaryKey(2);
		 * System.out.print(productVO3.getProductSecID()+ ",");
		 * System.out.print(productVO3.getProductName() + ",");
		 * System.out.print(productVO3.getProductStock()+ ",");
		 * System.out.print(productVO3.getProductDesc() + ",");
		 * System.out.print(productVO3.getSource() + ",");
		 * System.out.print(productVO3.getProductImg()+ ",");
		 * System.out.print(productVO3.getProductImg2()+ ",");
		 * System.out.print(productVO3.getProductImg3()+ ",");
		 * System.out.print(productVO3.getProductStatus()+ ",");
		 * System.out.print(productVO3.getCommentTotal()+ ",");
		 * System.out.print(productVO3.getCommentAvgStar()+ ","); System.out.println();
		 * System.out.println("---------------------");
		 * 
		 * byte[] productImg = productVO3.getProductImg();
		 * 
		 * try { Tool.outPictureByteArray(productImg,
		 * "C:\\Users\\Tibame_T14\\Desktop\\���\002.jpg"); } catch (IOException e) { //
		 * e.printStackTrace(); }
		 */

		/*
		 * List<ProductVO> list = dao.getAll(); for (ProductVO aEmp : list) {
		 * System.out.print(aEmp.getProductSecID() + ",");
		 * System.out.print(aEmp.getProductName() + ",");
		 * System.out.print(aEmp.getProductStock() + ",");
		 * System.out.print(aEmp.getProductDesc() + ",");
		 * System.out.print(aEmp.getSource() + ",");
		 * System.out.print(aEmp.getProductImg() + ",");
		 * System.out.print(aEmp.getProductImg2() + ",");
		 * System.out.print(aEmp.getProductImg3() + ",");
		 * System.out.print(aEmp.getProductStatus() + ",");
		 * System.out.print(aEmp.getCommentTotal() + ",");
		 * System.out.print(aEmp.getCommentAvgStar() + ","); System.out.println();
		 * System.out.println("---------------------"); }
		 */
	}



}