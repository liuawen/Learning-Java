<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	
	$(function(){
		
		// 添加购物车Ajax请求
		$(".addCart").click(function(){
			// 通过添加idv属性保存商品id信息
			var idv = $(this).attr("idv");		
			$.getJSON("cartServlet?action=ajaxAddItem&id=" + idv,function(data) {
				if (data.result == 0) {
					$("#cart_totalCount").html("您的购物车中有" + data.totalCount + "件商品");
					$("#last_product").html("您刚刚将<span style='color: red'>" + data.last_product + "</span>加入到了购物车中");
				}
			});
			
			return false;
		});
		
	});

</script>
</head>
<body>
	
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<a href="pages/user/login.jsp">登录</a> | 
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
						<input type="hidden" name="action" value="pageByPrice" />
					价格：<input id="min" type="text" name="min" value="${ param.min }"> 元 - 
						<input id="max" type="text" name="max" value="${ param.max }"> 元 
						<input type="submit" value="查询" id="price_search"/>
				</form>
			</div>
			<div style="text-align: center">
				<c:choose>
					<%-- 购物车为空 --%>
					<c:when test="${ empty cart.items }">
						<span id="cart_totalCount">您的购物车为空！</span>
						<div id="last_product"> &nbsp; </div>
					</c:when>
					<c:otherwise>
						<span id="cart_totalCount">您的购物车中有${ cart.totalCount }件商品</span>
						<div id="last_product">
							您刚刚将<span style="color: red">${ sessionScope.last_product }</span>加入到了购物车中
						</div>					
					</c:otherwise>
				</c:choose>
			</div>
			<c:forEach items="${ page.items }" var="item">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${ item.imgPath }" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${ item.name }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${ item.author }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${ item.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${ item.sales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${ item.stock }</span>
						</div>
						<div class="book_add">
							<a idv="${ item.id }" class="addCart" href="cartServlet?action=addItem&id=${ item.id }">加入购物车</a>
						</div>
					</div>
				</div>
			</c:forEach>

			


			


		</div>
		
		<%@ include file="/pages/common/page.jsp" %>
	
	</div>
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>