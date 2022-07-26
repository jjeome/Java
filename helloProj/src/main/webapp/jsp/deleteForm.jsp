<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm.jsp</title>
</head>
<body>
	<%
		String bno = request.getParameter("bno");
		BoardDAO dao =  new BoardDAO();
		
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
		String loginId =(String) session.getAttribute("loginId");
	%>
		<c:set var="logId" value="<%=loginId %>" />
		<c:set var="vo" value="<%=vo %>" />
	<form action="delete.jsp">
		<table>
			<tr><th>글 번호</th><td><input type="text" name="id" value="${vo.boardId }" readonly>을 삭제하시겠습니까?</td></tr>
			<tr><td colspan="2"><input type="submit" value="삭제"
			<c:if test="${logId == null || logId != vo.writer}">
				disabled
			</c:if>>
			</td></tr>
		</table>
	</form>
</body>
</html>