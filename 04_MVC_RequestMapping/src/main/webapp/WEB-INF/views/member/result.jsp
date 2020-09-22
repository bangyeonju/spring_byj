<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
member\result.jsp<br>

id1 : <%=request.getParameter("id") %> <br>
id2 : ${param.id} <br>
id3 : ${id}<br>
id4 : ${requestScope.id }<br>
id5 : <%=request.getAttribute("id") %><br>
