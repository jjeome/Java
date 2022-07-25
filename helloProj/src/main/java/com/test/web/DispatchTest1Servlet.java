package com.test.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatch1")

public class DispatchTest1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		//확인용으로
		resp.getWriter().print("<h3>Dispatch page 1</h3>");
		
		//파라미터로 받은 값들을 변수에 저장
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publi = req.getParameter("publish");
		
		//이 요청정보를 가지고 있는 객체에 param이라는 attribute에 사용자가 가지고있는 title주소값 넘겨줌
		req.setAttribute("param1", title);
		req.setAttribute("param2", author);
		req.setAttribute("param3", publi);
		
		
		//값을 가져올 때 ServletContext의 getRequestDispatcher메소드 사용
		//()안에는 forwarding할 페이지 적어주면 됨
		//disptatch2 페이지에 attrbute가 참조.
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dispatch2");
		//dispatch1을 가져와서 dispatch2로 요청 재지정 
		//forward와 include 번갈아가면서 사용해보기
		rd.forward(req, resp);
		
	}
}
