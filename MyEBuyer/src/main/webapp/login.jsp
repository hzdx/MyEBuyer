<%@page language="java" contentType="text/html;chaset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="/css/login.css" type="text/css" />
		<title>欢迎光临网上商城</title>
		<script type="text/javascript">
			function hyz(){
				var img = document.getElementById("imgVerifyCode");
				img.src="/verifycode?a="+ new Date().getTime();
			}
		</script> 
	</head>

	<body id="container">
	    <div>
	    	<form action="/user/login" method="post">
		        <div id="img"><img src="/img/uat.png" alt="" /></div>
		          <div id="tx">
		          <div id="input">
		              用户: <input type="text" id="us" name="username"/><br/>
		              密码: <input type="password" id="psw" name="password"/><br/>
		              验证码：<input type="text" name="verifycode"/><br/>
		              <img src="/verifycode" id="imgVerifyCode"/>
		              <a href="javascript:hyz()">换一张</a>
		          </div>
		           <div>
		               <input type="submit" value="登陆" style="width:80px; height:25px; background-color:#666;"/>		                
		            </div>
		            	
		            </div>
	        </form>
	         
	     </div>
	    
	     <div style=" position:absolute;right:270px; bottom:250px;">
	     	&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: red;font-size: 18px">${msg}</font><br/>
	     	<a href="/user/register">用户注册</a>
	        <a href="#" style="margin-left:90px;">关于我们</a>
	     </div>
	</body>
</html>