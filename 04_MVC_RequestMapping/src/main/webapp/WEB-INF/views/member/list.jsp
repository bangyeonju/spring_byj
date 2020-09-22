<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
list.jsp<br>
name1 : <%=request.getParameter("name") %><br>
name2 : ${param.name }<br>
name3 : ${name }<br>
name4 : ${requestScope.name }<br>
name5 : <%=request.getAttribute("name")%><br>

pw1:${pw} <br>
pw2:<%=request.getAttribute("pw") %> <br>
pw3:${requestScope.pw } <br>
