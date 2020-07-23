<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".deleteBookClass").click(function(){
			return confirm("你确定要删除吗？");
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		
		<!-- 这是manager管理模块的共同菜单  -->
		<%@ include file="/pages/common/manager_menu.jsp" %>


	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>	
			<c:forEach items="${ page.items }" var="item">
				<tr>
					<td>${ item.name }</td>
					<td>${ item.price }</td>
					<td>${ item.author }</td>
					<td>${ item.sales }</td>
					<td>${ item.stock }</td>
					<td><a href="manager/bookServlet?action=getBook&id=${ item.id }&m=update&pageNo=${page.pageNo}">修改</a></td>
					<td><a class="deleteBookClass" href="manager/bookServlet?action=delete&id=${ item.id }&pageNo=${page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?m=add&pageNo=${page.pageNo}">添加图书</a></td>
			</tr>	
		</table>
		
		<br/>
		
		<%@ include file="/pages/common/page.jsp" %>
		

	</div>
	

	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>