package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	//단건 조회
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터 값으로 결과값 조회함
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		
		//파라미터를 id와 job둘을 받음 
		// id 받으면 -> search / job받으면 -> update
		if(id.isEmpty()) {
			//만약 아이디가 없으면 보여줄 페이지 지정
			req.setAttribute("error", "id를 입력하세요");
			if(job.equals("search")) {
				//여기로 보내겠다.
				Utils.forward(req, resp, "memberView/memberSearch.jsp");				
			} else if(job.equals("update")) {
				Utils.forward(req, resp, "memberView/memberUpdate.jsp");
			} else if(job.equals("delete")) {
				Utils.forward(req, resp, "memberView/memberDelete.jsp");
			}
			return;
		}
		
		MemberService service = MemberService.getInstance();
		MemberVO vo = service.getMember(id);
		if(vo == null) {
			req.setAttribute("result", "검색된 정보가 없습니다.");
		}
		
		//id를 받아서 member에 담
		req.setAttribute("member", vo);
		
		
		if(job.equals("search")) {
			Utils.forward(req, resp, "memberResult/memberSearchOutput.jsp");
		} else if(job.equals("update")) {
			Utils.forward(req, resp, "memberView/memberUpdate.jsp");
		} else if(job.equals("delete")) {
			Utils.forward(req, resp, "memberView/memberDelete.jsp");
		}
		
		
		
	}
}		
		//		try {
//			//요청정보를 가지고 이 페이지로 forwarding 하는 것
//			req.getRequestDispatcher("memberResult/memberSearchOutput.jsp").forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		
//	}

