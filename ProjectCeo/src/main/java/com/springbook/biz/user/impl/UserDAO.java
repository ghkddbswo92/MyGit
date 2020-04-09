package com.springbook.biz.user.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("UserDAO")
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from user where userid=? and password=?";
	private final String SIGN_IN = "insert into user (userid, password, username) values(?,?,?)";
	private final String Point_Update = "update user set point=point-? where userid=?";
	private final String check_User = "select userid from user";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			while(rs.next()){
				user = new UserVO();
				user.setId(rs.getString("USERID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("USERNAME"));
				user.setPoint(rs.getInt("POINT"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 기능처리");
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SIGN_IN);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
	
	public void point_update(UserVO vo,int price) {
		System.out.println("===> JDBC로 updateUser() 기능처리");
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(Point_Update);
			stmt.setInt(1,price);
			stmt.setString(2, vo.getId());
			stmt.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
	
	public List<UserVO> check_User() {
		List<UserVO> list = new ArrayList<UserVO>();
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(check_User);
			rs = stmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("userid"));
				list.add(user);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return list;
	}
}
