<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.springbook.biz.OrdertbVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<OrdertbVO> orderlist = (List)session.getAttribute("orderlist");
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String orderid = (String) session.getAttribute("id");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orders</title>
<style>
body { margin: 0 auto; overflow-x: hidden;}
h1 { text-align: center; }
div { margin-top: 30px; margin-left: 80px; margin-right: 80px; width: 800px;  }
table { position: absolute; left: 0; width: 100%; align: center;  text-align: center; font-size: 20px; }
#ths {  width: 400px; height: 70px; align: center; text-align: center; 	}
#thss {  width: 400px; height: 70px; align: center; text-align: center;	}
#tds { width: 400px; height: 70px;  }


</style>
</head>
<body>
	<h1 style="text-align: center;">주문완료</h1>
	<div>
		<table>
			<tr>
				<th id="ths">주문 음료</th>
				<th id="thss">픽업 가능 시간</th>
			</tr>
			<%	if(orderlist!=null){
					for(int i=0; i<orderlist.size(); i++) { 
						if(orderlist.get(i).getOrderid() == orderid){
				%>
			<tr>
				<td id="tds"><%= orderlist.get(i).getOrderlist() %></td>
				
				<td id="tds"><%=sdf.format(orderlist.get(i).getComplete()) %></td>
			</tr>
			<% 			
					}
				}
				}
			%>
		</table>
	</div>
</body>
</html>