package com.springbook.view.admin.Menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.DrinkVO;
import com.springbook.biz.impl.DrinkDAO;
import com.springbook.view.controller.Controller;

public class MenuInsertController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("추가 기능 처리");
			
			String menu = request.getParameter("menu");
			String price = request.getParameter("price");
			String recipe = request.getParameter("recipe");
						
			DrinkDAO drinkDAO = new DrinkDAO();
			DrinkVO dvo = new DrinkVO();
			
			dvo.setName(menu);
			dvo.setPrice(Integer.parseInt(price));
			dvo.setRecipe(recipe);
			
			drinkDAO.insertdrink(dvo);
			
			List<DrinkVO> drinkList = drinkDAO.getdrinkList(dvo);
			
			HttpSession session = request.getSession();
			session.setAttribute("drinkList", drinkList);
			
			return "admin_M.do";
	}

}
