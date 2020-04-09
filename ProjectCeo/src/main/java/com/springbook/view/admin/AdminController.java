package com.springbook.view.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.view.controller.Controller;

public class AdminController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("관리자용 처리");
			
			return "Main_Admin";

	}

}
