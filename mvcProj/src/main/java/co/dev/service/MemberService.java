package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

//비즈니스를 처리하는 곳(복합적인 처리) ex.입력 수정/삭제
public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	//싱글톤 : MemberService를 한개로 만들어서 getinstance로 호출하면 사용할수 있게.
	private static MemberService instance = new MemberService();	
	private MemberService() {}
	public static MemberService getInstance() {
		return instance;
	}
	
	//회원가입
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	//회원 리스트
	public List<MemberVO> memberList(){
		return dao.getList();
	}

	
	//회원 조회
	public MemberVO getMember(String id) {
		return dao.searchMember(id);
	}
	
	//회원 수정
	public void modifyMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	
	//회원 삭제
	public boolean throwMember(MemberVO vo) {
		return dao.deleteMember(vo);
	}
}
