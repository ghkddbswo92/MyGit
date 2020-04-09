package com.springbook.view.guest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.OrdertbVO;
import com.springbook.biz.ServiceClient;
import com.springbook.biz.impl.OrdertbDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class GuestRSController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("고객님으로 주문 처리");
		String redirectURL = "";
		HttpSession session = request.getSession();
		
		
		String orderid = (String) session.getAttribute("id");
		String orderpassword = (String) session.getAttribute("password");
		int point = (Integer) session.getAttribute("point");
		
		UserVO uvo = new UserVO();
		uvo.setId(orderid);
		uvo.setPassword(orderpassword);
		
		UserDAO userDAO = new UserDAO();
		int price = Integer.parseInt((String)request.getParameter("price"));
		
		if(price>point) {
			redirectURL = "guest.do";
		}else {
			session.setAttribute("point", point-price);
			userDAO.point_update(uvo, price);
		
			OrdertbVO ovo = new OrdertbVO();
			OrdertbDAO ordertbDAO = new OrdertbDAO();

			String[] count = request.getParameterValues("sum");
		
			int[] order = new int[count.length];
			
			for(int i=0; i<count.length; i++) {
				order[i] = Integer.parseInt(count[i]);
			}
		
			ServiceClient sc = new ServiceClient();
			int time = sc.OrderTime(order);
			sc.insertOrderlist(order, time, orderid);
		
			List<OrdertbVO> orderlist = ordertbDAO.getOrdertbList(ovo);
			
			session.setAttribute("orderid", orderid);
			session.setAttribute("orderlist", orderlist);	
			redirectURL = "guest.do";
			
		}
		return redirectURL;
	}

	
}
