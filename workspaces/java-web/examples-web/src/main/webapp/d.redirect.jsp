<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
pageContext.setAttribute("page-data", "This is Page Scope Data (from redirect)");
request.setAttribute("req-data", "This is Request Scope Data (from redirect)");

response.sendRedirect("d.result.jsp"); // redirect 방식으로 d.result.jsp로 이동
%>