<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="StudentGetServlet" method="get">
		<input type="hidden" name="cmd" value="search"> 
		ID: <input type="number" name="user_id" value="hong"><br>
		Name:<input type="text" name="user_name" value="홍길동"><br> 
		Eng:<input type="number" name="eng_score"><br> 
		Kor:<input type="number" name="kor_score"><br> 
		<input type="submit" value="조회"> <input id="addBtn" type="button" value="입력">
		<input id="modBtn" type="button" value="수정"> 
		<input id="delBtn" type="button" value="삭제">
		<hr>
		<a href="studentList.jsp">전체목록보기</a>
	</form>
	<script>
		let modBtn = document.getElementById('modBtn');
		modBtn.addEventListener('click', function() {
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "mod";
			frm.submit(); // submit버튼을 클릭
		});
		
		let delBtn = document.getElementById('delBtn');
		delBtn.addEventListener('click', function() {
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "del";
			frm.submit(); // submit버튼을 클릭
		});
		
		let btn = document.getElementById('addBtn');
		//let btn = document.querySelector('#addBtn');
		btn.addEventListener('click', function() {
			let frm = document.forms.frm;

			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "add"

			frm.submit(); // form의 submit			
		});
	</script>

</body>
</html>