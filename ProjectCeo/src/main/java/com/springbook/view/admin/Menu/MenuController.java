package com.springbook.view.admin.Menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.DrinkVO;
import com.springbook.biz.impl.DrinkDAO;
import com.springbook.view.controller.Controller;

public class MenuController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("메뉴 수정 ");

			DrinkVO dvo = new DrinkVO();
			DrinkDAO drinkDAO = new DrinkDAO();
			
			List<DrinkVO> drinkList = drinkDAO.getdrinkList(dvo);
			
			HttpSession session = request.getSession();
			session.setAttribute("drinkList", drinkList);
			return "Admin_M";
	}
	
}
