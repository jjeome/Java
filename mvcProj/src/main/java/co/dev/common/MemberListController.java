package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = MemberService.getInstance();
		
		//List를 보여줌
		req.setAttribute("list", service.memberList());
		Utils.forward(req, resp, "memberResult/memberListOutput.jsp");
	}
}
		
		//처리된 결과를 보여주는 페이지(요청재지정) - 'list'를 담아서
//		RequestDispatcher rd = req.getRequestDispatcher("memberResult/memberListOutput.jsp");
//
//		//처리된 결과가 rd의 페이지를 보여줌
//		try {
//			rd.forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//	}

//}
