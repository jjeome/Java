package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet{
	//post요청이 들어오면 로그인 하는 메소드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//파라미터를 id와 pwd로 주기(html에서의 id값)
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		//id와 pwd값이 비어있으면
		if(id.isEmpty() || pwd.isEmpty()) {
			out.print("ID와 PassWord를 입력해주세요");
			return; //메소드 종료
		}
		
		//요청정보의 getSession정보 불러오기
		HttpSession session = req.getSession();
		//세션이 이미 있거나 세션값이 null이면,
		if(session.isNew() || session.getAttribute("id")==null) {
			//id라는 값(attribute)을 추가
			session.setAttribute("id",id);
			out.print("로그인 완료");
		} else {
			out.print("현재 로그인 중입니다");
		}
	}
	
	//get요청이 들어오면 로그아웃 하는 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//로그아웃이니까 세션 새로 만들 필요 없으니까 false
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("id") != null) {
			session.invalidate();// 세션 삭제
			out.print("로그아웃 완료");
		} else {
			out.print("현재 로그인 상태 아닙니다.");
		}
			
	}
}























