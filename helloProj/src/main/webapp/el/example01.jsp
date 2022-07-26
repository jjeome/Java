<%@page import="com.tst.board.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example01.jsp</title>
</head>
<body>
	<%
		request.setAttribute("user_id", "Hong" );
		UserVo vo = new UserVo();
		vo.setId("user1");
		vo.setPwd("1111");
		vo.setName("사용자1");
		//uservo의 주소값을 참조하고 있는 vo.
		//주소 값을 따라가보면 id/pwd/name 값들
		request.setAttribute("user", vo);
		
		request.getParameter("id"); //${param.id}
		request.getParameter("pwd");//${param.pwd}
	%>
	Literal: ${"Literal" }
	<br> Operator: ${5>3 }
	<br> Object: ${header.host }
	<br> IfCondition: ${5>3 ? "true" : "false" }
	<br> Context: ${pageContext.servletContext.contextPath }
	<br> UserId : ${user_id }
	<br> VO: ${user.id }, ${user.pwd }, ${user.name }
	<br> ${empty user ? "값이 없습니다" : user }
	<br> ID: ${param.id }, PWD: ${param["pwd"] }
</body>
</html>