package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxControlloer implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = MemberService.getInstance();
		
		//회원 정보 등록 => json 값 반환
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
		
		//결과값 json으로 반환
		Gson gson = new GsonBuilder().create();
		try {
			//id, name, passwd, mail을 가져옴
			resp.getWriter().print(gson.toJson(vo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
