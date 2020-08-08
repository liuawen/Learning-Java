<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    
		<div id="page_nav">
			<a href="${ page.url }&pageNo=1">首页</a>
			<c:if test="${ page.pageNo > 1 }">
				<a href="${ page.url }&pageNo=${ page.pageNo - 1 }">上一页</a>
			</c:if>
			
			<c:choose>
				<%-- 当总页码小于等于5的情况 --%>
				<c:when test="${ page.pageTotal <= 5 }">

					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${ page.pageTotal }"></c:set>					
					
				</c:when>
				<c:otherwise>
					<%-- 当总页码大于5的情况 --%>
					<c:choose>
						<%-- 当前页码是前三 --%>
						<c:when test="${ page.pageNo <= 3 }">
						
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="5"></c:set>	
						
						</c:when>
						<%-- 当前页码是后三 --%>
						<c:when test="${ page.pageNo >= page.pageTotal - 2 }">
						
							<c:set var="begin" value="${ page.pageTotal - 4 }"></c:set>
							<c:set var="end" value="${ page.pageTotal }"></c:set>							
						
						</c:when>
						<c:otherwise>
						
							<c:set var="begin" value="${ page.pageNo - 2 }"></c:set>
							<c:set var="end" value="${  page.pageNo + 2 }"></c:set>							
						
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			
			
			
							
			<c:forEach begin="${ begin }" end="${ end }" var="i">
				<c:if test="${ i == page.pageNo }">【${ i }】</c:if>
				<c:if test="${ i != page.pageNo }"><a href="${ page.url }&pageNo=${i}">${i}</a></c:if>
			</c:forEach>
			
			
			<c:if test="${ page.pageNo < page.pageTotal }">
				<a href="${ page.url }&pageNo=${ page.pageNo + 1 }">下一页</a>
			</c:if>
			
			<a href="${ page.url }&pageNo=${ page.pageTotal }">末页</a>
			共${ page.pageTotal }页，${ page.totalCount }条记录 到第<input value="${ page.pageNo }" name="pn" id="pn_input"/>页
			<input id="search_pageNo" type="button" value="确定">
		</div>
		
	<script type="text/javascript">
		$(function() {
			$("#search_pageNo").click(function(){
				location.href = "${ page.url }&pageNo=" + $("#pn_input").val();
			});
		});
	</script>		
		