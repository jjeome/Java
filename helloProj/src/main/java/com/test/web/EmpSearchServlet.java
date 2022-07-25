package com.test.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.EmpDAO;
import com.test.common.Employee;

@WebServlet("/empSearch")
public class EmpSearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fName = req.getParameter("first_name");
		
		EmpDAO dao = new EmpDAO();
		//반환값이 list형식 
		List<Employee> list = dao.getEmpInfo(fName);
	
		//data라는 이름으로 list주소값을 저장
		//list는 참조변수
		req.setAttribute("data", list);
		
		//요청정보가 가지고 있는 getRequestDispatcher메소드로도 정보 가져올 수 있음
		//empResult서블릿 호출
		//위의 data라는 list주소를 empResult에 넘김
		
		//JAVA
		//RequestDispatcher rd = req.getRequestDispatcher("empResult");
		
		//JSP
		RequestDispatcher rd = req.getRequestDispatcher("empResult.jsp");
		
		//forward 방식으로 요청과 응답 2개의 페이지. 
		rd.forward(req, resp);
	}
}
