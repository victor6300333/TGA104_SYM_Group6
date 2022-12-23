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

@Repository
public class CategoryDAO implements CategoryDAO_interface {

	@Autowired
	private DataSource dataSource;

	
	private static final String GET_SEC = "SELECT * FROM category where productSecID= ? ";
	private static final String GET_MAIN = "SELECT * FROM category where productMainID= ? ";

	

	@Override
	public CategoryVO getbyProductSecID(Integer productSecID) {
		
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_SEC);) {

			pstmt.setInt(1, productSecID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
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
	public CategoryVO getbyProductMainID(Integer productMainID) {
		
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_MAIN);) {

			pstmt.setInt(1, productMainID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryVO;
	}
}
