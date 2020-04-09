package com.springbook.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class SignInController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("회원 가입 처리");
		
		String userid = request.getParameter("id");
		String password = request.getParameter("password");
		String username = request.getParameter("name");
		UserDAO userDAO = new UserDAO();
		boolean checkId = false;
		List<UserVO> userList = userDAO.check_User();
		HttpSession session = request.getSession();
		for(int i=0; i<userList.size(); i++) {
			if(userid.equals(userList.get(i).getId())) {
				checkId = true;
				session.setAttribute("checkid", "true");
				break;
				
			}
		}
		if(checkId==false) {
			UserVO uvo = new UserVO();
			uvo.setId(userid);
			uvo.setPassword(password);
			uvo.setName(username);
			userDAO.insertUser(uvo);
			session.setAttribute("completeSign", "true");
		}else {
			return "Main_SignIn";
		}

		return "Main_Page";
	}

}
