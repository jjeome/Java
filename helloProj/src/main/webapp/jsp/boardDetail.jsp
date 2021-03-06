<%@page import="java.util.List"%>
<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
</head>
<body>
	<%
		//파라미터를 읽어서 BoardDAO에서 단건 조회기능을 사용해서
		//화면에 출력하도록 구현
		
		String bno = request.getParameter("id");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));// "3" -> 3
	%>
	<!-- 글번호, 제목, 내용, 작성자, 작성일자, 조회수 -->
	<table border="1">
	
	<tr><th>글 번호</th><td><%=vo.getBoardId() %></td></tr>
	<tr><th>글 제목</th><td><%=vo.getTitle() %></td></tr>
	<tr><th>글 내용</th><td><%=vo.getContent() %></td></tr>
	<tr><th>작성자</th><td><%=vo.getWriter() %></td></tr>
	<tr><th>작성일시</th><td><%=vo.getCreateDate() %></td></tr>
	<tr><th>조회수</th><td><%=vo.getCount() %></td></tr>
	</table>
	<p />
	<%
		
		String loginId = (String) session.getAttribute("loginId");
		//로그인 id와 작성자가 같을때만 보여주기
		//로그인 아이가 null값이 아닐때 보여주기
		if(loginId != null && loginId.equals(vo.getWriter())) {
		}
	%>	
		
	<a href="updateForm.jsp?bno=<%=vo.getBoardId() %>">수정</a>
	<a href="deleteForm.jsp?bno=<%=vo.getBoardId() %>">삭제</a>
	
	<a href="boardList.jsp">글 목록</a>
</body>
</html>





















