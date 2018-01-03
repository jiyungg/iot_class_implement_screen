<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String param = request.getParameter("param");
Gson gs = new Gson();
HashMap hm = gs.fromJson(param, HashMap.class);
System.out.println(hm);
System.out.println(param);
System.out.println(hm.get("id"));
System.out.println(hm.get("pwd"));
System.out.println(hm.get("name"));
hm.put("id","이전 서버에서 바꾼값");
out.println(gs.toJson(hm));
%>