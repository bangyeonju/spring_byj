<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
AlbumList.jsp
<script type="text/javascript">
   function goUpdate(num,pageNumber,pageSize){//${album.num}을 num변수로 받음
	  //alert(1);
   		//alert(num);
      location.href="update.ab?num="+num+"&pageNumber="+pageNumber+"&pageSize="+pageSize;
   
   }
</script>
<!-- form안에 있는것는 다 넘어간다. -->
<h2>앨범 리스트 화면(레코드갯수:${totalCount})</h2>
<form action="list.ab" method="get">
	<select name="whatColumn">
		<option value="all">전체검색</option>
		<option value="title">노래제목</option>
		<option value="singer">가수명</option>
	</select>
	<input type="text" name="keyword" value="아이유">
	<input type="submit" value="검색"/>
	
</form>

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
		<td><a href="delete.ab?num=${album.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
		<td><input type="button" value="수정" onClick="goUpdate('${album.num}','${pageInfo.pageNumber}','${pageInfo.pageSize}')"/></td>

	</tr>
	</c:forEach>
</table>

<br>
${pageInfo.pagingHtml }<br>
<a href="insert.ab">삽입</a>