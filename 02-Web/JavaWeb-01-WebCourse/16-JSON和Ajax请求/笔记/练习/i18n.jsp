<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="">中文</a>|
	<a href="">english</a>
	<center>
		<h1>注册</h1>
		<table>
		<form>
			<tr>
				<td>用户名</td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" />男<input type="radio" />女</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="reset" value="重置" />&nbsp;&nbsp;
				<input type="submit" value="提交" /></td>
			</tr>
			</form>
		</table>
		<br /> <br /> <br /> <br />
	</center>
	国际化测试：
	<br /> 1、访问页面，通过浏览器设置，请求头信息确定国际化语言。
	<br /> 2、通过左上角，手动切换语言
</body>
</html>