<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
write_view.jsp<br>
<form action="modify" method="post">
	<input type="hidden" name="num" value="${dto.num }"/>
<table border="1" width="500" cellpadding="0" cellspacing="0">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" size="50" value="${dto.id }"></td>
	</tr>
		<tr>
		<td>이름</td>
		<td><input type="text" name="name" size="50"  value="${dto.name }"></td>
	</tr>
		<tr>
		<td>나이</td>
		<td><input type="text" name="age" size="50" value="${dto.age}"></td>
	</tr>
		<tr>
		<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;
			<a href="list">목록보기</a>
		</td>
	</tr>
</table>
</form>