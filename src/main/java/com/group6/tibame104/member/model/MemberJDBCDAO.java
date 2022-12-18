package com.group6.tibame104.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberJDBCDAO implements MemberVO_interface {
	@Autowired
	private DataSource dataSource;

	private static final String INSERT_STMT = "INSERT INTO member (userAccount,userPassword,userName,phone,mail,gender,birthday,userPhoto,registrationTime,mailCertification,idNumber,address,sellerAuditApprovalState,currentShoppingCoin)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT memberID,userAccount,userPassword,userName,phone,mail,gender,birthday,userPhoto,registrationTime,mailCertification,idNumber,address,sellerAuditApprovalState,currentShoppingCoin "
			+ "FROM member order by memberID";

	private static final String GET_ONE_STMT = "SELECT memberID,userAccount,userName,userPassword,phone,mail,gender,birthday,userPhoto,registrationTime,mailCertification,idNumber,address,sellerAuditApprovalState,currentShoppingCoin "
			+ "FROM member where mail = ?;";

	private static final String GET_ONE_MEMBER = "SELECT memberID,userAccount,userName,userPassword,phone,mail,gender,birthday,userPhoto,registrationTime,mailCertification,idNumber,address,sellerAuditApprovalState,currentShoppingCoin "
			+ "FROM member where memberID = ?";

	private static final String DELETE = "DELETE FROM member where memberID = ?";

	private static final String CONTINUE_UPDATE = "UPDATE member set gender=?, birthday=?, userPhoto=?, mailCertification=?, idNumber=?, address=?,sellerAuditApprovalState=?,currentShoppingCoin=? where memberID = ?";

	private static final String UPDATEONE = "UPDATE member set userName=?, userAccount=?, phone=?, mail=?, userPhoto= coalesce(?, userPhoto), idNumber=?, address=?  where memberID = ?";

	private static final String UPDATEONE_PASSWOED = "UPDATE member set userPassword=? where memberID = ?";

	private static final String GET_LASTONE_MEMBER = "select max(memberID) from member;";

	private static final String MEMBER_LOGIN = "SELECT * FROM member WHERE mail = ?  AND userPassword = ?";

	private static final String FORGET_PASSWORD = "SELECT * FROM member WHERE mail = ?";

	@Override
	public void insert(MemberVO memberVO) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);
		) {
			pstmt.setString(1, memberVO.getUserAccount());
			pstmt.setString(2, memberVO.getUserPassword());
			pstmt.setString(3, memberVO.getUserName());
			pstmt.setString(4, memberVO.getPhone());
			pstmt.setString(5, memberVO.getMail());
			pstmt.setString(6, memberVO.getGender());
			pstmt.setDate(7, memberVO.getBirthday());
			pstmt.setBytes(8, memberVO.getUserPhoto());
			pstmt.setTimestamp(9, memberVO.getRegistrationTime());
			pstmt.setBoolean(10, memberVO.getMailCertification());
			pstmt.setString(11, memberVO.getIdNumber());
			pstmt.setString(12, memberVO.getAddress());
			pstmt.setBoolean(13, memberVO.getSellerAuditApprovalState());
			pstmt.setInt(14, memberVO.getCurrentShoppingCoin());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(MemberVO memberVO) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(CONTINUE_UPDATE);
		) {
			pstmt.setString(1, memberVO.getGender());
			pstmt.setDate(2, memberVO.getBirthday());
			pstmt.setBytes(3, memberVO.getUserPhoto());
			pstmt.setBoolean(4, memberVO.getMailCertification());
			pstmt.setString(5, memberVO.getIdNumber());
			pstmt.setString(6, memberVO.getAddress());
			pstmt.setBoolean(7, memberVO.getSellerAuditApprovalState());
			pstmt.setInt(8, memberVO.getCurrentShoppingCoin());
			pstmt.setInt(9, memberVO.getMemberID());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOne(MemberVO memberVO) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATEONE);
		) {
			pstmt.setString(1, memberVO.getUserName());
			pstmt.setString(2, memberVO.getUserAccount());
			pstmt.setString(3, memberVO.getPhone());
			pstmt.setString(4, memberVO.getMail());
			pstmt.setBytes(5, memberVO.getUserPhoto());
			pstmt.setString(6, memberVO.getIdNumber());
			pstmt.setString(7, memberVO.getAddress());
			pstmt.setInt(8, memberVO.getMemberID());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void updateOnePasswoed(MemberVO memberVO) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATEONE_PASSWOED);
		) {
			pstmt.setString(1, memberVO.getUserPassword());
			pstmt.setInt(2, memberVO.getMemberID());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer memberID) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE);
		) {
			pstmt.setInt(1, memberID);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO getByPrimaryKey(Integer memberID) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ONE_MEMBER);
		) {
			pstmt.setInt(1, memberID);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					MemberVO memberVO = new MemberVO();
					memberVO.setMemberID(rs.getInt("memberID"));
					memberVO.setUserAccount(rs.getString("userAccount"));
					memberVO.setUserPassword(rs.getString("userPassword"));
					memberVO.setUserName(rs.getString("userName"));
					memberVO.setPhone(rs.getString("phone"));
					memberVO.setMail(rs.getString("mail"));
					memberVO.setGender(rs.getString("gender"));
					memberVO.setBirthday(rs.getDate("birthday"));
					memberVO.setUserPhoto(rs.getBytes("userPhoto"));
					memberVO.setRegistrationTime(rs.getTimestamp("registrationTime"));
					memberVO.setMailCertification(rs.getBoolean("mailCertification"));
					memberVO.setIdNumber(rs.getString("idNumber"));
					memberVO.setAddress(rs.getString("address"));
					memberVO.setSellerAuditApprovalState(rs.getBoolean("sellerAuditApprovalState"));
					memberVO.setCurrentShoppingCoin(rs.getInt("currentShoppingCoin"));
					return memberVO;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberVO getOneMemberByMail(String mail) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);
		) {
			pstmt.setString(1, mail);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					MemberVO memberVO = new MemberVO();
					memberVO.setMemberID(rs.getInt("memberID"));
					memberVO.setUserAccount(rs.getString("userAccount"));
					memberVO.setUserPassword(rs.getString("userPassword"));
					memberVO.setUserName(rs.getString("userName"));
					memberVO.setPhone(rs.getString("phone"));
					memberVO.setMail(rs.getString("mail"));
					memberVO.setGender(rs.getString("gender"));
					memberVO.setBirthday(rs.getDate("birthday"));
					memberVO.setUserPhoto(rs.getBytes("userPhoto"));
					memberVO.setRegistrationTime(rs.getTimestamp("registrationTime"));
					memberVO.setMailCertification(rs.getBoolean("mailCertification"));
					memberVO.setIdNumber(rs.getString("idNumber"));
					memberVO.setAddress(rs.getString("address"));
					memberVO.setSellerAuditApprovalState(rs.getBoolean("sellerAuditApprovalState"));
					memberVO.setCurrentShoppingCoin(rs.getInt("currentShoppingCoin"));
					return memberVO;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MemberVO> getAll() {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);	
		) {
			try (ResultSet rs = pstmt.executeQuery();) {
				List<MemberVO> list = new ArrayList<MemberVO>();
				while (rs.next()) {
					MemberVO memberVO = new MemberVO();
					memberVO.setMemberID(rs.getInt("memberID"));
					memberVO.setUserAccount(rs.getString("userAccount"));
					memberVO.setUserPassword(rs.getString("userPassword"));
					memberVO.setUserName(rs.getString("userName"));
					memberVO.setPhone(rs.getString("phone"));
					memberVO.setMail(rs.getString("mail"));
					memberVO.setGender(rs.getString("gender"));
					memberVO.setBirthday(rs.getDate("birthday"));
					memberVO.setUserPhoto(rs.getBytes("userPhoto"));
					memberVO.setRegistrationTime(rs.getTimestamp("registrationTime"));
					memberVO.setMailCertification(rs.getBoolean("mailCertification"));
					memberVO.setIdNumber(rs.getString("idNumber"));
					memberVO.setAddress(rs.getString("address"));
					memberVO.setSellerAuditApprovalState(rs.getBoolean("sellerAuditApprovalState"));
					memberVO.setCurrentShoppingCoin(rs.getInt("currentShoppingCoin"));
					list.add(memberVO); // Store the row in the list
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean findOneMemberForLogin(String mail, String userPassword) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(MEMBER_LOGIN);
		) {
			pstmt.setString(1, mail);
			pstmt.setString(2, userPassword);
			try (ResultSet rs = pstmt.executeQuery();) {
				return rs.next() && rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Integer selectLastMemberID() {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_LASTONE_MEMBER);
		) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean findMemberByMail(String mail) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(FORGET_PASSWORD);
		) {
			pstmt.setString(1, mail);
			try (ResultSet rs = pstmt.executeQuery();) {
				return rs.next() && rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// test
//	public static void main(String[] args) {

//		MemberJDBCDAO dao = new MemberJDBCDAO();
//		System.out.println(dao.selectLastMemberID());
//		// 獲得時間戳記
//		Timestamp time = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String timeStr = df.format(time);
//		time = Timestamp.valueOf(timeStr);
//
//		byte[] photo = new byte[10];
////		System.out.println(time);
//
//		// 新增
//		MemberVO memVO1 = new MemberVO();
//		memVO1.setUserAccount("a2234534522");
//		memVO1.setUserPassword("aaaaaaaa");
//		memVO1.setUserName("茶陶324525");
//		memVO1.setPhone("0988888245245888");
//		memVO1.setMail("a22222222452@gmail.com");
//		memVO1.setGender("M");
//		memVO1.setBirthday(java.sql.Date.valueOf("1993-01-02"));
//		memVO1.setUserPhoto(photo);
//		memVO1.setRegistrationTime(java.sql.Timestamp.valueOf(timeStr));
//		memVO1.setMailCertification(true);
//		memVO1.setAddress("台北市哈哈區哈哈街哈哈路101號101樓");
//		memVO1.setSellerAuditApprovalState(false);
//		memVO1.setCurrentShoppingCoin(1000111);
//		dao.insert(memVO1);

	// 修改
//		MemberVO memVO2 = new MemberVO();
//		memVO2.setMemberId(21);
//		memVO2.setUserAccount("a3333333");
//		memVO2.setUserPassword("bbbbbbbb");
//		memVO2.setUserName("茶陶123");
//		memVO2.setPhone("09777777");
//		memVO2.setMail("a3333333@gmail.com");
//		memVO2.setGender("W");
//		memVO2.setBirthday(java.sql.Date.valueOf("1991-01-02"));
//		memVO2.setMailCertification(false);
//		memVO2.setAddress("台北市vv區vv街vv路101號101樓");
//		memVO2.setSellerAuditApprovalState(true);
//		memVO2.setCurrentShoppingCoin(111);
//		dao.update(memVO2);
//
//		// 刪除
//		dao.delete(21);
//
//		// 查詢
//		MemberVO memVO2 = dao.findByPrimaryKey(20);
//		System.out.print(memVO2.getMemberId() + ",");
//		System.out.print(memVO2.getUserAccount() + ",");
//		System.out.print(memVO2.getUserPassword() + ",");
//		System.out.print(memVO2.getUserName() + ",");
//		System.out.print(memVO2.getPhone() + ",");
//		System.out.print(memVO2.getMail() + ",");
//		System.out.print(memVO2.getGender() + ",");
//		System.out.println(memVO2.getBirthday());
//		System.out.println(memVO2.getUserPhoto());
//		System.out.println(memVO2.getRegistrationTime());
//		System.out.println(memVO2.getMailCertification());
//		System.out.println(memVO2.getIdNumber());
//		System.out.println(memVO2.getAddress());
//		System.out.println(memVO2.getSellerAuditApprovalState());
//		System.out.println(memVO2.getCurrentShoppingCoin());
//		System.out.println("---------------------");
//
//		// 查詢
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO amem : list) {
//			System.out.print(amem.getMemberId() + ",");
//			System.out.print(amem.getUserAccount() + ",");
//			System.out.print(amem.getUserPassword() + ",");
//			System.out.print(amem.getUserName() + ",");
//			System.out.print(amem.getPhone() + ",");
//			System.out.print(amem.getMail() + ",");
//			System.out.print(amem.getGender() + ",");
//			System.out.println(amem.getBirthday());
//			System.out.println(amem.getUserPhoto());
//			System.out.println(amem.getRegistrationTime());
//			System.out.println(amem.getMailCertification());
//			System.out.println(amem.getIdNumber());
//			System.out.println(amem.getAddress());
//			System.out.println(amem.getSellerAuditApprovalState());
//			System.out.println(amem.getCurrentShoppingCoin());
//			System.out.println("---------------------");
//		}

//	}

}
