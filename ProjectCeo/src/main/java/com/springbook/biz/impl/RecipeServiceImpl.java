package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.RecipeService;
import com.springbook.biz.RecipeVO;

@Service("RecipeService")
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO recipeDAO;
	
	public void insertRecipe(RecipeVO vo) {
		recipeDAO.insertRecipe(vo);
	}

	public void updateRecipe(RecipeVO vo) {
		recipeDAO.updateRecipe(vo);
	}

	public void deleteRecipe(RecipeVO vo) {
		recipeDAO.deleteRecipe(vo);
	}

	public RecipeVO getRecipe(RecipeVO vo) {
		return recipeDAO.getRecipe(vo);
	}

	public List<RecipeVO> getRecipeList(RecipeVO vo){
		return recipeDAO.getRecipeList(vo);
	}
}
