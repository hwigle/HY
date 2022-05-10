<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

    <h3>도서수정조회</h3>
    <form action="../searchBook.do" method="get">
        <input type="text" name="bookCode"><br>
        <input type="hidden" name="job" value="modify">
        <input type="submit" value="조회">
    </form>
    
    <!-- 도서수정을 위한 화면 작성코드를 입력하세요. -->
   <c:choose>
	  <c:when test="${!empty result }"><h3>${result }</h3></c:when>
	  <c:otherwise>
	    <h3>도서정보수정</h3>
	    <form action="${pageContext.servletContext.contextPath }/modify.do" method="post">
	      도서코드: <input type="text" name="code" readonly value="${book.code }"><br>
	      도서명: <input type="text" name="title" value="${book.title }"><br>
	      도서저자: <input type="email" name="author" value="${book.author }"><br>
	      도서출판사: <input type="text" name="press" value="${book.press }"><br>
	      도서가격: <input type="text" name="price" value="${book.price }"><br>
	      <input type="submit" value="수정">
	    </form>
	  </c:otherwise>
	</c:choose>

    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>