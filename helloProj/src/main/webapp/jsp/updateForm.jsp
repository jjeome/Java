<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%  //수정)


		//서블릿이 선언될때 원래 가지고 있는 내장객체가 있어서 따로 선언 X
		//getParameter는 리턴값이 무조건 문자열.
		String bno = request.getParameter("bno");
		BoardDAO dao = new BoardDAO();
		//int타입으로 받아야해서 매개값을 캐스팅
		//board타입으로 반환됨
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
		String loginId =(String) session.getAttribute("loginId");
	%>
	<c:set var="vo" value="<%=vo %>" />
	<c:set var="logId" value="<%=loginId %>" />
	<form action="update.jsp">
		<table border="1">
		<!-- 글번호는수정 X -->
			<tr><th>글 번호</th><td><input type="text" name="id" value="${vo.boardId }" readonly></td></tr>
			<tr><th>내용</th><td><input type="text" name="content" value="${vo.content }"></td></tr>
			<tr><th>제목</th><td><input type="text" name="title" value="${vo.title }"></td></tr>
			<tr><th>작성자</th><td><input type="text" value="${vo.writer }" readonly></input></td></tr>
			<tr><td colspan="2"><input type="submit" value="수정" 
			<c:if test="${logId == null || logId != vo.writer }">
			disabled
			</c:if>>
			</td></tr>
		</table>
	</form>
</body>
</html>