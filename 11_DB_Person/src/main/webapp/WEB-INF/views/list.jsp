<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
list.jsp<br>
레코드갯수:${fn:length(lists)}<br>
<table border="1">
<tr>	
	<th>번호</th>
	<th>아이디</th>
	<th>이름</th>
	<th>나이</th>
</tr>
<c:forEach items="${lists}" var="dto">
	<tr>	
		<td>${dto.num }</td>
		<td><a href="delete?num=${dto.num}">${dto.id }</a></td>
		<td><a href="content_view?num=${dto.num}">${dto.name }</a></td>
		<td>${dto.age }</td>
	</tr>
</c:forEach>
</table>
<a href="write_view">삽입</a>