<%@page import="com.springbook.biz.RecipeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<RecipeVO> recipeList = (List)session.getAttribute("recipelist");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 테이블 뷰</title>
</head>
<body>
	<table border="1" >
		<tr>
			<th>순서</th>
			<th>행동</th>
			<th>시간</th>
			<th>우선순위</th>
		</tr>
		<% for(int i=0; i<recipeList.size(); i++){ %>
		<tr style="text-align: center;">
			<td><%=recipeList.get(i).getNum() %></td>
			<td><%=recipeList.get(i).getAction() %></td>
			<td><%=recipeList.get(i).getTime() %></td>
			<td><%=recipeList.get(i).getPriority() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>