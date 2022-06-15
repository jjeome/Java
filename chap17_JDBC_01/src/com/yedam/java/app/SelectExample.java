package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws Exception {
		//1.JDBC Driver 로딩하기
		//로딩하고자 하는 드라이버 풀네임 복붙하기 -> 라이브러리에있던 정보를 메로리로 끌어오는 것
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		//2.DB 서버 접속하기
		//DB의 정보를 기반으로 connection 만든것
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		//connection을 꺼내오려면 db에대한 정보 넘겨주기
		//connection 클래스로 정보 받기
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		//3.Statement or PreparesdStatement 객체 생성 
		//connection이없으면 의미가없음 :statement로 정보 가져오기
		Statement stmt = con.createStatement();
		
		//4.Query 구성 -> DB에 전달할 정보 짜기
		//온전히 구성된 문장을 요구함 -> insert할 때는 쓰면 힘들어짐
		//String sql = "SELECT * FROM employees WHERE last_name = 'King'"; ->문자라는걸 따옴표로 넣어줘야함
		//세미콜론 붙이지 않음
		//String sql = "SELECT first_name, last_name FROM employees"; //순서대로 써준후 
		String sql = "SELECT * FROM employees";
		
		//5.Query 실행
		//최종적으로 실행하고자 하는 sql문을 넘겨주고 resultSet으로 리턴값 받기
		//그 sql문을 DB에 전달후 결과 ResultSet으로 받음
		ResultSet rs = stmt.executeQuery(sql); 
		
		//6.결과값 출력하기
		//총 크기를 모르니까 while문 돌리고. 처음부터 끝까지 돌려야하니까 next()로 하나씩 돌리기
		//돌릴 것이 없으면 false로 바껴 반복문 종료됨
		while(rs.next()) {
			//get : 1.매개변수로 컬럼명 그대로 쓰기 2.반환하는 타입 써 줘야함
			String name = rs.getString("first_name")+ " " + rs.getString("last_name");
			//String name = rs.getString(1)+ " " + rs.getString(2);//순서써준 것을 숫자로 넣어주면 됨
			System.out.println(name);
		}
		
		//7.(사용한)자원 해제하기 - 해제 순서는 생성된 순서와 정반대로.
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
