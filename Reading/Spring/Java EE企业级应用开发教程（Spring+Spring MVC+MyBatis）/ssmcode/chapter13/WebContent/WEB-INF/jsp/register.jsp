<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/registerUser" 
                                                                    method="post">
		用户名：<input type="text" name="username" /><br />
		密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" /><br />
		<input type="submit" value="注册"/>
	</form>
</body>
</html>
