<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="cal.jsp">
<input type="text" id="num1" name="num1">
<select id="op" name="op">
      <option value="+">더하기</option>
      <option value="-">빼기</option>
      <option value="*">곱하기</option>
      <option value="/">나누기</option>
</select>
<input type="text" id="num2" name="num2"> =
<input type="text" id="result"><br>
<input type="submit" value="계산하기">
</form>
</body>
</html>