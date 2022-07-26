<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String id = request.getParameter("id");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardVO vo = new BoardVO();
	vo.setBoardId(Integer.parseInt(id));
	vo.setTitle(title);
	vo.setContent(content);
	
	
	BoardDAO dao = new BoardDAO();
	dao.deleteBoard(vo);
	
	//요청 재지정
	response.sendRedirect("boardList.jsp");

%>