<%@page import="com.spring.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/personView3.jsp<br><br>
<!-- person.id  person(소문자로 만들어짐) 참조변수가 자동으로 만들어짐  -->
id1: ${p.id }<br>
id2: ${person.id }<br>
id3: ${person.getId()}<br>
id4: ${requestScope.person.id}<br>
<hr>
pw1:${person.pw}<br>
pw2:${person.getPw()}<br>
pw3:${requestScope.person.pw}<br>
<hr>
name1 : ${person.name }<br>
name2 : ${person.getName()}<br>
name3 : ${requestScope.person.name}<br>
<hr>
addr1 : ${person.addr}<br>
addr2 : ${person.getAddr()}<br>
addr3 : ${requestScope.person.addr}<br>
<hr>
