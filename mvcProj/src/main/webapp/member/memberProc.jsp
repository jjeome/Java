<%@page import="co.dev.vo.MemberVO"%>
<%@page import="co.dev.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pw = request.getParameter("passwd");
	String mail = request.getParameter("mail");

	
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setName(name);
	vo.setMail(mail);
	vo.setPasswd(pw);
	
	MemberService service = MemberService.getInstance();
	service.addMember(vo);
	
	request.setAttribute("member", vo);
	
	//처리결과 : memberOutput.jsp
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
%>
