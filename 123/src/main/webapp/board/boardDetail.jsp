<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	pageContext.setAttribute("newline", "\n");
%>
<c:set var="content"
	value="${fn:replace(detail.content,newline,'<br>' ) }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="../js/jquery-1.12.4.js"></script>
<script src="../js/jquery-ui.js"></script>

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

<script>
	$(function() {

		$("#title").val("제목입력");

	});

	function fn_submit() {
		// trim() -> 앞뒤 공백 제거 , java , jsp
		if ($.trim($("#title").val()) == "") {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		$("#title").val($.trim($("#title").val()));

		if ($.trim($("#pass").val()) == "") {
			alert("암호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
		$("#pass").val($.trim($("#pass").val()));

		var formData = $("#frm").serialize();

		// ajax : 비동기 전송방식의 기능을 가지고 있는 jquery의 함수
		$.ajax({
			/* 전송 전 세팅 */
			type : "POST",
			data : formData,
			url : "boardWriteSave.do",
			dataType : "text", // 리턴 타입

			/* 전송 후 세팅  */
			success : function(result) { // controller -> "ok","fail"
				if (result == "ok") {
					alert("저장완료");
					location = "boardList.do";
				} else {
					alert("저장실패");
				}
			},
			error : function() { // 장애발생
				alert("오류발생");
			}
		});
	}
</script>

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
				<button type="button" onclick="location='boardList.do'">목록</button>
				<button type="button" onclick="location='boardModify.do?unq=${detail.unq}'">수정</button>
				<button type="button" onclick="location='passWrite.do?unq=${detail.unq}'">삭제</button>
			</th>
			</tr>
		</table>
	</form>
</body>
</html>