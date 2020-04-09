package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String userid = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO uvo = new UserVO();
		UserDAO userDAO = new UserDAO();
		
		uvo.setId(userid);
		uvo.setPassword(password);
		
		UserVO user = userDAO.getUser(uvo);
		
		if(user != null){
			if(user.getPoint() == -2){
				return "admin.do";
				
			}else if(user.getPoint() == -1){
				return "staff0.do";
				
			}else if(user.getPoint()>=0){
				String name = user.getName();
				int point = user.getPoint();
				String id = user.getId();
				
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("point", point);
				
				return "guest.do";
			}
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("check", "false");
			
		}
		return "Main_Page";
	}
}
