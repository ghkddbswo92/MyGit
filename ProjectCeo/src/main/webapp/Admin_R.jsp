<%@page import="com.springbook.biz.RecipeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<RecipeVO> recipeList = (List) session.getAttribute("recipelist");
%>    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1 {text-align: center; margin:50px auto; height:300px; line-height:200px;}
	h1::after {  content:"";
				 position: absolute;
				 top: 0;
				 left: 0;
				 width: 100%;
				 height: 380px;
			  	 background: url(images/A4.jpg) center center/cover; 
			  	 opacity:.5; 
			  }
	#header {position: fixed; top:50px; right: 50px; }
	table { cellpadding:0; cellspacing:0; width:1000px;}
	#out {  float: left; margin-right: 10px;}
	#return { float: left; }
	th { width:100px; }
	#typeth {  width:20px; }
	input[type="radio"] {margin:0 auto;}
	#wrap {clear:both;}
</style>
<meta charset="UTF-8">
<title>레시피 수정 페이지</title>
</head>
<body>
	<h1>레시피</h1>
	<header id="header">
		<div id="out">
			<input type="button" value="로그아웃" onclick="location.href='logout.do'">
		</div>
		<div id="return">
			<input type="submit" value="돌아가기" onclick="location.href='admin.do'">
		</div>
	</header>
	<hr>
	<form action="delete_R.do" method="post">
	<table border="1">
		<tr style="text-align: center;">
			<th id="typeth"></th>
			<th >순서</th>
			<th >행동 순서</th>
			<th >시간</th>
			<th >우선순위 </th>
		</tr>
		<% for(int i=0; i<recipeList.size(); i++){ %>
		<tr style="text-align: center;" >
			<td><input type="radio" name="recipe_check" value="<%=i%>" onclick="check(this.value);"></td>
			<td><%=recipeList.get(i).getNum() %></td>
			<td><%=recipeList.get(i).getAction() %> </td>
			<td><%=recipeList.get(i).getTime() %> </td>
			<td><%=recipeList.get(i).getPriority() %> </td>
		</tr>	
		<% } %>
	</table>
	<br>
	<input type="hidden" name="number" id="deleteNum">
	<input type="submit" value="삭제" style="width: 1000px">
	</form>
	<br>
	<table>
	<center>
		<tr>
			<td >
				<form action="insert_R.do" method="post" id="insertForm">
					<p>순서: <input placeholder="영문으로 입력" name="num" id="insertNum"> </p>
					<p>행동: <input placeholder="작업이름 입력" name="action" id="insertAction"> </p>
					<p>시간: <input placeholder="숫자만 입력가능" name="time" id="insertTime"> </p>
					<p>우선: <input placeholder="우선순위입력" name="priority" id="insertPriority"> </p>
					<input type="button" value="추가" style="width: 200px" onclick="subCheck(event,this.value);">
				</form>
			</td>
			<td>	
				<form action="update_R.do" method="post" id="updateForm">
					<input type="hidden"  class="hidden" name="index" id="index">
					<input type="hidden"  name="num" id="updateNum">
					<p>헹동: <input placeholder="작업이름 입력" name="action" id="updateAction"> </p>	
					<p>시간: <input placeholder="숫자만 입력가능" name="time" id="updateTime"> </p>
					<p>우선: <input placeholder="우선순위 입력" name="priority" id="updatePriority"> </p>
					<input type="button" value="수정" style="width: 200px" onclick="subCheck(event,this.value);">
				</form>
			</td>
			
		</tr>
	</center>		
	</table>
	<script>
		function check(value){
			<%for(int i=0; i<recipeList.size(); i++){%>
				if(value==<%=i%>){
					var action =  document.getElementById('updateAction');
					var time = document.getElementById('updateTime');
					var priority = document.getElementById('updatePriority');
					var num = document.getElementById('updateNum');
					var number = document.getElementById('deleteNum');
					var index = document.getElementById('index');
					
					index.setAttribute('value','<%=i%>');
					action.setAttribute('value','<%=recipeList.get(i).getAction()%>');
					time.setAttribute('value','<%=recipeList.get(i).getTime()%>');
					priority.setAttribute('value','<%=recipeList.get(i).getPriority()%>');
					num.setAttribute('value', '<%=recipeList.get(i).getNum()%>');
					number.setAttribute('value', '<%=recipeList.get(i).getNum()%>');
				}
			<%}%>
		}
		
		function subCheck(e, v){
			var act;
			if(v=="추가")
				act = "insert";
			else if(v=="수정")
				act = "update";
			var num = document.getElementById(act+"Num");
			var action = document.getElementById(act+"Action");
			var time = document.getElementById(act+"Time");
			var priority = document.getElementById(act+"Priority");
			
			if(action.value=="" || time.value=="" || priority.value==""){
				alert("모든 항목 기입 바랍니다.");
				e.preventDefault();
			}else{
				if(confirm(v+"하시겠습니까?")){
					var form = document.getElementById(act+"Form");
					console.log(form);
					form.submit();
				}
			}
		}
	</script>
</body>
</html>
