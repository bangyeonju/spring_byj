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
<c:forEach items="p" var="${lists}">
	<tr>	
		<td>${p.num }</td>
		<td>${p.id }</td>
		<td>${p.name }</td>
		<td>${p.age }</td>
	</tr>
</c:forEach>
</table>