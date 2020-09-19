<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/testPOJO" method="post">
		<!-- 表单项中的name属性值要与POJO类中的属性名保持一致 -->
		工号：<input type="text" name="id"><br>
		姓名：<input type="text" name="lastName"><br>
		邮箱：<input type="text" name="email"><br>
		部门编号：<input type="text" name="dept.id"><br>
		部门名称：<input type="text" name="dept.name"><br>
		<input type="submit">
	</form>
</body>
</html>