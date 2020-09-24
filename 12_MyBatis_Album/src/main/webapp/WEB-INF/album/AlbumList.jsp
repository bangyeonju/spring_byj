<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
AlbumList.jsp
${fn:length(lists)}
<table border="1">
	<tr>
			<th>번호</th>
			<th>노래제목</th>
			<th>가수명</th>
			<th>가격</th>
			<th>출간일</th>
			<th>삭제</th>
			<th>수정</th>
	</tr>
	<c:forEach var="album" items="${lists }"> 
	<tr>
		<td>${album.num }</td>
		<td>${album.title }</td>
		<td>${album.singer }</td>
		<td>${album.price }</td>
		<td>${album.day }</td>
		<td><a href="delete.ab?num=${album.num}">삭제</a></td>
		<td><a href="update.ab?num=${album.num}">수정</a></td>
	</tr>
	</c:forEach>
</table>
<a href="insert.ab">삽입</a>