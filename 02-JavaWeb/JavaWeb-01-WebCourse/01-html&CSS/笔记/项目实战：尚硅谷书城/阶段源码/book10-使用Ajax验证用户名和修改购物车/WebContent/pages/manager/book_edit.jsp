<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
		
		<!-- 这是manager管理模块的共同菜单  -->
		<%@ include file="/pages/common/manager_menu.jsp" %>

		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="post">
				<input type="hidden" name="pageNo" value="${param.pageNo }" />
				<c:choose>
					<c:when test="${ empty book }">
						<input type="hidden" name="action" value="add" />
					</c:when>
					<c:otherwise>
						<input type="hidden" name="action" value="update" />
						<input type="hidden" name="id" value="${ book.id }" />
					</c:otherwise>
				</c:choose>
			
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						
						<td><input name="name" type="text" value="${ book.name }"/></td>
						<td><input name="price" type="text" value="${ book.price }"/></td>
						<td><input name="author" type="text" value="${ book.author }"/></td>
						<td><input name="sales" type="text" value="${ book.sales }"/></td>
						<td><input name="stock" type="text" value="${ book.stock }"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>
				</table>
				
			</form>
		</div>
		
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>