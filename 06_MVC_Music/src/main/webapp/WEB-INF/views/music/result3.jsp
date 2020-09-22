<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result3.jsp<br>
<!-- MusicBean => 처음에만 소문자 .. musicBean -->
title : ${musicBean.title}
singer : ${requestScope.musicBean.singer}
price : ${musicBean.getPrice()}