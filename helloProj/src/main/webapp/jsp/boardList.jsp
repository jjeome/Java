<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
</head>
<body>
	<table border="1">
	<thead>
		<tr>
		<td>글 번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일자</td>
		<td>방문횟수</td>
		</tr>
	</thead>
	<tbody>
	<% 
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.bList();
		
	 		for(BoardVO vo : list){
	%>	
			<tr>
			<% //a태그의 id값을 자기자신으로 줌 %>
			<td><a href="boardDetail.jsp?id=<%=vo.getBoardId() %>"><%=vo.getBoardId() %></a></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getWriter() %></td>
			<td><%=vo.getCreateDate() %></td>
			<td><%=vo.getCount() %></td>
			</tr>
	<% 
			}
	%>
	</tbody>
	</table>
</body>
</html>