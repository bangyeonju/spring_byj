<%@page import="com.spring.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/personView2.jsp<br><br>
id : <%=request.getParameter("id") %><br>
pw : ${param.pw }<br>
name1 : ${param.name }<br>
addr : ${param.addr }<br>
<br><br>

per.id1 : ${per.id } <br>
per.id2 : ${requestScope.per.getId() } <br>
per.id3 : ${requestScope.per.id } <br>
per.id4 : ${per.getId() } <br>

per.id5 : <%=request.getAttribute("per") %> <br> <!-- 4개를 한번에 묶인 주소가 나옴다. -->
per.id6 : <%=((Person)request.getAttribute("per")).getId()%> <br>

per.pw1 : ${requestScope.per.pw }<br>
per.pw2 : ${requestScope.per.getPw()}<br>
per.pw3 : ${per.getPw() }<br>
per.pw4 : ${per.pw }<br>
per.pw5 : <%=((Person)request.getAttribute("per")).getPw() %><br>

per.name1 : ${requestScope.per.name }<br>
per.name2 : ${requestScope.per.getName()}<br>
per.name3 : ${per.getName()}<br>
per.name4 : ${per.name}<br>
per.name5 : <%=((Person)request.getAttribute("per")).getName() %><br>

per.addr1 : ${requestScope.per.addr }<br>
per.addr2 : ${requestScope.per.getAddr() }<br>
per.addr3 : ${per.addr}<br>
per.addr4 : ${per.getAddr()}<br>
per.addr5 : <%=((Person)request.getAttribute("per")).getAddr() %><br>


