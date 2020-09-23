<%@page import="com.spring.ex.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result.jsp<br>
name1: ${stu.name }<br>
name2: ${stu.getName()}<br>
name3: <%=((Student)request.getAttribute("stu")).getName() %><br>

id1: ${stu.id}<br>
