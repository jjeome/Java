package co.edu.common;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

public class MemberService {
	// 싱글톤
	private static MemberService instance = new MemberService();
	
	private MemberService() {
		
	}
	
	//인스턴스 얻기
	public static MemberService getInstance() {
		return instance;
	}
	
	MemberDAO dao = new MemberDAO();
	//입력 기능 삭제
	// 입력 기능
	//입력 처리 - 수정
	public void memberAdd(MemberVO vo) {
		dao.insertMember(vo);
	}
}
