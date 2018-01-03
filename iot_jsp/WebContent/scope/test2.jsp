<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
String sessionMsg = (String)session.getAttribute("msg");
String sessionMsg = (String)session.getAttribute("msg");

out.println(msg);
out.println("<br>" + sessionmsg);
%>