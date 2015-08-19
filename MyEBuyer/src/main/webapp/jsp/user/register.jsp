<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
	<script src="../js/laydate/laydate.js" type="text/javascript" language="javascript"></script>
	<script src="../js/jquery-1.7.1.min.js" type="text/javascript" language="javascript"></script>
	<script type="text/javascript">
    $(function(){
    	$("#nameText").blur(function(){
    		var username = $(this).val();
    		$.post("checkName",{'name':username},function(data){
				// 返回data 就是 html 片段, 直接显示
				$("#checkName").html(data);
			});
    	});
    });
    </script>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/user/reg" method="post" >
			<table style="margin-left:100px;margin-top:50px">
				<tr>
					<td>用户名</td>
					<td><input id="nameText" type="text" name="name" value="${form.name }"/></td>
					<td>${errors.name }${userExist }<span id="checkName"></span></td>
				</tr>
				
				<tr>
					<td>密码</td>
					<td><input type="password" name="password" value="${form.password }"/></td>
					<td>${errors.password }</td>
				</tr>
				
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="repsw" value="${form.repsw }"/></td>
					<td>${errors.password2 }</td>
				</tr>
				
				<tr>
					<td>生日</td>
					<td><input type="text" name="birthday" readonly onclick="laydate()" value=""/></td>
					<td></td>
				</tr>
				
				<!-- <tr>
					<td>上传用户头像</td>
					<td><input type="file" name="pictureFile" /></td>
				</tr> -->
				
				<tr>
					<td><input type="submit" value="注册"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
				
			</table>
			
			
		</form>
	</body>
</html>