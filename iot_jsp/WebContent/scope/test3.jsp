<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String msg = (String) request.getAttribute("msg");
   String session_msg = (String) session.getAttribute("msg");
   String application_msg = (String) application.getAttribute("msg");
   out.println(msg);
   out.println("<br>" + session_msg);
   out.println("<br>" + application_msg);
%>