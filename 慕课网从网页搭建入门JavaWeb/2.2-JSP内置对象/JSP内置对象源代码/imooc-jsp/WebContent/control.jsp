<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"
    pageEncoding="UTF-8" import="com.imooc.db.*,com.imooc.bean.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	
	<!-- 获取账号以及密码，并且需要去调用DBUtil当中的方法来判断是否存在指定的信息 
		1、如果正确，DBUtil方法返回的值是true，显示成功页面
		2、如果错误，false，显示错误消息
		request：获取请求信息，包括请求信息。
		getParameter(String name):可以通过一个控件的name属性来获取控件的值
		
		out:输出流对象，输出指定的信息。
		println();
	-->
	<h3 align="center">响应的字符编码集：<%= response.getCharacterEncoding() %></h3>
	
	<%
		String account = request.getParameter("account");
	
		String password = request.getParameter("password");
		
		Emp emp = new Emp(account,null,password,null);
		boolean flag = DBUtil.selectEmpByAccountAndPassword(emp);
		Map<String,Emp> map = DBUtil.map;
		if(flag == true){
			Object o = application.getAttribute("count");
			if(o == null){
				application.setAttribute("count", 1);
				
			}else{
				int count = Integer.parseInt(o.toString());
				application.setAttribute("count", count + 1);
				
			}
			session.setAttribute("account", account);
	%>
			<h3 align="right">访问量：<%= application.getAttribute("count") %></h3>
			<h3 align="right">登录账户：<%= session.getAttribute("account") %></h3>
			<h3 align="center">欢迎来到人事管理系统的首页</h3>
			<hr>
			<table align="center" border="1" width="500px">
				<tr>
					<td>
						账号
					</td>
					<td>
						员工姓名
					</td>
					<td>
						邮箱
					</td>
					<td>
						修改
					</td>
				</tr>
				<%
					for(String key : map.keySet()){
						Emp e = map.get(key);
						%>
							<tr>
								<td>
									<%= e.getAccount() %>
								</td>
								<td>
									<%= e.getName() %>
								</td>
								<td>
									<%= e.getEmail() %>
								</td>
								<td>
									<!-- 
									相邻两个JSP页面传递数据的时候。通过URL参数的方式来传递数据。
									规则：
									资源?key=value&key=value
									 -->
									<a href="update.jsp?account=<%= e.getAccount() %>&name=<%= e.getName() %>&email=<%= e.getEmail() %>">修改</a>
								</td>
							</tr>
						<%
						
					}
				%>
			</table>
	<%
		}else{
			throw new Exception("账号和密码错误");
		}
	%>
</body>
</html>