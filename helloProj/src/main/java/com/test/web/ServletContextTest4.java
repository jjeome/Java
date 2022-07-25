package com.test.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.ShareObject;

//context4: context3의 값을 가져오는역할
@WebServlet("/context4")
public class ServletContextTest4 extends HttpServlet{
	//접근(어플리케이션이 만들어질때마다)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//화면 context타입 
		resp.setContentType("text/html; charset=utf-8");
		
		//객체를 하나 가져와 sc에 담기
		ServletContext sc = this.getServletContext();
		
		//context3의 data주소값 가져오기
		//shareobject타입으로 casting
		//data라는 값을 attribute값으로 읽을 수 있음
		//원래 object타입으로 반환되기 때문에 shareobject로 캐스팅 일어남
		ShareObject obj1 = (ShareObject) sc.getAttribute("data");
		resp.getWriter().print("count: "+obj1.getCount()+", str: "+obj1.getStr());
	
		ShareObject obj2 = (ShareObject) sc.getAttribute("data2");
		resp.getWriter().print("count: "+obj2.getCount()+", str: "+obj2.getStr());
	}
}
