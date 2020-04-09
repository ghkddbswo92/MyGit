package com.springbook.view.admin.Menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.RecipeVO;
import com.springbook.biz.impl.RecipeDAO;
import com.springbook.view.controller.Controller;

public class MenuRecipeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("레시피 테이블 가져오기");
			
			RecipeVO rvo = new RecipeVO();
			RecipeDAO recipeDAO = new RecipeDAO();
			
			List<RecipeVO> recipeList = recipeDAO.getRecipeList(rvo);
			
			HttpSession session = request.getSession();
			session.setAttribute("recipelist", recipeList);
			
			return "RecipeView";
			

	}

}
