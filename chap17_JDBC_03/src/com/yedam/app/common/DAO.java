package com.yedam.app.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//각각의 DAO에서 공통적으로 쓰임
public class DAO {
	// 상속이지만 자식클래스가 직접적으로 못건드리게 함
	private String jdbcDriver;
	private String oracleUrl;
	private String connectedId;
	private String connectedPwd;

	// 상속하는 클래스가 접근하게 해줘야해서 protected
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	public void connect() {
		dbConfig();
		// 필드에 정보를 넣어 그걸 넘겨주는 방식
		try {
			// 1.JDBC Driver 로딩
			Class.forName(jdbcDriver);
			// 2.DB 서버 접속
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

//dao oracle 연결 정보를 properites에 저장해둔 것 불러오기
	private void dbConfig() {
		String resource = "config/db.properties"; // 실제 물리적인 위치가 아님
		Properties properties = new Properties();

		try {
			// properties의 파일위ㅣ를 정확히 알거나 결과가 변동이 생길 때 사용해야함(classloader로 경로 찾아야함)
			// 현재 실행되는 클래스 정보를 끌어올리는 것
			// 물리적인 파일 위치 가지고 옴
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			// key와 value만 가지고 있으면 알아서
			properties.load(new FileInputStream(filePath));// key와 value를 구성한 인스턴스 만드는것
		} catch (IOException e) {
			e.printStackTrace();
		}
		// properties에 있는 key값들 넘겨받기
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}