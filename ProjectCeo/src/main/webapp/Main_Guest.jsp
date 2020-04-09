<%@page import="com.springbook.biz.OrdertbVO"%>
<%@page import="com.springbook.biz.user.GuestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<GuestVO> guestList = (List) session.getAttribute("guestList");
	String id = (String) session.getAttribute("id");
	String username = (String ) session.getAttribute("name");
	int point = (Integer) session.getAttribute("point");
	List<OrdertbVO> orderlist = (List) session.getAttribute("orderlist");
	
	int cnt=0;
	for(int i=0; i<orderlist.size(); i++){
		if( id.equals(orderlist.get(i).getOrderid())){
			cnt++;
		}
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest</title>
<style>

	h1 {text-align: center; margin:50px auto; height:300px; line-height:200px;}
	h1::after {  content:"";
				 position: absolute;
				 top: 0;
				 left: 0;
				 width: 100%;
				 height: 380px;
			  	 background: url(images/bg_G1.jpg) center center/cover; 
			  	 opacity:.5; }
	.div_sub {  display: inline-block;
    			width: 150px;
    			height: 300px;
    			text-align:center;
    			} 					
    .Info { text-align : right;
    	width: 100%;
    }
    .inputsize {
    	width : 30px;
    	height: 15px;
    	font-size: 10px;
    }
    .div_foot{
    	position:fixed;
    	right:10px; bottom:10px;
    	clear:both;
    }
    #wrap { position:relative; clear:both;}
   	.bg{
		position:absolute;
		opacity:0.7;
		z-index:-100;
	}
	.menuDiv {float:left; width:30%; margin-left:50px;}
    .hidden {position:absolute; left:-9999px;}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
</head>
<body>
	<h1>Menu</h1>
	<header class="Info">
		<p> <%=username %>님 반갑습니다. 포인트: <%=point %>점</p>
		<form action="logout.do" method="post">
		<p> <input type="submit" value="로그아웃"> </p>
		</form>
	</header>
		<div id="wrap">
		<form action="guestRS.do"  method="post" id="guestRS">
			<% for (int i=0; i<guestList.size(); i++) {%>
			<div class="menuDiv">
				<image src="images/menu<%=i%>.jpg" width="440"; height="300" class="bg">
				<div class="div_sub">
					<h3>메뉴</h3>
					<p id="menu<%=i%>"><%=guestList.get(i).getMenu() %></p>			
				</div>
				<div class="div_sub">
					<h3>가격</h3>
					 <p id="price<%=i%>"><%=guestList.get(i).getPrice() %> </p>
				</div>
			
				<div class="div_sub">
					<h3>수량</h3>
					<button type="button" id="<%=i%>add" onclick="add(this.id)">▲</button>
					<input id="<%=i%>amount" type="number" name="sum" class="inputsize"
					 	 value="0" min="0" max="10" readonly="readonly">
					<button type="button" id="<%=i%>sub" onclick="sub(this.id)">▼</button>
				</div>
			</div>
			<% } %>
			<div class="div_foot">
				<input type="number" id="total_price" value="0" name="price" 
				 style="text-align: right;" readonly="readonly" >원
				<input type="button" value="주문하기" onclick="order(event);">
				<input type="button" value="나의 주문현황" onclick="showPopup();">
			</div>
			

			<script>
				
				var priceArr = new Array();
				for(var i=0; i<<%=guestList.size()%>; i++){
					priceArr.push(Number(document.getElementById('price'+i).innerText));
				}
				
				function add(id){
					var total = document.getElementById('total_price');
					var index = parseInt(id);
					var amount = document.getElementById(index+'amount');
					
					amount.value = parseInt(amount.value)+1;
					total.value = parseInt(total.value)+priceArr[index];
				} 
				function sub(id){
					var total = document.getElementById('total_price');
					var index = parseInt(id);
					var amount = document.getElementById(index+'amount');
					if(parseInt(amount.value)>0){
						amount.value = parseInt(amount.value)-1;
						total.value = parseInt(total.value)-priceArr[index];
					}
					else{
						alert('최소값입니다!');
					}
				}
				
				function order(e){
					if(confirm("주문하시겠습니까?")){
						var price = document.getElementById('total_price');
						var guestRS = document.getElementById('guestRS');
					
						if(<%=point%><Number(price.value)){
							alert("잔액이 부족합니다");
							e.preventDefault();
						}else{
							guestRS.submit();
						}
					}else{
						alert("취소되었습니다.")
						e.preventDefault();
					}
					
				}
				function showPopup() { 
					window.open("Guest_Finish.do", "Myorders", "width=1000, height=800, left=100, top=50");
				}
				window.onload = function(){
					console.log(<%=orderlist.size()%>)
					if(<%=cnt%>>0 && <%=cnt%>!=null){
						showPopup();
					}
				}
		</script>
	</form>
	</div>


</body>
</html>

