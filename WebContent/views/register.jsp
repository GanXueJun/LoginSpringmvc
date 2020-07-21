<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<script type="text/javascript">

function check(){
	if(document.forms[0].username.value.length==0){
		alert("用户不能为空");
		return ;
	}else if(document.forms[0].password.value.length==0){
		alert("密码不能为空");
		return ;
	}
	//提交表单
	document.forms[0].submit();
}

function onback(){
	location.href="${pageContext.request.contextPath}/login"
}

</script>
</head>
<body align="center">
<form action="${pageContext.request.contextPath }/register" method="post">
<table>
	<tr>
		<td colspan="2"><h3>用户登录</h3></td>
	</tr>
	<tr>
		<td>账户：</td>
		<td><input type="text" name="username" /></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password" name="password" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="button" value="注册" onclick="check()"/>&nbsp;&nbsp;<input type="button" value="返回" onclick="onback()"/></td>
	</tr>
</table>
</form>
</body>
</html>