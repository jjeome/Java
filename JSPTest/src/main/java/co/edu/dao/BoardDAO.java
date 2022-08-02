package co.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardDAO {
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
	
	//게시판 글 등록
	public void inputWrite(BoardVO vo) {
		String sql = "INSERT INTO test_board VALUES(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+"건 입력");
			} else {
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public List<BoardVO> getList(){
		String sql="SELECT * from test_board";
		List<BoardVO> list = new ArrayList<>();
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getString("write_date"));
				vo.setVisitCnt(rs.getInt("visit_cnt"));
			
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//페이징 처리
	//amount : 보여주고 싶은 페이지 수
	//pageNum : 페이지 숫자
	public List<BoardVO> getListPaging(Criteria cri){
		List<BoardVO> listPage = new ArrayList<>();
		String sql = "select seq, title, content, writer, write_date, visit_cnt "
				+ "from (select rownum rn, seq, title, content, writer, write_date, visit_cnt "
				+ "    from(select seq, title, content, writer, write_date, visit_cnt "
				+ "        from test_board "
				+ "        order by seq) "
				+ "where rownum <=? ) "
				+ "where rn > ?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getAmount() * cri.getPageNum()); //10*2
			pstmt.setInt(2, cri.getAmount() * (cri.getPageNum()-1)); //10
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriteDate(rs.getString("write_date"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setVisitCnt(rs.getInt("visit_cnt"));
				
				listPage.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return listPage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
