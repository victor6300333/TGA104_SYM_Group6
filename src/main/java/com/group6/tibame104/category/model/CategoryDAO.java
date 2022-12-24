package com.group6.tibame104.category.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group6.tibame104.orderlist.model.OrderlistDAO;
import com.group6.tibame104.orderlist.model.OrderlistDAO_interface;
import com.group6.tibame104.orderlist.model.OrderlistVO;
import com.group6.tibame104.product.model.ProductVO;

@Repository
public class CategoryDAO implements CategoryDAO_interface {

	@Autowired
	private DataSource dataSource;

	
	private static final String GET_NAME = "SELECT * FROM category where productName like ? ";
	private static final String GET_PRODUCTID = "SELECT * FROM category where productID= ? ";
	private static final String GET_SEC = "SELECT * FROM category where productSecID= ? ";
	private static final String GET_MAIN = "SELECT * FROM category where productMainID= ? ";

	
	@Override
	public List<CategoryVO> getbyProductName(String productName){
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_NAME);) {

			pstmt.setString(1, "%" + productName + "%");

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					list.add(categoryVO);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public CategoryVO getbyProductID(Integer productID) {
		
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_PRODUCTID);) {

			pstmt.setInt(1, productID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryVO;

	}
	
	
	@Override
	public List<CategoryVO> getbyProductSecID(Integer productSecID) {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_SEC);) {

			pstmt.setInt(1, productSecID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					list.add(categoryVO);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}


	@Override
	public List<CategoryVO> getbyProductMainID(Integer productMainID) {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_MAIN);) {

			pstmt.setInt(1, productMainID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					list.add(categoryVO);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
