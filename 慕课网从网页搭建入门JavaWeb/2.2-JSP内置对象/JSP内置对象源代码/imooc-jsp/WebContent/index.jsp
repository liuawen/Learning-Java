<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	pageContext的作用：
	1、forward方法来完成请求的转发
	2、include方法
	3、pageContext可以来获取其他的内置对象。getRequest,getSession....
	 -->
	<%
		//pageContext.include("header.jsp");
		pageContext.forward("a.jsp?name=imooc");
	%>
</body>
</html>