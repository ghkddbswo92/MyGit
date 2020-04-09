package com.springbook.view.admin.Menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.DrinkVO;
import com.springbook.biz.impl.DrinkDAO;
import com.springbook.view.controller.Controller;

public class MenuUpdateController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("수정 기능 처리");
			
			String menu = request.getParameter("menu");
			String price = request.getParameter("price");
			String recipe = request.getParameter("recipe");
			int index = Integer.parseInt(request.getParameter("index"));
			
			DrinkDAO drinkDAO = new DrinkDAO();
			DrinkVO dvo = new DrinkVO();
			
			List<DrinkVO> drinkList = drinkDAO.getdrinkList(dvo);
			
			String before_update = drinkList.get(index).getName();
			
			dvo.setName(menu);
			dvo.setPrice(Integer.parseInt(price));
			dvo.setRecipe(recipe);
			
			drinkDAO.updatedrink(dvo,before_update);
			
			return "admin_M.do";

	}

}
