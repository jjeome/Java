package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = MemberService.getInstance();
		//파라미터 읽어들이기
				String id = req.getParameter("id");
				String pw = req.getParameter("passwd");
				String name = req.getParameter("name");
				String mail = req.getParameter("mail");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setName(name);
				vo.setPasswd(pw);
				vo.setMail(mail);
				
				//한 건 입력 완료
				service.addMember(vo);
				
				//요청정보의 요청처리 결과를 view페이지에 전송
				req.setAttribute("member", vo);
				//아래와 같음
				Utils.forward(req, resp, "memberResult/memberInsertOutput.jsp");
				
				
//				//처리된 결과를 보여주는 페이지
//				RequestDispatcher rd = req.getRequestDispatcher("memberResult/memberInsertOutput.jsp");
//
//				//처리된 결과가 rd의 페이지를 보여줌
//				try {
//					rd.forward(req, resp);
//				} catch (Exception e) {
//					e.printStackTrace();
//				} 
	}

}
