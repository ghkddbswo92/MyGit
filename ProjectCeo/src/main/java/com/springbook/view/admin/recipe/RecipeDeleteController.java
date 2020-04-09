package com.springbook.view.admin.recipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.RecipeVO;
import com.springbook.biz.impl.RecipeDAO;
import com.springbook.view.controller.Controller;

public class RecipeDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("삭제 기능 처리");
			
			RecipeVO rvo = new RecipeVO();
			RecipeDAO recipeDAO = new RecipeDAO();
			
			String check = request.getParameter("recipe_check");
			String num = request.getParameter("number");
			
			for(int i=0; i<check.length(); i++) {
				if(check.contains(check)) {
					rvo.setNum(num);
				}
			}
			
			recipeDAO.deleteRecipe(rvo);
			
			return "admin_R.do";

	}

}
