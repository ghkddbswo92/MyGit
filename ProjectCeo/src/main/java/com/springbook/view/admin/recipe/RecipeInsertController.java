package com.springbook.view.admin.recipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.RecipeVO;
import com.springbook.biz.impl.RecipeDAO;
import com.springbook.view.controller.Controller;

public class RecipeInsertController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("레시피 추가");
			
			RecipeVO rvo = new RecipeVO();
			RecipeDAO recipeDAO = new RecipeDAO();
			
			String num = request.getParameter("num");
			String action = request.getParameter("action");
			String time = request.getParameter("time");
			String priority = request.getParameter("priority");
			
			rvo.setNum(num);
			rvo.setAction(action);
			rvo.setTime(Integer.parseInt(time));
			rvo.setPriority(Integer.parseInt(priority));
			
			recipeDAO.insertRecipe(rvo);
			return "admin_R.do";
			
		
	}

}
