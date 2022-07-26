<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/boardList.jsp</title>
</head>
<body>
	
	<%
		//String id = (String)session.getAttribute("loginId");
		//if(id != null){
			//out.print("<h3>"+id+"님으로 로그인 되었습니다.</h3>");
			//out.print("<a href='logout.jsp'>로그아웃</a>");
		//} else {
			//out.print("<h3>손님입니다.</h3>");
		//} 
	%>
	<c:choose>
		<c:when test="${!empty loginId }">
			<h3><c:out value="${loginId }"></c:out>님으로 로그인 했습니다.</h3>
		</c:when>
		<c:otherwise><h3>손님입니다.</h3></c:otherwise>
	</c:choose> 
	

	<table border="1">
	<thead>
		<tr>
		<td>글 번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성 일자</td>
		<td>방문 횟수</td>
		</tr>
	</thead>
	<tbody>
	<%  //나중에 서블릿으로 만들어서 처리
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.bList();
		
	 		//for(BoardVO vo : list){
	%>	
	<c:set var="boards" value="<%=list %>" />
	<c:forEach var="vo" items="${boards }">
		
		<tr>
			<% //a태그의 id값을 자기자신으로 줌 %>
			<td><a href="boardDetail.jsp?id=${vo.boardId }">${vo.boardId }</a></td>
			<td>${vo.title }</td>
			<td>${vo.writer }</td>
			<td>${vo.createDate }</td>
			<td>${vo.count }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<p />
	<a href="addBoard.jsp">글 작성</a>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>