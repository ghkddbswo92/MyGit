<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.springbook.biz.OrdertbVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<OrdertbVO> orderlist = (List)session.getAttribute("orderlist");
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String orderid = (String) session.getAttribute("orderid");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orders</title>
<style>
#function { width: 100px; margin-left: 1530px; }
div {float: left; margin-top: 30px; margin-left: 100px; margin-right: 100px; width: 1500px; border: 1px solid #868686; }
table { align: center;  text-align: center; font-size: 20px;}
#ths { width: 1000px; height: 70px; align: center; text-align: center; 	}
#thss { width: 300px; height: 70px; align: center; text-align: center;	}
#tds { height: 70px;  }


</style>
</head>
<body>
	<h1 style="text-align: center;">주문완료</h1>
	<header style="text-align: right;">
		<table id="function">
			<tr>
				<td>
					<form action="logout.do" method="post" >
						<input type="submit" value="로그아웃">
					</form>
				</td>
				<td>
				<form action="guest.do" method="post" >
					<input type="submit" value="돌아가기">
				</form>
				</td>
			</tr>	
		</table>
	</header>
	<div>
		<table>
			<tr>
				<th id="ths">주문 음료</th>
				<th id="thss">픽업 가능 시간</th>
			</tr>
			<tr>
				<% for(int i=0; i<orderlist.size(); i++) { 
					if(orderlist.get(i).getOrderid() == orderid){
				%>
				<td id="tds"><%= orderlist.get(i).getOrderlist() %></td>
				
				<td id="tds"><%=sdf.format(orderlist.get(i).getComplete()) %></td>
			</tr>
		<% } } %>
		</table>
	</div>
</body>
</html>