<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
String op = request.getParameter("op");
int result = 0;
if(op.equals("+")) {
	result = num1 + num2;
} else if(op.equals("-")) {
	result = num1 - num2;
} else if(op.equals("*")) {
	result = num1 * num2;
} else if(op.equals("/")) {
	result = num1 / num2;
}  
HashMap<String,Object> rm = new HashMap<String, Object>();
rm.put("result",result);
String json = new Gson().toJson(rm);
out.println(json);
%>