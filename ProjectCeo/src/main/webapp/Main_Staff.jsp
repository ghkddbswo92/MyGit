<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.springbook.biz.OrdertbVO"%>
<%@page import="java.util.List"%>
<%
	List<OrdertbVO> orderList = (List) session.getAttribute("orderList");
	int cnt=1;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff</title>
<style>
	body{overflow-y:scroll;}
	h1 {text-align: center; margin:50px auto; height:300px; line-height:200px;}
	h1::after {  content:"";
				 position: absolute;
				 top: 0;
				 left: 0;
				 width: 100%;
				 height: 380px;
			  	 background: url(images/bg_S.jpg) center bottom/cover; 
			  	 opacity:.5; }
	#out { text-align : right; width: 100%;}
	#dright {float: right;  width: 45%; height:100%; border: 1px solid #000; margin-right: 30px;}
	#dleft {float: left; width: 45%; height:100%; margin-left: 30px; border: 1px solid #000;}
	#dleft div {border: 1px solid #000; margin: 10px auto; height:50px; text-align:center; line-height:50px;}
	a { text-decoration:none; color:#000; }
	a:visited { color:#000; }
	a:hover { color:red;}
</style>

</head>
<body>
<h1>직원용 웹페이지</h1>
	<div id="out">
		<form action="logout.do" method="post">
			<p> <input type="submit" value="로그아웃"> </p>
		</form>
	</div>
<div id="wrap">
	<div id="dleft">
		
		<% if(orderList.size() != 0){
		for(int i=0; i<orderList.size(); i++){ %>
		<a href="staff
			<%=i%>.do">
		<div class="dleft_f">
			 <%= orderList.get(i).getOrderlist() %>
		</div>
		</a>
		<% } } %>
	</div>
	<div id="dright">
		<%
		if(orderList.size()!=0){
			List<String> orderAction = (List) session.getAttribute("OrderAction");%>
		<% for(int i=0; i<orderAction.size(); i++){ %>
		<p> <%=cnt%>. <%=orderAction.get(i) %></p>
		<% cnt++;} %>
		<%}%>
	</div>
</div>		
</body>
</html>