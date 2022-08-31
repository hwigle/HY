<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서목록</h1>
	<table border="1">		
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
		<tr><!-- var = 내부 변수, items = 데이터 값-->
		<c:forEach var="result" items="${deptList}" varStatus="status">
		<tr>
			<th>${result.deptno}</th>
			<th><a href="/deptDetail.do?deptno=${result.deptno}">${result.dname}</a></th>
			<th>${result.loc}</th>
		<tr>
		</c:forEach>		
	</table>
	<button type="button" onclick="location='deptWrite.do'">추가</button>
</body>
</html>