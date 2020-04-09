package com.springbook.view.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.springbook.biz.DrinkVO;
import com.springbook.biz.OrdertbVO;
import com.springbook.biz.RecipeVO;
import com.springbook.biz.ServiceClient;
import com.springbook.biz.impl.DrinkDAO;
import com.springbook.biz.impl.OrdertbDAO;
import com.springbook.biz.impl.RecipeDAO;
import com.springbook.biz.user.GuestVO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.GuestDAO;
import com.springbook.biz.user.impl.UserDAO;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private viewResolver viewResolver;
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new viewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		
		if(path.contains("/staff") && path.contains(".do")) {
			System.out.println("직원용  처리");
		
			OrdertbVO ovo = new OrdertbVO(); 
			OrdertbDAO ordertbDAO = new OrdertbDAO();
			ServiceClient sc = new ServiceClient();
		  
			List<OrdertbVO> orderListAll = ordertbDAO.getOrdertbList(ovo);
		  
			HttpSession session = request.getSession();
		  
			session.setAttribute("orderList",orderListAll);
		  
			int orderNum = path.charAt(6)-48;
		  
			if(orderListAll.size()>orderNum && orderListAll.size()!=0) { 
				List<String>firstOrderAction = sc.printActionStep(orderListAll.get(orderNum).getOrderlist());
				session.setAttribute("OrderAction", firstOrderAction);
			}
		 
			response.sendRedirect("Main_Staff.jsp"); 
		}
		else {
			Controller ctrl = handlerMapping.getController(path);
			String viewName = ctrl.handleRequest(request, response);
		
			String view = null;
			if(!viewName.contains(".do")) {
				view =viewResolver.getView(viewName);
			}else {
				view = viewName;
			}
		
			response.sendRedirect(view);
		}
	}

}
