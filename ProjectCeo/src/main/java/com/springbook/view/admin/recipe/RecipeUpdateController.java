package com.springbook.view.admin.recipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.RecipeVO;
import com.springbook.biz.impl.RecipeDAO;
import com.springbook.view.controller.Controller;

public class RecipeUpdateController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			RecipeVO rvo = new RecipeVO();
			RecipeDAO recipeDAO = new RecipeDAO();
			
			String num = request.getParameter("num");
			String time = request.getParameter("time");
			String action = request.getParameter("action");
			String priority = request.getParameter("priority");
			String check = request.getParameter("index");
			
			rvo.setAction(action);
			rvo.setTime(Integer.parseInt(time));
			rvo.setPriority(Integer.parseInt(priority));
			
			for(int i=0; i<check.length(); i++) {
				if(check.contains(check)) {
					rvo.setNum(num);
				}
			}
			recipeDAO.updateRecipe(rvo);

			return "admin_R.do";
	}
}
