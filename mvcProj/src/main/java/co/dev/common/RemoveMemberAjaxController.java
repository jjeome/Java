package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class RemoveMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//삭제처리 -> JSON 타입으로 반환
		String id = req.getParameter("id");
		resp.setContentType("text/json; charset=utf-8");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		
		MemberService service = MemberService.getInstance();
		boolean isDeleted = service.throwMember(vo);
	
		
		try {
			if(isDeleted) {
				resp.getWriter().print("{\"retCode\": \"Success\"}");				
			} else {
				resp.getWriter().print("{\"retCode\": \"Fail\"}");	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
