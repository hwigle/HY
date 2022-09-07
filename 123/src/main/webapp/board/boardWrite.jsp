<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board Write</title>

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
	$(function() {
		$("#title").val("제목입력");
	})

	function fn_submit() {

		// trim() -> 앞뒤 공백 제거, java, jsp js엔 없어서 jqeury 사용

		if ($.trim($("#title").val()) == "") {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		$("#title").val($.trim($("#title").val()));

		if ($("#pass").val() == "") {
			alert("암호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}

		$("#pass").val($.trim($("#pass").val()));

		var formData = $("#frm").serialize();
		// 비동기 전송방식의 기능을 가지고 있는 jquery의 함수
		$.ajax({
			type : "post",
			data : formData,
			url : "boardWriteSave.do",
			dataType : "text", // 리턴 타입
			success : function(data) { // controller -> "ok"(리턴값)
				if(data == "ok"){
					alert("작성완료");
					location="boardList.do";
				} else{
					alert("작성실패");
				}
			},
			error : function() { // 시스템적으로 장애 발생
				alert("오류발생");
			}

		});
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
	}
</script>
<body>
	<form name="frm" id="frm" action="boardWriteSave.do">
		<table>
			<caption>게시글 등록</caption>
			<tr>
				<th width="20%"><label for="title">제목</label></th>
				<td width="80%"><input class="input1" type="text" name="title"
					id="title"></td>
			</tr>
			<tr>
				<th><label for="pass">암호</label></th>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<th><label for="name">글쓴이</label></th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<th><label for="content">내용</label></th>
				<td><textarea class="textarea" name="content" id="content"></textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit" onclick="fn_submit(); return false;">저장</button>
					<button type="button">취소</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>