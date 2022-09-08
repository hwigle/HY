<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<% pageContext.setAttribute("newline", "\n"); %>
<c:set var="content" value="${fn:replace(detail.content,newline,'<br>' ) }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	font-size: 9pt;
}

button {
	font-size: 9pt;
}

table {
	width: 600px;
	border-collapse: collapse; /* cell 간격 없앰 */
}

th, td {
	border: 1px solid #cccccc;
	padding: 5px;
}

.input1 {
	width: 98%;
}

.textarea {
	width: 98%;
	height: 70px;
}
</style>
<body>
	<form name="frm" id="frm" action="boardWriteSave.do">
		<table>
			<caption>게시글 상세</caption>
			<tr>
				<th width="20%">제목</th>
				<td width="80%">${detail.title }</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>${detail.name }</td>
			</tr>			
			<tr>
				<th>작성일</th>
				<td>${detail.rdate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${detail.hits }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td height="50">${detail.content}</td>
			</tr>
			
				<th colspan="2">
					<button type="submit" onclick="fn_submit(); return false;">저장</button>
					<button type="button">취소</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>