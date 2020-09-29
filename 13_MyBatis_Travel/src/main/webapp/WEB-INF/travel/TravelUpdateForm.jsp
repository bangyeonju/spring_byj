<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>

<style type="text/css">
	.err{
		font-size : 9px;
		color : red;
		font-weight : bold;
	}

</style>

TravelUpdateForm.jsp<br>
<title>여행 목록 수정</title>

<form:form commandName="travel"  method="post"  action="update.tv">
<input type="hidden" name="num" value="${travel.num}">

	<h1><span>여행 정보 등록 화면</span></h1>
	<p>
		<label for="name">이름</label>
		<input type="text" name="name" id="name" value="${travel.name}">
		<form:errors cssClass="err" path="name"/>
	</p>

	<p>
		<label for="age">나이</label>
		<input type="text" name="age" id="age" value="${travel.age}">
		<form:errors cssClass="err" path="age"/>
	</p>
	<p>
		<label for="area">관심지역</label>

		<input type="checkbox" name="area" id="area" value="유럽" <c:if test="${fn:contains(travel.area,'유럽')}">checked</c:if> />유럽
		<input type="checkbox" name="area" id="area" value="동남아" <c:if test="${fn:contains(travel.area,'동남아')}">checked</c:if>/>동남아
		<input type="checkbox" name="area" id="area" value="일본" <c:if test="${fn:contains(travel.area,'일본')}">checked</c:if>/>일본
		<input type="checkbox" name="area" id="area" value="중국" <c:if test="${fn:contains(travel.area,'중국')}">checked</c:if>/>중국
		<form:errors cssClass="err" path="area"/>
	</p>
	
	<p>
		<label for="style">여행 타입</label>
		<input type="radio" name="style" id="style" value="패키지" <c:if test="${travel.style eq '패키지'}">checked</c:if>/>패키지
		<input type="radio" name="style" id="style" value="크루즈" <c:if test="${travel.style eq '크루즈'}">checked</c:if>/>크루즈
		<input type="radio" name="style" id="style" value="자유여행" <c:if test="${travel.style eq '자유여행'}">checked</c:if>/>자유여행
		<input type="radio" name="style" id="style" value="골프여행" <c:if test="${travel.style eq '골프여행'}">checked</c:if>/>골프여행
		<form:errors cssClass="err" path="style"/>
	</p>
	
	 <p>
		<label for="price">가격</label>
		<select name = "price" id="price" >
			<option value="">선택하세요</option>
			<option value="100~200" <c:if test="${travel.price eq '100~200'}">selected</c:if>/>100~200
			<option value="200~300" <c:if test="${travel.price eq '200~300'}">selected</c:if>/>200~300
			<option value="300~400" <c:if test="${travel.price eq '300~400'}">selected</c:if>/>300~400
			<option value="400~500" <c:if test="${travel.price eq '400~500'}">selected</c:if>/>400~500
		</select>
		<form:errors cssClass="err" path="price"/>
	</p>
	<p class="btnRow">
			<input type="submit" value="추가하기" id="btnSubmit">		
		</p>
</form:form>

