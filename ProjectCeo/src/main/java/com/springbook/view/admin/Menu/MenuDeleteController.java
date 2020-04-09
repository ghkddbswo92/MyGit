package com.springbook.view.admin.Menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.DrinkVO;
import com.springbook.biz.impl.DrinkDAO;
import com.springbook.view.controller.Controller;

public class MenuDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("삭제 기능 처리");
			
			int index = Integer.parseInt(request.getParameter("drinkCheck"));
			
			DrinkDAO drinkDAO = new DrinkDAO();
			DrinkVO dvo = new DrinkVO();
			
			List<DrinkVO> drinkList = drinkDAO.getdrinkList(dvo);
			
			dvo.setName(drinkList.get(index).getName());
			
			drinkDAO.deletedrink(dvo);
			
			HttpSession session = request.getSession();
			drinkList = drinkDAO.getdrinkList(dvo);
			session.setAttribute("drinkList", drinkList);
			
			return "admin_M.do";
	}

}
