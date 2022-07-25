package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.Employee;

@WebServlet("/empResult")
public class EmpResultServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");
		
		//req정보에 : list 주소값 참조되고 있음(EmpSearchServlet에서)
		//list 주소값 담고있음
		List<Employee> list = (List<Employee>) req.getAttribute("data");
		
		PrintWriter out = resp.getWriter();
		for(Employee emp : list) {
			out.print("<br>사원 번호 : " + emp.getEmployeeId()+"사원 이름 : "+emp.getFirstName()+", 이메일 : "+emp.getEmail());
		}
		out.close();
	}
}
