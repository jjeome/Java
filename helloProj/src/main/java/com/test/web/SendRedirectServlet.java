package com.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendRedirect")
public class SendRedirectServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//html에서의 name이 getParameter 매개값으로 
		String param = req.getParameter("site");
		
		//요청정보를 가지고 넘길 수 있는 방법은 X
		//주소값만 들어가있음
		if(param.equals("naver")) {
			//이 페이지를 호출하는 페이지를 네이버로 다시 페이지 재지정
			resp.sendRedirect("http://www.naver.com");
		} else if(param.equals("daum")) {
			//이 페이지를 호출하는 페이지를 다음로 다시 페이지 재지정
			resp.sendRedirect("https://www.daum.net");
		} else if(param.equals("google")) {
			//이 페이지를 호출하는 페이지를 구글로 다시 페이지 재지정
			resp.sendRedirect("https://www.google.com");
		}
	}
	
	
}
