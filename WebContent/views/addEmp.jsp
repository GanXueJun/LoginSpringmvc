<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加员信息</title>
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
	<form action="${pageContext.request.contextPath }/addEmpInfo" method="post">
		<table>
			<tr>
				<td colspan="2"><h3>添加员信息</h3></td>
			</tr>
			<tr>
				<td>员工名：</td>
				<td><input type="text" name="empName" /></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>描叙：</td>
				<td><input type="text" name="simple" /></td>
			</tr>
			<tr>
				<td>图像：</td>
				<td><input type="text" name="face" /></td>
			</tr>
			<tr>
				<td>部门编号：</td>
				<td><input type="text" name="depId" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="添加" onclick="mySubmit()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
