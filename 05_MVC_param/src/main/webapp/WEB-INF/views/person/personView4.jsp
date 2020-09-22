<%@page import="com.spring.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/personView4.jsp<br><br>
id1: ${p.id }<br>
id2: ${person.id }<br>
id3: ${person.getId()}<br>
id4: ${requestScope.person.id}<br>

<hr>
id5: ${abcd.id }<br>
id6: ${requestScope.abcd.id}<br>
id7: ${requestScope.abcd.getId()}<br>
id8: <%=((Person)request.getAttribute("abcd")).getId() %><br>

<hr>
pw1:${abcd.pw }<br>
pw2:${requestScope.abcd.pw}<br>
pw3:${requestScope.abcd.getPw() }<br>
pw4: <%=((Person)request.getAttribute("abcd")).getPw() %><br>
<hr>
name1:${abcd.name }<br>
name2:${requestScope.abcd.name}<br>
name3:${requestScope.abcd.getName() }<br>
name4: <%=((Person)request.getAttribute("abcd")).getName() %><br>

<hr>
addr1:${abcd.addr }<br>
addr2:${requestScope.abcd.addr}<br>
addr3:${requestScope.abcd.getAddr() }<br>
addr4: <%=((Person)request.getAttribute("abcd")).getAddr() %><br>
