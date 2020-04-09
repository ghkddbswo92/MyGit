package com.springbook.biz;

import java.util.List;

public interface RecipeService {

	void insertRecipe(RecipeVO vo);

	void updateRecipe(RecipeVO vo);

	void deleteRecipe(RecipeVO vo);

	RecipeVO getRecipe(RecipeVO vo);

	List<RecipeVO> getRecipeList(RecipeVO vo);

}