package com.yedam.java.dept;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DeptDAO {

	private static DeptDAO deptDAO = null;
	private DeptDAO() {}
	
	public static DeptDAO getInstance() {
		if(deptDAO == null) {
			deptDAO = new DeptDAO();
		}
		return deptDAO;
	}
	
	//DAO-Oracle 연결정보
	String jdbcDriver;
	String oracleUrl;
	String connectedId;
	String connectedPwd;
	
	//공통적으로 사용하는 필드
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//메소드 1
	public void connect() {
		dbConfig();
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch(SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}
	
	public void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		
		try {
			String filepath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filepath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");

	}
	
	//전체조회
	public List<Departments> selectAll() {
		List<Departments> list = new ArrayList<>();
		
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM departments ORDER BY Department_id");
			while(rs.next()) {
				Departments dept = new Departments();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//단건 조회
	public Departments selectOne(int departmentId) {
		Departments dept = null;
		
		try {
			connect();
			String sql = "SELECT * FROM departments WHERE department_id ="+departmentId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
			dept = new Departments();
			dept.setDepartmentId(rs.getInt("department_id"));
			dept.setDepartmentName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dept;
	}
	//등록
	public void insert(Departments dept) {
		try {
			connect();
			String sql = "INSERT INTO departments VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getManagerId());
			pstmt.setInt(4, dept.getLocationId());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("등록이 완료되었습니다.");
			} else {
				System.out.println("등록되지 않았습니다.");
			}
			System.out.println(result+"건이 완료되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//수정
	public void update(Departments dept) {
		try {
			connect();
			String sql = "UPDATE departments SET department_name = ? WHERE department_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setInt(2,dept.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("수정되지 않았습니다.");
			}
			
			System.out.println(result+"건이 완료되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(int departmentId) {
		try {
			connect();
			String sql = "DELETE FROM departments WHERE department_id= "+departmentId;
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//자원해제
	public void disconnect() {
		try { 
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}































