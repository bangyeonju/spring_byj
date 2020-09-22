<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
id : <%=request.getParameter("id") %><br>
pw : ${param.pw }<br>
name1 : ${param.name }<br>
addr : ${param.addr }<br>
<br><br>
name2 : ${param.Mname }<br>
name3 : ${Mname }<br>
name4 : ${requestScope.Mname}<br>
name5 : <%=request.getAttribute("Mname") %><br>
