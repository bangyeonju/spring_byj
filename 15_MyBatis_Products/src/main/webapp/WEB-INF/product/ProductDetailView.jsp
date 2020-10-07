<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common.jsp" %>
ProductDetailView.jsp
<table border="1" >
	<tr>
		<td rowspan="6">
			<img src="<%=request.getContextPath() %>/resources/${product.image}" width="100px" height="100px">
		</td>

		
		<th width="150">상품명</th>
		<td width="300">${product.name}</td>
	</tr>
	<tr>
		<th width="150">가격</th>
		<td width="300">${product.price}</td>
	</tr>
	<tr>
		<th width="150">재고수량</th>
		<td width="300">${product.stock }</td>
	</tr>
	<tr>
		<th width="150">설명</th>
		<td width="300">${product.contents}</td>
	</tr>
	<tr>
		<th width="150">주문수량</th>
		<td width="300">
		<!-- add.mall = > CartAddController -->
		<form action="add.mall" method="post">
		<input type="hidden" name="num" value="${product.num}">
		<input type="text" name="orderqty" value="1">
		<input type="submit" value="주문">
		</form>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<a href="list.prd">상품리스트</a>
		</td>
	</tr>
	
	
	
</table>