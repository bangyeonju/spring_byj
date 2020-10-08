<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../common.jsp" %>
<a href="main.jsp">시작페이지</a>
<h2>주문 상세 내역</h2>
<table border="1">
	<tr>	
		<td colspan="2">고객 :${loginInfo.name }</td>
		<td colspan="3">송장번호:${oid} </td>
	</tr>
	<tr>
		<td colspan="5">
		배송지: ${loginInfo.address1 }  ${loginInfo.address2}
		</td>
	</tr>
	<tr>
		<th>순번</th>
		<th>상품명(상품번호)</th>
		<th>수량</th>
		<th>단가</th>
		<th>금액</th>
	</tr>
	<c:forEach var="result" items="${lists }" varStatus="status" >
	<tr>	
		<td>${status.count}</td>
		<td>${result.pname}(${result.pnum})</td>
		<td>${result.qty}</td>
		<td><fmt:formatNumber value="${result.price}" pattern="###,###"/></td>
		<td><fmt:formatNumber value="${result.amount}" pattern="###,###"/></td>
	</tr>
	</c:forEach>
</table>