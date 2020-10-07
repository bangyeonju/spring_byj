<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
MallList.jsp
<style type="text/css">
	body{
		text-align: center;
	}
	
</style>
<body>
<h2>주문내역</h2>
<table border="1" align="center">
	<tr>
		<td colspan="5" align="center">주문자 정보 :
			${sessionScope.loginInfo.name }(${sessionScope.loginInfo.id })</td>
	</tr>
	<tr>
		<td>상품번호</td>
		<td>상품명</td>
		<td>주문수량</td>
		<td>단가</td>
		<td>금액</td>
	</tr>
	<c:forEach items="${shoplists }" var="shopInfo">
		<tr>
			<td align="center">${shopInfo.pnum }</td>
			<td align="center">${shopInfo.pname }</td>
			<td align="center">${shopInfo.qty }</td>
			<td align="center">${shopInfo.price }</td>
			<td align="center">${shopInfo.amount }</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3">
			<a href="calculate.mall">결제하기</a> &nbsp;&nbsp;
			<a href="list.prd">추가주문</a>
		</td>
		<td colspan="2">총금액:${totalAmount}
		</td>
	</tr>
</table>
</body>
