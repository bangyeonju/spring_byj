<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
a1.jsp<br>
model_attr1 : <%=request.getAttribute("model_attr")%><br>
model_attr2 : ${model_attr }<br>
model_attr3 : <%=request.getParameter("model_attr")%><br>
<br>
req_attr1 : <%=request.getAttribute("req_attr") %><br>
req_attr2 : ${req_attr }<br>
req_attr3 : <%=request.getParameter("req_attr") %><br>

