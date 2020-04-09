package com.springbook.biz.impl;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.DrinkService;
import com.springbook.biz.DrinkVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("DrinkDAO")
public class DrinkDAO implements DrinkService {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String drink_insert = "insert into drink values (?,?,?)";
	private final String drink_update = "update drink set name=?, price=?, recipe=? where name=?";
	private final String drink_delete = "delete drink where name=?";
	private final String drink_get = "select * from drink where name=?";
	private final String drink_list = "select * from drink";
	
	@Override
	public void insertdrink(DrinkVO vo) {
		System.out.println("insert 기능처리");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(drink_insert);
			stmt.setString(1, vo.getName());
			stmt.setInt(2, vo.getPrice());
			stmt.setString(3, vo.getRecipe());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt,  conn);
		}
	}
	
	@Override
	public void updatedrink(DrinkVO vo, String before) {
		System.out.println("update 기능처리");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(drink_update);
			stmt.setString(1, vo.getName());
			stmt.setInt(2, vo.getPrice());
			stmt.setString(3, vo.getRecipe());
			stmt.setString(4, before);
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt,  conn);
		}
	}
	
	@Override
	public void deletedrink(DrinkVO vo) {
		System.out.println("delete 기능처리");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(drink_delete);
			stmt.setString(1, vo.getName());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt,  conn);
		}
	}
	
	@Override
	public DrinkVO getdrink(DrinkVO vo) {
		System.out.println("getdrink 기능처리");
		DrinkVO drink = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt=conn.prepareStatement(drink_get);
			stmt.setString(1, vo.getName());
			rs = stmt.executeQuery();
			if(rs.next()){
				drink = new DrinkVO();
				drink.setName(rs.getString("name"));
				drink.setPrice(rs.getInt("price"));
				drink.setRecipe(rs.getString("recipe"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return drink;
	}
	
	@Override
	public List<DrinkVO> getdrinkList(DrinkVO vo){
		System.out.println("getdrink get 기능처리");
		List<DrinkVO> drinkList = new ArrayList<DrinkVO>();
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(drink_list);
			rs = stmt.executeQuery();
			while(rs.next()){
				DrinkVO drink = new DrinkVO();
				drink.setName(rs.getString("name"));
				drink.setPrice(rs.getInt("price"));
				drink.setRecipe(rs.getString("recipe"));
				drinkList.add(drink);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return drinkList;
	}
}
