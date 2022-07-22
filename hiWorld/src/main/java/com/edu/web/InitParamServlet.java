package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{
	// 객체 생성(생성자) -> ServletConfig객체 생성됨(서블릿에 선언되어져 있는 파라미터 값을 읽어드리는 객체) ->  init(sc)
	// -> service (rq,rs) 
	String id;
	String pw;
	
	public InitParamServlet() {
		System.out.println("InitParamServlet이 호출되었습니다.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pw = config.getInitParameter("password");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>서블릿 초기 변수 설정</h3>");
		out.print("<p>ID: "+id+"</p>");
		out.print("<p>PassWord: "+pw+"</p>");
		out.close();
	}
}
