<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/result.jsp<br>
name1=${name }<br>
name2=${requestScope.name }<br>
name3=<%=request.getAttribute("name") %><br>
<!-- http://localhost:8080/ex/person/input?name=kim&age=24 입력시 값을 받아온다.-->
name4=<%=request.getParameter("name") %><br>
name5=${param.name } <br>

age1 = ${age}<br>
age2 = ${requestScope.age}<br>
age3 = <%=request.getAttribute("age") %><br>
age4 = <%=request.getParameter("age")%><br>
age = ${param.age}<br>