<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result3.jsp<br>
title : ${musicBean.title}
singer : ${requestScope.musicBean.singer}
price : ${musicBean.getPrice()}