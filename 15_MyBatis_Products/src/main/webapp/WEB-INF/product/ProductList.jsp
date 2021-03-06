<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>

<script type="text/javascript">
	function insert(){
		location.href="insert.prd";
	}
	function goUpdate(num) {
		
		location.href="update.prd?num="+num;
		
	}
</script>

<form action="list.prd" method="get">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="name">상품명
		<option value="contents">설명
	</select>
	<input type="text" name="keyword" value="오렌지">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="6">
		<input type="button" value="추가하기" onclick="insert()"> 
		</td>
	</tr>
	<tr>
		<th>상품ID</th>
		<th>상품명</th>
		<th>설명</th>
		<th>가격</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<!-- items를 반복~ -->
	<c:forEach items="${lists}" var="product">
	<tr>
		<td>${product.num }</td>
		<td><a href="detail.prd?num=${product.num}">${product.name }</a></td>
		<td>${product.contents }</td>
		<td>${product.price }</td>
		<td><a href="delete.prd?num=${product.num }">삭제</a></td>
		<td><input type="button" value="수정" onClick="goUpdate('${product.num}')" ></td>
	</tr>
	</c:forEach>
</table>
${pageInfo.pagingHtml} 