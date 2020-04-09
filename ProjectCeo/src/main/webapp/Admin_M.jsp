<%@page import="com.springbook.biz.DrinkVO"%>
<%@page import="com.springbook.biz.RecipeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<DrinkVO> drinkList = (List) session.getAttribute("drinkList");
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
<title>메뉴 수정 페이지</title>
</head>
<body>
	<h1>메뉴</h1>
	<header id="header">
		<div id="out">
			<input type="button" value="로그아웃" onclick="location.href='logout.do'">
		</div>
		<div id="return">
			<input type="submit" value="돌아가기" onclick="location.href='admin.do'">
		</div>
	</header>
	<hr>
	<form action="delete_M.do" method="post">
	<table border="1">
		<tr style="text-align: center;">
			<th id="typeth"></th>
			<th>메뉴</th>
			<th>가격</th>
			<th>레시피</th>
		</tr>
		<%for(int i=0; i<drinkList.size(); i++){ %>
		<tr style="text-align: center;">
			<td><input type="radio" name="drinkCheck" value="<%=i%>" onclick="check(this.value)"></td>
			<td><%=drinkList.get(i).getName() %></td>
			<td><%=drinkList.get(i).getPrice() %></td>
			<td><%=drinkList.get(i).getRecipe() %></td>
		</tr>
		<%} %>
	</table>
	<br>

	<input type="hidden" name="number" class="deleteNum">
	<input type="submit" value="삭제" style="width: 1000px">
	</form>
	<br>
	<table>
	<center>
		<tr>
			<td>
				<form action="insert_M.do" method="post" id="insertForm">
					<p>메뉴: <input placeholder="메뉴를 입력하세요" name="menu" id="insertMenu"> </p>
					<p>가격: <input placeholder="숫자만 입력가능" name="price" id="insertPrice"> </p>
					<p>순서: <input placeholder="레시피창을 참고하여 입력" name="recipe" id="insertRecipe"> </p>
					<input type="button" value="추가" style="width: 200px" onclick="subCheck(event,this.value);">
				</form>
			</td>
			<td id="update">	
				<form action="update_M.do" method="post" id="updateForm">
					<input type="hidden" value="" class="hidden" name="index" id="index">
					<p>메뉴: <input placeholder="메뉴를 입력하세요" name="menu" id="updateMenu"></p>
					<p>가격: <input placeholder="숫자만 입력가능" name="price" id="updatePrice"> </p>	
					<p>순서: <input placeholder="레시피창을 참고하여 입력" name="recipe" id="updateRecipe"> </p>
					<input type="button" value="수정" style="width: 200px" onclick="subCheck(event,this.value);">
				</form>
			</td>
			<td>
				<input type="button" value="레시피 창 띄우기" style="width: 200px; height: 50px", onclick="show();">  
			</td>
		</tr>
	</center>		
	</table>
		<br>
	<script>
		function check(value){
			<%for(int i=0; i<drinkList.size(); i++){%>
				if(value==<%=i%>){
					var menu = document.getElementById('updateMenu');
					var price = document.getElementById('updatePrice');
					var recipe = document.getElementById('updateRecipe');
					var index = document.getElementById('index');
					
					index.setAttribute('value','<%=i%>');
					menu.setAttribute('value','<%=drinkList.get(i).getName()%>');
					price.setAttribute('value','<%=drinkList.get(i).getPrice()%>');
					recipe.setAttribute('value','<%=drinkList.get(i).getRecipe()%>');
				}
			<%}%>
		}
		function show(){
			var recipeTB = document.getElementById('recipeTB');
			window.open("adminView.do","a" ,"width=510, height=360, left=100, top=50");
		}
		function subCheck(e, v){
			var act;
			if(v=="추가")
				act = "insert"
			else if(v=="수정")
				act = "update"
			var menu = document.getElementById(act+"Menu");
			var price = document.getElementById(act+"Price");
			var recipe = document.getElementById(act+"Recipe");
			if(menu.value=="" || price.value=="" || recipe.value==""){
				alert("모든 항목 기입 바랍니다.");
				e.preventDefault();
			}else{
				if(confirm(v+"하시겠습니까?")){
					var form = document.getElementById(act+"Form");
					form.submit();
				}
			}
		}
	</script>
</body>
</html>

