package com.tet.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ServletContextTest1 extends HttpServlet {
	//서블릿 객체의 환경파일에 키와 value값을 지정한 후 사용
	ServletContext sc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ServletConfig 객체
		//sc - 인스턴스가 만들어져있는 물리적인 공간
		sc = config.getServletContext();
		System.out.println(sc);		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loc = sc.getInitParameter("contextConfigLocation");
		resp.getWriter().print("Location: "+loc+"\n");//출력 스트림
		
		String con = sc.getInitParameter("contextConfig");
		resp.getWriter().print("Config: "+con);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//서블릿 컨텍스트에 저장되어있는 encoding방식을 담아서
		String enc = sc.getInitParameter("encoding");
		//그 방식을 사용함
		req.setCharacterEncoding(enc);
		resp.setCharacterEncoding(enc);
		resp.setContentType("text/plain; charset=utf-8");
		
		String name = req.getParameter("name");
		resp.getWriter().print("이름: "+name);
		
	}
}



















