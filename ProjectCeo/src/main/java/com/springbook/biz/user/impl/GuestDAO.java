package com.springbook.biz.user.impl;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.GuestVO;
@Repository("GuestDAO")
public class GuestDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs =  null;
	
	private final String  Menu = "select * from guest ";
	
	public List<GuestVO> getMenuList(GuestVO gvo){
		System.out.println("===> JDBC로 getMenuList() 기능 처리");
		List<GuestVO> menuList = new ArrayList<GuestVO>();
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(Menu);
			rs = stmt.executeQuery();
			while(rs.next()){
				GuestVO guest = new GuestVO();
				guest.setMenu(rs.getString("MENU"));
				guest.setPrice(rs.getInt("PRICE"));
				menuList.add(guest);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return menuList;
	}
}
