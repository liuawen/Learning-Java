<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>转发与重定向获取数据</title>
</head>
<body>
	<!-- 取出Demo4Servlet中传递过来的数据 -->
	<%-- <%
		String username = (String)request.getAttribute("username");
		out.print(username);
	%> --%>
	<%
		String goods = (String)application.getAttribute("goods");
		out.print(goods);
	%>
</body>
</html>