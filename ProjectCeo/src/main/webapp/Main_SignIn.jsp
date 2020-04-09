<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String check = (String) session.getAttribute("checkid");
	if(check!=null){%>
		<script>
			alert("ID 중복입니다.");
		</script>
	<%
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<style>
	h1 {text-align: center;}
	form {text-align: center;}
	input { width: 500px; height: 40px; margin: 10px; }
	#go {background: Green; color: white;}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="signIn.do">
		아이디 <br>
		<input type="text" placeholder="아이디를 입력하세요" name="id"/><br>
		비밀번호<br>
		<input type="password"  placeholder="비밀번호를 입력하세요" name="password"><br>
		이름(성명)<br>
		<input type="text" placeholder="이름을 입력하세요" name="name"><br>
		<hr>
		<input type="submit" value="가입하기" id="go">
	</form>
	<br>
	<form action="Main_Page.jsp" method="post">
		<input type="submit" value="돌아가기" id="go">
	</form>
</body>
</html>