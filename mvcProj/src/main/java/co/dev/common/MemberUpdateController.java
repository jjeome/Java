package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.UIClientPropertyKey;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

//수정 컨트롤
public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터로 받아오는 값 변수에 저장
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		//MemberVO타입으로 값 담기
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pw);
		vo.setMail(mail);
		vo.setName(name);
		
		//서비스 instance 가져오기
		MemberService service = MemberService.getInstance();
		service.modifyMember(vo);
		
		// 공유 : vo
		req.setAttribute("member", vo);
		
		//처리된 결과를 페이지로 넘기기
		Utils.forward(req, resp, "memberResult/memberUpdateOutput.jsp");
	}

}
