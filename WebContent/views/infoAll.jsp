<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>

<script type="text/javascript">
function myQuery(id){
	location.href="${pageContext.request.contextPath}/findById/"+id;
}
function myUpdate(id){
	location.href="${pageContext.request.contextPath}/findById/"+id;
}
function myDelete(id){
	if(confirm("你确定要删除吗?")){
		location.href="${pageContext.request.contextPath}/deleteEmp?id="+id;
	}	
}
function myAdd(){
	location.href="${pageContext.request.contextPath}/views/addEmp.jsp"
}

</script>
</head>
<body>
    <h2 align="center">员工信息</h2>
	<%-- <h3 align="left">欢迎你！<%=request.getSession().getAttribute("username")%></h3> --%>
	<h3 align="left">尊贵的用户：${username}&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/logout">退出</a></h3>
	<input type="button" value="添加员工信息" onclick="myAdd()"/>
	
	<form action="${pageContext.request.contextPath }/findByName" method="post" align="right">
	 按名字查询：<input type="text" name="empName"><input type="submit" value="查询">
	</form>
	
	<%-- <form action="${pageContext.request.contextPath }/findByWhere" method="post" align="right">
	 按条件查询：<input type="text" name="empName" placeholder="员工名">
	性别：<select name="sex">
		 	<option value="">请选择性别</option>
		 	<option value="男">男</option>
		 	<option value="女">女</option>
	    </select>
	 <input type="submit" value="查询">
	</form> --%>
	<table width="80%" align="center">
		<tr>
			<th>ID号</th>
			<th>员工名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>描叙</th>
			<th>图像</th>
			<th>部门号</th>
		    <th>操作</th>
		</tr>
		<c:forEach items="${empList }" var="emp">
		<tr>
			<td align="center">${emp.id} </td>
			<td align="center">${emp.getEmpName() } </td>
			<td align="center">${emp.getAge() } </td>
			<td align="center">${emp.getSex() } </td>
			<td align="center">${emp.getSimple() } </td>
			<td align="center">
			${emp.getFace()}
			</td>
			<td align="center">${emp.getDepId() } </td>
			<td align="center">
				<input type="button" value="查询" onclick="myQuery(${emp.getId()})"/>
				<input type="button" value="修改" onclick="myUpdate(${emp.getId()})"/>
				<input type="button" value="删除" onclick="myDelete(${emp.getId()})"/>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>