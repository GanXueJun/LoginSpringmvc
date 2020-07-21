<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script>
	function register() {
		location.href = "${pageContext.request.contextPath}/views/register.jsp"
	}
</script>
</head>
<body align="center">

<form action="${pageContext.request.contextPath}/loginOpe" method="post">
<table>

	<%-- <p>${msgError}</p> --%>
		<tr>
			<td colspan="3"><h3>用户登录</h3></td>
		</tr>
		<tr>
			<td>账户：</td>
			<td><input type="text" id="username" name="username" /></td>
			<td><span id="userInfo"></span></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" id="password" name="password" /></td>
			<td><span id="pwdInfo"></span></td>
		</tr>
		<tr>
			<td colspan="3">
			<input type="submit" value="登录" /> 
			<input type="reset" value="重置" /> 
			<input type="button" onclick="register()" value="注册" /></td>
		</tr>
		</table>
	</form>
</body>
</html>