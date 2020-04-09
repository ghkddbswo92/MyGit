package com.springbook.biz.impl;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.RecipeService;
import com.springbook.biz.RecipeVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("RecipeDAO")
public class RecipeDAO implements RecipeService {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String recipe_insert = "insert into recipe values (?,?,?,?)";
	private final String recipe_update = "update recipe set action=?, time=?, priority=? where num=?";
	private final String recipe_delete = "delete recipe where num=?";
	private final String recipe_get = "select * from recipe where num=?";
	private final String recipe_list = "select * from recipe order by num";
	
	@Override
	public void insertRecipe(RecipeVO vo) {
		System.out.println("insert 기능처리");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(recipe_insert);
			stmt.setString(1, vo.getNum());
			stmt.setString(2, vo.getAction());
			stmt.setInt(3, vo.getTime());
			stmt.setInt(4, vo.getPriority());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt,  conn);
		}
	}
	
	@Override
	public void updateRecipe(RecipeVO vo) {
		System.out.println("update 기능처리");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(recipe_update);
			stmt.setString(1, vo.getAction());
			stmt.setInt(2, vo.getTime());
			stmt.setInt(3, vo.getPriority());
			stmt.setString(4, vo.getNum());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt,  conn);
		}
	}
	
	@Override
	public void deleteRecipe(RecipeVO vo) {
		System.out.println("delete 기능처리");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(recipe_delete);
			stmt.setString(1, vo.getNum());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt,  conn);
		}
	}
	
	@Override
	public RecipeVO getRecipe(RecipeVO vo) {
		System.out.println("getRecipe 기능처리");
		RecipeVO recipe = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt=conn.prepareStatement(recipe_get);
			stmt.setString(1, vo.getNum());
			rs = stmt.executeQuery();
			if(rs.next()){
				recipe = new RecipeVO();
				recipe.setNum(rs.getString("num"));
				recipe.setAction(rs.getString("action"));
				recipe.setTime(rs.getInt("time"));
				recipe.setPriority(rs.getInt("priority"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, stmt, conn);
		}
		return recipe;
	}
	
	@Override
	public List<RecipeVO> getRecipeList(RecipeVO vo){
		System.out.println("getRecipe get 기능처리");
		List<RecipeVO> recipeList = new ArrayList<RecipeVO>();
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(recipe_list);
			rs = stmt.executeQuery();
			while(rs.next()){
				RecipeVO recipe = new RecipeVO();
				recipe.setNum(rs.getString("num"));
				recipe.setAction(rs.getString("action"));
				recipe.setTime(rs.getInt("time"));
				recipe.setPriority(rs.getInt("priority"));
				recipeList.add(recipe);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, stmt, conn);
		}
		return recipeList;
	}
}
