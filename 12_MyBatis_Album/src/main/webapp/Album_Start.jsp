<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
wabapp\Album_Start.jsp
<%
String viewPage = request.getContextPath()+"/list.ab";
System.out.print("viewPage"+viewPage);
//http://localhost:8080/ex/Album_Start.jsp
response.sendRedirect(viewPage);
%>