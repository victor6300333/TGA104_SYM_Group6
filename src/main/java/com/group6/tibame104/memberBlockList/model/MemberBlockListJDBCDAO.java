package com.group6.tibame104.memberBlockList.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberBlockListJDBCDAO implements MemberBlockListDAO_interface {

	@Autowired
	private DataSource dataSource;

	private static final String INSERT_STMT = "INSERT INTO memberBlockList (memberID,storeID) VALUES(?, ?)";

	private static final String GET_ALL_STMT = "select storeName, blockListID from v_memberblocklist where  memberID = ?";

	private static final String DELETE = "DELETE FROM memberBlockList where blockListID = ?";

	@Override
	public void insert(MemberBlockListVO MemberBlockListVO) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);) {

			pstmt.setInt(1, MemberBlockListVO.getMemberID());
			pstmt.setInt(2, MemberBlockListVO.getStoreID());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer blockListID) {
		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(DELETE);) {

			pstmt.setInt(1, blockListID);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ViewMemberBlockListVO> getAll(Integer memberID) {
		ViewMemberBlockListVO viewMemberBlockListVO = null;

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);

		) {
			pstmt.setInt(1, memberID);
			try (ResultSet rs = pstmt.executeQuery();) {
				List<ViewMemberBlockListVO> list = new ArrayList<ViewMemberBlockListVO>();
				while (rs.next()) {
					viewMemberBlockListVO = new ViewMemberBlockListVO();
					viewMemberBlockListVO.setStoreName(rs.getString("storeName"));
					viewMemberBlockListVO.setBlockListID(rs.getInt("blockListID"));
					list.add(viewMemberBlockListVO); // Store the row in the list
				}
				return list;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
