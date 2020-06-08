<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
				
		<!-- 登录成功之后所有相同的菜单  -->
		<%@ include file="/pages/common/login_success_menu.jsp" %>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>	
			<c:forEach items="${ myOrders }" var="order">
				<tr>
					<td>${ order.createTime }</td>
					<td>${ order.totalMoney }</td>
					<td>
						<c:choose>
							<c:when test="${ order.status == 0 }">
								未发货
							</c:when>
							<c:when test="${ order.status == 1 }">
								<a href="client/orderServlet?action=receivedOrder&orderId=${ order.orderId }">确认收货</a>
							</c:when>
							<c:when test="${ order.status == 2 }">
								已签收
							</c:when>
						</c:choose>
					</td>
					<td><a href="#">查看详情</a></td>
				</tr>					
			</c:forEach>
		</table>
	</div>
	
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>