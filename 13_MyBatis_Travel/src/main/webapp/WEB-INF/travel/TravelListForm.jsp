<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>

TravelListForm.jsp<br>
<h2>여행 리스트 화면</h2>
<form action="list.tv" method="get">
	<select name="searchColumn">
		<option value="all">전체검색
		<option value="area">관심지역
		<option value="style">여행타입
	</select>
	<input type="text" name="searchWord" value="">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>나이</td>
		<td>관심지역</td>
		<td>여행타입</td>
		<td>예상비용</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	
<c:forEach items="${lists}" var="travel">
	<tr>
		<td>${travel.num}</td>
		<td>${travel.name}</td>
		<td>${travel.age}</td>
		<td>${travel.area}</td>
		<td>${travel.style}</td>
		<td>${travel.price}</td>
		<td><a href="delete.tv?num=${travel.num}">삭제</a></td>
		<td><a href="update.tv?num=${travel.num}">수정</a></td>
	</tr>
</c:forEach>	
	
</table>

<a href="insert.tv">삽입</a>





