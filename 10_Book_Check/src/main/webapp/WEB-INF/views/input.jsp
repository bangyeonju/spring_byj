<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
.err{
	font-size: 9pt;
	color:red;
	font-weight: bold;
	}
</style>
input.jsp<br>
<form:form commandName="bookDTO" action="inputProc" method="post">
	
	책 제목 :<input type="text" name="title" value="${bookDTO.title }">
	<form:errors cssClass="err" path="title"/><br>

	저자 :<input type="text" name="author" value="${bookDTO.author }">
	<form:errors cssClass="err" path="author"/><br>
	
	가격 :<input type="text" name="price" value="${bookDTO.price }">
	<form:errors cssClass="err" path="price"/><br>
	
	출판사 :<input type="text" name="publisher" value="${bookDTO.publisher}">
	<form:errors cssClass="err" path="publisher"/><br>
	
	<input type="submit" value="전송"/>
</form:form>