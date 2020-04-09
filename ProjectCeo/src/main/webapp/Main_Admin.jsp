<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminiStrator</title>
<style>
	body {margin:0; padding:0; overflow-y:hidden;}
	div { width:calc(100%/3); height:100%; float:left; font-size: 50px; text-align: center; padding:25% 0; }
	div:nth-child(1) { background: url(images/M4_1.jpg); }
	div:nth-child(2) { background: url(images/M10.jpg); }
	div:nth-child(3) { background: url(images/M12.jpg); }
	a { color:#fff; text-decoration:none;}
</style>
</head>
<body>
	<div ><a href="admin_M.do">메뉴수정</a></div>
	<div><a href="admin_R.do">레시피수정</a></div>
	<div><a href="logout.do">로그아웃</a></div>
</body>
</html>