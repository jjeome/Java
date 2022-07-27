<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 등록</title>
</head>
<body>
	<!-- 뷰페이지 -->
	<h3>회원 가입</h3>
	<!-- memerInsert.do가 요청들어오면 frontController 실행 -->
	<form action="../memberInsert.do" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		이름 : <input type="text" name = "name"><br>
		이메일 : <input type="text" name = "mail"><br>
		<input type="submit" value="입력">
	</form>
</body>
</html>