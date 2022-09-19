<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>

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
<script type="text/javascript">
/* 	$(function() {

		$("#title").val("제목입력");

	}); */

	function fn_submit() {
		
		// trim() -> 앞뒤 공백 제거 , java , jsp
		
		// document.frm.title.value == ""
		// $("#title").val() == ""
		// $.trim("  aabbcc   ")  ==> $.trim($("#title").val()) == ""
		
		if( $.trim($("#title").val()) == "" ) {
			alert("제목을 입력해주세요.");
			// document.frm.title.focus();
			$("#title").focus();
			return false;
		}
		
		$("#title").val( $.trim($("#title").val()) );
		
		if( $.trim($("#pass").val()) == "" ) {
			alert("암호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
		
		$("#pass").val( $.trim($("#pass").val()) );

		var formData = $("#frm").serialize();
		
		// ajax : 비동기 전송방식의 기능을 가지고 있는 jquery의 함수
		$.ajax({  
			/* 전송 전 세팅 */
			type:"POST",
			data:formData,
			url:"boardModifySave.do",
			dataType:"text",     // 리턴 타입
			
			/* 전송 후 세팅  */
			success: function(result) {  // controller -> 1
				if(result == "1") {
					alert("저장완료");
					location="boardList.do";
				} else if(result == "-1") {
					alert("암호가 일치하지 않습니다.");
				} else  {
					alert("저장실패\n관리자에게 연락해주세요.");
				}
			},
			error: function() {  // 장애발생
				alert("오류발생");
			}
		});
	}
	/* if(document.frm.title.value == ""){
		alert("제목을 입력해주세요.");
		document.frm.title.focus();
		return false;
	}
	if(document.frm.pass.value == ""){
		alert("암호을 입력해주세요.");
		document.frm.pass.focus();
		return false;
	} */

	// document.frm.submit();  동기전송방식
</script>
<body>
	<form id="frm">

		<input type="hidden" name="unq" value="${modify.unq }">												

		<table>
			<caption>게시글 수정</caption>
			<tr>
				<th width="20%"><label for="title">제목</label></th>
				<td width="80%"><input type="text" name="title" id="title" value="${modify.title}"></td>
			</tr>
			<tr>
				<th><label for="pass">암호</label></th>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<th><label for="name">글쓴이</label></th>
				<td><input type="text" name="name" id="name" value="${modify.name }"></td>
			</tr>
			<tr>
				<th><label for="content">내용</label></th>
				<td><textarea class="textarea" name="content" id="content">${modify.content }</textarea></td>
			</tr>
			<tr>
				<th colspan="2">					
					<button type="button" onclick="fn_submit();return false;">수정</button>
					<button type="button" onclick="location='boardDetail.do?unq=${modify.unq}'">취소</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>