<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard.jsp</title>
</head>
<body>
	<%
		//String user = (String) session.getAttribute("loginId");
		//if(user==null || user.equals("")){
			//response.sendRedirect("loginForm.jsp");
		//}
	%>
	<c:set var="user" value="${loginId }"></c:set>
	<!-- user값이 비어있다면 LoginForm으로 이동 -->
	<c:if test="${empty user }">
		<c:redirect url="loginForm.jsp"></c:redirect>
	</c:if>
	
	<form action="insertBoard.jsp" method="post">
	글 제목: <input type ="text" name="title"><br>
	글 내용: <textarea name="content" rows="3" cols="30"></textarea><br>
	작성자 : <input type="text" name="writer" value="${user }" readonly><br>
	<input type="submit" value="등록">
	</form>
</body>
</html>