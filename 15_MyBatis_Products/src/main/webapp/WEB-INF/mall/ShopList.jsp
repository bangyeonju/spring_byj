<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common.jsp"%>
    <a href="logout.jsp">로그아웃</a>
    <h2>주문내역</h2>
<table border="1">
	<tr>
		<td colspan="3">주문자 정보 :${sessionScope.loginInfo.name}(${sessionScope.loginInfo.id })</td>
	</tr>
	<tr>
		<th>주문번호</th>
		<th>주문 일자</th>
		<th>상세보기</th>
	</tr>
	<c:forEach items="${lists }" var="order">
		<tr>
			<td>${order.oid }</td>
			<td>${order.orderdate }</td>
			<td><a href="detailView.mall?oid=${order.oid}">상세보기</a></td>
		</tr>
	</c:forEach>
</table>