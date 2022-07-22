package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet {
	//service 구현 안할 때 doget-dopost 실행됨

	@Override 
	//get방식이 들어올때 실행
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		//id라는 파라미터의 값을 읽어서(getParameter) id값을 반환 
		String id = req.getParameter("id"); 
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		//값을 여러개 받으려면 배열 써야함.
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
		
		out.print("<h3>입력받은 값</h3>");
		out.print("<p>ID : "+id+"</p>");
		out.print("<p>PassWord : "+pwd+"</p>");
		out.print("<p>Name : "+name+"</p>");
		
		//배열로 값을 받아오는 거기 때문에 반복해서 요소를 하나씩 출력시켜야 함
		out.print("Hobby : <ul>");
		for(String hob : hobby) {
			out.print("<li>"+hob+"</li>");
		}
		
		out.print("</ul>");
		out.print("<p>Gender : "+gender+"</p>");
		out.print("<p>Religion : "+religion+"</p>");
		out.print("<p>Self-Introduction : "+introduction+"</p>");
		out.print("Information: "+req.getQueryString()); // queryString은 정보들 받아옴
		out.close();
	}
	 
	@Override
	//post방식이 들어올 때 실행
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보에 포함된 한글도 직접 인코딩 방법 지정 가능
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		//id라는 파라미터의 값을 읽어서(getParameter) id값을 반환 
//		String id = req.getParameter("id"); 
//		String pwd = req.getParameter("pwd");
//		String name = req.getParameter("name");
//		//값을 여러개 받으려면 배열 써야함.
//		String[] hobby = req.getParameterValues("hobby");
//		String gender = req.getParameter("gender");
//		String religion = req.getParameter("religion");
//		String introduction = req.getParameter("introduction");
//		
//		out.print("<h3>입력받은 값</h3>");
//		out.print("<p>ID : "+id+"</p>");
//		out.print("<p>PassWord : "+pwd+"</p>");
//		out.print("<p>Name : "+name+"</p>");
//		
//		//배열로 값을 받아오는 거기 때문에 반복해서 요소를 하나씩 출력시켜야 함
//		out.print("Hobby : <ul>");
//		for(String hob : hobby) {
//			out.print("<li>"+hob+"</li>");
//		}
//		
//		out.print("</ul>");
//		out.print("<p>Gender : "+gender+"</p>");
//		out.print("<p>Religion : "+religion+"</p>");
//		out.print("<p>Self-Introduction : "+introduction+"</p>");
		// queryString은 post방식에서 사용 어려움
		//out.print("Information: "+req.getQueryString()); 
		//post 방식에서만 ServletInputStream 사용가능
		ServletInputStream sis = req.getInputStream();
		int len = req.getContentLength();//데이터 크기
		byte[] buf = new byte[len];
		//contentLenth()에 readLinem으로 넘어온 buf에 처음부터 끝까지 담음
		sis.readLine(buf, 0, len); //buf의 처음부터 len의 크기만큼 읽어들임
		String queryString = new String(buf); //new 생성자로 byte형식 들어갈 수 있음
		out.print("<p id='querystring'>"+queryString+"</p>");
		sis.close();
		out.close();
	}
}
