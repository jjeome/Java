package com.test.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.ShareObject;

//context3:값을 지정
//context3를 먼저 실행 후 context4를 실행해야 함 -> 값을 지정해주는 작업이 먼저 실행되야 하기 때문
@WebServlet("/context3")
public class ServletContextTest3  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//어플리케이션이 만들어질때마다 만들어지는 객체
		ServletContext sc = this.getServletContext();//Servletcontext 호출
		
		//shareobject타입 -> servletcontext로 지정
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("객체 공유 테스트");

		//또다른 객체를 공유하는 것도 가능함 (굳이 shareObject타입 아니여도 됨)
		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트2");
		
		//서블릿컨텟트스에 값을 지정하는 메소드
		//data라는 이름으로 서블릿컨텍스트에 obj1과 obj2를 공유
		//구조 : servletconetext객체.setAttribute("name", "value")
		sc.setAttribute("data", obj1); 
		sc.setAttribute("data2", obj2); //이 데이터를 참조하는 애:getAttribute
		
		resp.getWriter().print("ServletContext object add.");
	}
}
