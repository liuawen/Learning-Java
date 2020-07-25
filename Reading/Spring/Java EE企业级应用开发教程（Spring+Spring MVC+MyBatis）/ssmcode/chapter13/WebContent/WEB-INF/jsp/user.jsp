<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/deleteUsers"
		   method="post">
		<table width="20%" border=1>
			<tr>
				<td>选择</td>
				<td>用户名</td>
			</tr>
			<tr>
				<td><input name="ids" value="1" type="checkbox"></td>
				<td>tom</td>
			</tr>
			<tr>
				<td><input name="ids" value="2" type="checkbox"></td>
				<td>jack</td>
			</tr>
			<tr>
				<td><input name="ids" value="3" type="checkbox"></td>
				<td>lucy</td>
			</tr>
		</table>
		<input type="submit" value="删除"/>
	</form>
</body>
</html>
