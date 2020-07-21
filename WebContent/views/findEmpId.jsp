<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改员信息</title>
<script type="text/javascript">
	function mySubmit() {
		if (document.forms[0].empName.value.length == 0) {
			alert("员工名不能为空");
			return;
		} else if (document.forms[0].age.value.length == 0) {
			alert("年龄不能为空");
			return;
		} else if (document.forms[0].sex.value.length == 0) {
			alert("性别不能为空");
			return;
		} else if (document.forms[0].simple.value.length == 0) {
			alert("描叙不能为空");
			return;
		} else if (document.forms[0].face.value.length == 0) {
			alert("图片不能为空");
			return;
		} else if (document.forms[0].depId.value.length == 0) {
			alert("部门不能为空");
			return;
		}
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/updateEmp" method="post">
		<table>
			<tr>
				<td colspan="2"><h3>修改员信息</h3></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="id" value="${id }"></td>
			</tr>
			<tr>
				<td>员工名：</td>
				<td><input type="text" name="empName" value="${empName }" /></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" value="${age }" /></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="text" name="sex" value="${sex }" /></td>
			</tr>
			<tr>
				<td>描叙：</td>
				<td><input type="text" name="simple" value="${simple }" /></td>
			</tr>
			<tr>
				<td>图像：</td>
				<td><input type="text" name="face" value="${face }"/></td>
				<%-- <td>
					<img src="${pageContext.request.contextPath }/upload/${face}" width=50 height=50>
				</td>
				<td><input type="file" name="faceImg" value="${pageContext.request.contextPath }/upload/${face}"/></td> --%>
			</tr>
			<tr>
				<td>部门编号：</td>
				<td><input type="text" name="depId" value="${depId }" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="提交修改"
					onclick="mySubmit()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
