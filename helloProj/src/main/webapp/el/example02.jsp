<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.tst.board.BoardVO" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example02.jsp</title>
</head>
<body>
	<%
		BoardVO vo = new BoardVO();
		String name = "Hong";
	%>
	
	<!--
		변수에 값을 담고싶을때 c:set 사용
		user1에 있는 값을 읽어들임
		자바소스 말고 c태그 쓰기 -->
	
	<c:set var ="user" value="user1"></c:set>
	<c:out value="${user }"></c:out>
	
	<!-- p1이라는 변수에다가 파라미터로 넘어오는 title을 담음 -->
	<c:set var="p1" value="${param.title }"></c:set>
	<c:set var="p2" value="${param.content }"></c:set>
	<c:set var="p3" value="${param.writer }"></c:set>
	
	<!-- 위에서 넘긴 파라미터 값을 여기서 처리함 -->
	<p><c:out value="${p1 }"></c:out></p>
	<p><c:out value="${p2 }"></c:out></p>
	<p><c:out value="${p3 }"></c:out></p>
</body>
</html>