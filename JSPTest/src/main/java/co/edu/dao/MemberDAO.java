package co.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.edu.vo.MemberVO;

public class MemberDAO {
	//Oracle DB 정보
			private String jdbcDriver="oracle.jdbc.driver.OracleDriver";
			private String oracleUrl="jdbc:oracle:thin:@localhost:1521:xe";
			private String connectedId="hr";
			private String connectedPwd="hr";
			
			//공통으로 사용되는 필드 
			protected Connection conn;
			protected Statement stmt;
			protected PreparedStatement pstmt;
			protected ResultSet rs;

			
			//DB에 접속하는 메소드
			public void connect() {
				try {
					Class.forName(jdbcDriver);
					//jdbcDriver 로딩
					conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
				}catch(ClassNotFoundException e) {
					System.out.println("jdbc driver 로딩 실패");
				}catch(SQLException e) {
					System.out.println("DB 연결 실패");
				}
				
			}
			
			//DB 접속을 해제하는 메소드 
			public void disconnect() {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
					//null일때 close하면 nullpointexception 발생 
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			//회원가입
			public void registerIn(MemberVO vo) {
				String sql = "INSERT INTO test_member(id, passwd, name, address)"
						+ "VALUES(?, ?, ?, ?)";
				connect();
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, vo.getId());
					pstmt.setString(2, vo.getPasswd());
					pstmt.setString(3, vo.getName());
					pstmt.setString(4, vo.getAddress());
					
					int result = pstmt.executeUpdate();
					
					if(result >0) {
						System.out.println(result+"건 입력");
					} else {
						System.out.println("등록 실패");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					disconnect();
				}
			}
			
}
















