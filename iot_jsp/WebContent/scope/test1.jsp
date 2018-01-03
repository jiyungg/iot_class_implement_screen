<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setAttribute("msg", "난 테스트1에서 셋팅된 값이야");
session.setAttribute("msg", "난 테스트1에서 셋팅된 세션값이야");
application.setAttribute("msg", "난 테스트1에서 셋팅된 어플리케이션값이야");
RequestDispatcher re = application.getRequestDispatcher("./test2.jsp");
re.forward(request, response);

%>