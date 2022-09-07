<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드목록</title>
</head>
<style>
table {
	width: 400px;
	border-collapse: collapse; /* cell 간격 없앰 */
}

th, td {
	border: 1px solid #cccccc;
	padding: 5px;
}
</style>

<script type="text/javascript">
	function fn_delete(code) {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location = "codeDelete.do?code=" + code;
		}
	}

	function fn_modify(code) {
		location = "codeModifyWrite.do?code=" + code
	}
</script>
<body>
	<table>
		<caption>
			<div>코드목록</div>
			<br>
			<div style="width: 100%; text-align: left;">Total :${total}개</div>
		</caption>

		<colgroup>
			<col width="14%" />
			<col width="30%" />
			<col width="30%" />
			<col width="26%" />
		<tr>
			<th>번호</th>
			<th>그룹명</th>
			<th>코드명</th>
			<th>구분</th>
		</tr>
		<c:set var="cnt" value="1" />
		<!-- var=변수일음, value=변수 값(초기값) -->
		<c:forEach var="list" items="${codeList}">
			<tr align="center">
				<th>${cnt}</th>
				<!-- <c:out value="${count}" /> 예전 버전 -->
				<th>${list.gid}</th>
				<th>${list.name }</th>
				<th>
					<button type="button" onclick="fn_modify('${list.code}')">수정</button>
					<button type="button" onclick="fn_delete('${list.code}')">삭제</button>
				</th>
			</tr>
			<c:set var="cnt" value="${cnt+1 }" />
		</c:forEach>
	</table><br>
	<button type="button" onclick="location='codeWrite.do'">등록</button>
</body>
</html>