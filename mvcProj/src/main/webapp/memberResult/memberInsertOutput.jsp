<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jstl써도 되고 표현식을 바로 써줘도 됨 -->
	<h3>${member.name }님 가입이 완료되었습니다.</h3>
	<jsp:include page="./home.jsp"></jsp:include>
</body>
</html>