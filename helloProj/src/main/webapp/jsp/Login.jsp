<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//로그인 시도 시 에러 메세지 전달하기
	RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
	
	BoardDAO dao = new BoardDAO();
	//리턴되는 값이 null이면 값이 없다는 말
	if(dao.loginCheck(id, pwd) == null){
		//로그인 페이지로 이동
		request.setAttribute("msg", "아이디와 비밀번호를 확인하세요");
		rd.forward(request, response);
		//request.sendRedirect("loginForm.jsp");
	} else {
		//목록으로 이동
		session.setAttribute("loginId", id);
		response.sendRedirect("boardList.jsp");
	};
	
	
	
%>
