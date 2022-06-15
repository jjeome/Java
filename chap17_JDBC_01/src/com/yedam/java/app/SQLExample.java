package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLExample {

	public static void main(String[] args) throws Exception {
		//1.JDBC Driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");//기본적으로 exception처리 필요함
		
		//2.DB Server 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection con = DriverManager.getConnection(url,id,pwd);
		//--------------------DB와 연결 끝-----------------------
		
		//3.CRUD 실행
		//각각의 sql문들 반복
		/********************* INSERT ***********************/
		//-1. Statement or PrepareStatement 객체 생성하기(전달하려는)
		//PrepareStatement는 ? ->  변수취급 (문자나 숫자 구분 안해줘도 됨) 항상 물음표를 쓸 필요는 없음
		String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insert);
		//-2. SQL 구성 후 실행
		//set메소드를 통해 넘겨받은 sql안에 ?의 값을 대체시킴
		//employees 테이블 안의 순서대로 type에 맞게 써줘야함
		// -> 만들때 넣어둔 sql에 들어간 물음표 수 만큼 set메소드도 적어줘야함 (아래 ?11개 그럼 set메소드도 11개)
		pstmt.setInt(1, 1000); //insert sql문안에 int타입인 1000으로 첫번재 물음표를 대체한다는 뜻(타입(몇번째,값))
		pstmt.setString(2, "Kil-Dong");
		pstmt.setString(3, "Hong");
		pstmt.setString(4, "kdHong@google.com");
		pstmt.setString(5, "82.10.1234.1234");
		pstmt.setString(6, "21/11/05");
		pstmt.setString(7, "SA_REP");
		pstmt.setInt(8, 6000);
		pstmt.setDouble(9, 0.15);
		pstmt.setInt(10, 149);
		pstmt.setInt(11, 80);
		//-3. 결과 출력
		//insert,update,delete등 값 자체가 변경될 때는 executeUpdate사용
		int result = pstmt.executeUpdate(); 
		System.out.println("insert 실행 결과 : "+result);
		
		/********************* UPDATE ***********************/
		//-1. Statement or PrepareStatement 객체 생성하기(전달하려는)
		//drop이랑 table명에는 물음표 x -> 값으로 들어가는 위치에 물음표 사용 가능
		//컬럼명이랑 테이블명을 바꿀땐 Statement사용 -> 새로 문장만 구현해주면 됨
		//String temp = "UPDATE"+tables+"SET"+column+"="; -> 값자체만 다룰땐 이렇게 써주면됨
		String update = "UPDATE employees SET last_name = ? WHERE employee_id = ?";
		pstmt = con.prepareStatement(update);
		//-2. SQL 구성 후 실행
		pstmt.setString(1,"Kang"); //set 물음표 순서대로 안해도됨 -매개변수로 위치를 알려주기 때문에
		pstmt.setInt(2, 1000);
		//-3. 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("UPDATE 실행 결과 : "+result);
		
		/********************* SELECT ***********************/
		//-1. Statement or PrepareStatement 객체 생성하기(전달하려는)
		String select = "SELECT * FROM employees ORDER BY employee_id";
		pstmt = con.prepareStatement(select);
		//-2. SQL 구성 후 실행
		ResultSet rs = pstmt.executeQuery();
		//-3. 결과 출력
		while(rs.next()) {
			String info = rs.getInt("employee_id")+" : "+rs.getString("first_name");
			System.out.println(info);
		}
		
		/********************* DELETE ***********************/
		//-1. Statement or PrepareStatement 객체 생성하기(전달하려는)
		//입력한 걸 삭제한다고 생각하기, WHERE절 안적으면 다 삭제됨 주의!
		String delete = "DELETE FROM employees WHERE employee_id = ?"; 
		pstmt = con.prepareStatement(delete);
		//-2. SQL 구성 후 실행
		pstmt.setInt(1, 1000);
		//-3. 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("delete 결과 : "+result);
		//4.자원 해제 하기
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}

}
