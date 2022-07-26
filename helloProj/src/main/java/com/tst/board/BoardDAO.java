package com.tst.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DAO;

public class BoardDAO extends DAO {

	//등록 - title content write만 넣어주기
	public void insertBoard(BoardVO vo) {
		String sql = "INSERT INTO  BOARD  VALUES((SELECT nvl(max(board_id), 0)+1 FROM board), ?, ?, ?, sysdate, 0)";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			int rs = pstmt.executeUpdate();
			
			System.out.println(rs + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	
	}
	
	//전체조회
	public List<BoardVO> bList(){
		//첫번째 칼럼을 기준으로 오름차순으로 정렬
		String sql = "SELECT * FROM board ORDER BY 1";
		List<BoardVO> list = new ArrayList<>();
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id"),
										 rs.getString("title"),
										 rs.getString("content"),
										 rs.getString("writer"),
										 rs.getString("create_date"),
										 rs.getInt("count"));
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
	public BoardVO getBoard(int boardNo) {
		String sql = "SELECT * FROM board WHERE board_id = ?";
		
		try {
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();
			
			//데이터가 있으면 if구문 실행
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(boardNo);
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("create_date"));
				vo.setCount(rs.getInt("count"));
				
				//카운트 증가
				setCount(boardNo);
				
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	//조회수
	public void setCount(int boardNo) {
		String sql="UPDATE board SET count=count+1 WHERE board_id=?";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();	
		}
	}
	
	public void updateBoard(BoardVO vo) {
		String sql ="UPDATE board SET title=?, content=? WHERE board_id=?";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());
			
			//쿼리 실행
			int rs = pstmt.executeUpdate();
			System.out.println(rs+"건 변경.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	//삭제
	public void deleteBoard(BoardVO vo) {
		String sql = "DELETE FROM board WHERE board_id=?";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBoardId());
			
			int rs = pstmt.executeUpdate();
			System.out.println(rs+"건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//로그인체크
	public UserVo loginCheck(String id, String pwd) {
		String sql = "SELECT * FROM users WHERE id=? AND password=?";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				UserVo vo = new UserVo();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("password"));
				vo.setName(rs.getString("name"));
				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		//조회된 결과가 없으면 null 반환
		return null;
	}
}

















