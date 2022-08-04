package co.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.dev.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public void connect() {
		//connectino pool의 정보를 가져오기 위한 객체
		try {
			//resource를 가져옴
			InitialContext ic = new InitialContext();
			//tomcat이면 java:comp/env/jdbc/myoracle로 쓰기
			//jdbc/myoracle로 만들어준 리소스 가져옴
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			// Exception : 모든 예외를 처리함
			e.printStackTrace();
		} 
		
	}
	
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			//null일때 close하면 nullpointexception 발생 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//입력 처리 메소드
	public void insertMember(MemberVO vo) {
		String sql = "INSERT INTO member(id, name, passwd, mail) "
				+ "VALUES(?,?,?,?)";
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getMail());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
	}
	
	//전체조회
	public List<MemberVO> getList(){
		String sql = "SELECT * FROM member ORDER BY 1";
		List<MemberVO> list = new ArrayList<>();
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setMail(rs.getString("mail"));
				vo.setName(rs.getString("name"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//단건조회
	public MemberVO searchMember(String id) {
		String sql = "SELECT * FROM member WHERE id=?";
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setMail(rs.getString("mail"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	//정보 수정
	public void updateMember(MemberVO vo) {
		String sql="UPDATE member SET name = ? "
				+ "                  ,passwd = ? "
				+ "                  ,mail = ? "
				+ "WHERE id = ?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getMail());
			pstmt.setString(4, vo.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 변경됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//정보 삭제
	public boolean deleteMember(MemberVO vo) {
		String sql="DELETE FROM member WHERE id = ? ";
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			int r = pstmt.executeUpdate();
			if(r==1) {
				System.out.println(r+"건 삭제됨");
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

}

























