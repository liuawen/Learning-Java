<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int i = 10; %>
<%
	if(i > 10){
		out.println("i > 10");
	}else{
		out.println(" i <= 10");
	}
%>
<hr>
<%if(i > 10){ %>
<span>i > 10</span>
<%}else{ %>
<span>i <= 10</span>
<%} %>
</body>
</html>