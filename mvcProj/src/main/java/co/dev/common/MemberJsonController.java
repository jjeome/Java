package co.dev.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberJsonController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//[{"name":"Hong", "age":15}, {"name":"Yoon", "age":25}]
		//파일 형식 json타입으로 지정해준 것
		resp.setContentType("text/json;charset=utf-8");
		
		MemberService service = MemberService.getInstance();
		List<MemberVO> members = service.memberList();
		
		String json = "[{\"name\":\"Hong\", \"age\":15}, {\"name\":\"Yoon\", \"age\":25}]";
		
		//json형식의 데이터 만들기
		JsonArray jary = new JsonArray();
		
		for(MemberVO vo : members) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("id", vo.getId());
			jobj.addProperty("name", vo.getName());
			jobj.addProperty("mail", vo.getMail());
			jobj.addProperty("passwd", vo.getPasswd());
			
			//jary 추가
			jary.add(jobj);
		}
		
		JsonObject jobj = new JsonObject();
		jobj.addProperty("id", "null");
		
		
		try {
			resp.getWriter().print(jary);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
