<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBoard.do">
	<p>글 제목: <input type="text" name="title"></p> 
	<p>글 작성: <textarea name="content" rows="5" cols="30"></textarea></p>
	<p>작성자: <input type="text" name="writer"></p>
	<input type="submit" value="등록">
	</form>
</body>
</html>