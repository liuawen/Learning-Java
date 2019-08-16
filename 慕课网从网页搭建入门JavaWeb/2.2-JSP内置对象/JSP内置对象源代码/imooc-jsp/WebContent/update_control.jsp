<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"
    pageEncoding="UTF-8" import="com.imooc.db.*,com.imooc.bean.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String,Emp> map = DBUtil.map;
		Emp emp = map.get(request.getParameter("account"));
		emp.setName(request.getParameter("name"));
		emp.setEmail(request.getParameter("email"));
	%>
	<h3 align="center">修改员工信息成功。</h3>
</body>
</html>