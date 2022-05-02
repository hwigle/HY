<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>반갑습니다.</h3>
	<%
	// 자바코드.
	String name = "홍길동";
	out.println("<h3>" + name + "</h3>"); //
	// input의 name 속성이 parameter 값이 됨
	String id = request.getParameter("user_id"); 
	String name2 = request.getParameter("user_name");
	out.println("<h4>입력값: " + id +", name: " + name2+"</h4>");
	%>
	<a href="./abcdefg.do">Student Servlet</a>
</body>
</html>