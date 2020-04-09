package com.springbook.view.admin.recipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.RecipeVO;
import com.springbook.biz.impl.RecipeDAO;
import com.springbook.view.controller.Controller;

public class RecipController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("관리자 레시피 수정");
		
		RecipeVO rvo = new RecipeVO();
		RecipeDAO recipeDAO = new RecipeDAO();
		List<RecipeVO> recipelist = recipeDAO.getRecipeList(rvo);
		
		HttpSession session = request.getSession();
		session.setAttribute("recipelist", recipelist);
		
		return "Admin_R";
	}

}
