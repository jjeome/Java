package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
				String id = req.getParameter("id");
		
				
				MemberVO vo = new MemberVO(); 
				vo.setId(id);
			
				//서비스 instance 가져오기
				MemberService service = MemberService.getInstance();
				service.throwMember(vo);
				
				// 공유 : vo
				req.setAttribute("id", vo);
				
				//처리된 결과를 페이지로 넘기기
				Utils.forward(req, resp, "memberResult/memberDeleteOutput.jsp");
	}

}
