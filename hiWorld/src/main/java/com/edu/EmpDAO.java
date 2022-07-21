package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO{
	//변경 -> GET
	public int updateMember(String name, String pass, String role) {
		String sql = "update members"
					+" set member_password=?,"
					+" member_role = ?"
					+" where member_id = ?";
		connect();
		int r = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, role);
			pstmt.setString(3, name);
			System.out.println(r+"건 변경됨");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return r;
	}
	//user_name, user_pass, role -> 입력하는 기능 -> POST
	public int insertMember(String name, String pass, String role) {
		String sql = "insert into members values(?,?,?)";
		connect();
		int r = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, role);
			//insert,update,delete
			System.out.println(r+"건 입력됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}
	

	public List<Employee> getEmpInfo(String name) {
		String sql = "select * from employees where employee_id=?";
		connect();
		List<Employee> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public List<Employee> getEmpList(){
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setEmail(rs.getNString("email"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
