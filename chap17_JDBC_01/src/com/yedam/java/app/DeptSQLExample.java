package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//부서에 대한 table로 jdbc
public class DeptSQLExample {

	public static void main(String[] args) throws Exception {
		try {
		//1. JDBC Driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB 서버 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		//3. CRUD 실행
		/*************** INSERT *****************/
		//-1. PreparedStatement 객체 생성
		String insert = "INSERT INTO departments VALUES(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insert);
		//-2. Query 구성
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "YEDAM");
		pstmt.setInt(3, 100);
		pstmt.setInt(4, 2500);
		//-3. 실행 후 결과 출력
		int result = pstmt.executeUpdate();//실행 반환하는 메소드
		System.out.println("insert 실행 결과 : "+result);
		
		/*************** UPDATE *****************/
		//-1. PreparedStatement 객체 생성
		String update = "UPDATE departments SET department_name = ? WHERE department_id = ?";
		pstmt = con.prepareStatement(update);
		//-2. Query 구성
		pstmt.setString(1, "JAVA");
		pstmt.setInt(2, 1000);
		//-3. 실행 후 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("update 실행 결과 : "+result);
		
		/*************** SELECT *****************/
		//-1. PreparedStatement 객체 생성
		String select = "SELECT * FROM departments ORDER BY department_id";
		pstmt = con.prepareStatement(select);
		//-2. Query 구성
		ResultSet rs = pstmt.executeQuery();
		//-3. 실행 후 결과 출력
		while(rs.next()) {
			String info = "부서번호 : "+rs.getInt("department_id")+", 부서 이름 : "+rs.getString("department_name");
			System.out.println(info);
		}
		/*************** DELETE *****************/
		//-1. PreparedStatement 객체 생성
		String delete = "DELETE FROM departments WHERE department_id = ?";
		pstmt = con.prepareStatement(delete);
		//-2. Query 구성
		pstmt.setInt(1,  1000);
		//-3. 실행 후 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("delete 실행 결과 : "+result);
		
		
		//4. 자원해제
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
		
		} catch (ClassNotFoundException e) {
			System.out.println("DB 서버 접속 실패");
		} catch(SQLException e) {
			System.out.println("Query 실행 실패");
			e.printStackTrace();
		} finally {
			//예외가 발생 했던 안했던 무조건 실행되어야 해서 finally에서 실행
		}
	}

}
