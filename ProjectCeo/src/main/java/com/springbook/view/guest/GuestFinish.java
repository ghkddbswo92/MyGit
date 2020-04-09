package com.springbook.view.guest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.OrdertbVO;
import com.springbook.biz.impl.OrdertbDAO;
import com.springbook.view.controller.Controller;

public class GuestFinish implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("고객님으로 주문 처리");
		OrdertbVO ovo = new OrdertbVO();
		HttpSession session = request.getSession();
		OrdertbDAO OrdertbDAO = new OrdertbDAO();
		List<OrdertbVO> orderlist = OrdertbDAO.getOrdertbList(ovo);
		String userid = request.getParameter("id");
		session.setAttribute("orderlist",orderlist);
		session.setAttribute("orderid", userid);
		return "Guest_finish";
	}

	
}
