<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String check = (String)session.getAttribute("check");
    	String completeSign = (String) session.getAttribute("completeSign");
    	session.setAttribute("checkid",null);
    	if(check!=null){%>
    	<script>
    		alert("아이디나 비밀번호가 틀렸습니다. 다시입력해주세요!");
    	</script>	
    <%
    	}
    %>
    <%  if(completeSign!=null){%>
    	<script>
    		alert("회원가입 되었습니다.");
    	</script>
    <%	
    	session.setAttribute("completeSign",null);
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
	body { margin:0; padding:0; height:100%;}
	h1 {text-align: center; margin-top:200px;}
	form {text-align: center;}
	input { width: 500px; height: 40px; margin: 10px; }
	#go {background: Green; color: white;}
	#bg{
			position:fixed;
			top:0;
			left:0;
			min-width:100%;
			min-height:100%;
			width:auto;
			height:auto;
			z-index:-100;
		}
	#wrap { width:600px; background:#fff; margin:0 auto; border-radius:30px; padding:0 10px; }
</style>
</head>
<body>
	<image src="images/bg_mainPage.jpg" id="bg">
	<div id="wrap">
	<h1>로그인</h1>
	<form method="post" action="login.do">
		<input type="text" placeholder="아이디를 입력하세요" name="id"/><br>
		<input type="password"  placeholder="비밀번호를 입력하세요" name="password"><br>
		<input type="submit" value="로그인" id="go">
	</form>	
	<form action="Main_SignIn.jsp">
		<input type="submit" value="회원 가입 하기" id="go">
	</form>
	</div>
</body>
</html>