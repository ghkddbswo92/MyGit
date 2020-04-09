package com.springbook.view.guest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.OrdertbVO;
import com.springbook.biz.impl.OrdertbDAO;
import com.springbook.biz.user.GuestVO;
import com.springbook.biz.user.impl.GuestDAO;
import com.springbook.view.controller.Controller;

public class GuestController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("손님용  처리");
			
			GuestVO gvo = new GuestVO();
			GuestDAO guestDAO = new GuestDAO();
			List<GuestVO> guestList = guestDAO.getMenuList(gvo);
			OrdertbVO ovo = new OrdertbVO();
			OrdertbDAO ordertbDAO = new OrdertbDAO();
			List<OrdertbVO> orderlist = ordertbDAO.getOrdertbList(ovo);
			HttpSession session = request.getSession();
			session.setAttribute("guestList", guestList);
			session.setAttribute("orderlist", orderlist);
			return "Main_Guest";
	}
}
