<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
a1.jsp<br>
model_attr1 : <%=request.getAttribute("model_attr")%><br>
model_attr2 : ${model_attr }<br>
model_attr3 : <%=request.getParameter("model_attr")%><br> <!-- 또다른 요청에 따라 이동했을떄 .model만 parameter로 받아올수있다. -->
<br>
req_attr1 : <%=request.getAttribute("req_attr") %><br>
req_attr2 : ${req_attr }<br>
req_attr3 : <%=request.getParameter("req_attr") %><br>

