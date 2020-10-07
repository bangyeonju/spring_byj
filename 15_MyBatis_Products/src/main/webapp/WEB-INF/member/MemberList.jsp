<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>

<script type="text/javascript">
	function insert(){
		location.href="registerForm.me";
	}
</script>

<form action="list.me" method="get">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="name">이름
		<option value="gender">성별
	</select>
	<input type="text" name="keyword" value="여">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="9">
		<input type="button" value="추가하기" onclick="insert()"> 
		</td>
	</tr>
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>비번</th>
		<th>성별</th>
		<th>취미</th>
		<th>주소</th>
		<th>포인트</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<!-- items를 반복~ -->
	<c:forEach items="${lists}" var="member">
	<tr>
		<td>${member.id }</td>
		<td>${member.name }</td>
		<td>${member.password }</td>
		<td>${member.gender }</td>
		<td>${member.hobby }</td>
		<td>${member.address1 }${member.address2}</td>
		<td>${member.mpoint}</td>
		<td><a href="delete.me?id=${member.id}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
		<td><a href="">수정</a></td>
	</tr>
	</c:forEach>
</table>
${pageInfo.pagingHtml} 