package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;


public class FrontController extends HttpServlet{
	String enc;
	//요청하는 url과 controller를 담아놓고 서비스에 따라 기능 실행
	Map<String, Controller> mappings;
	
	@Override
	//FrontController를 제일 처음 한 번 호출시에만 실행됨
	public void init(ServletConfig config) throws ServletException {
		//charset에 매핑되어져 있는 문자를 불러오겠다.(config의 getparameter를 사용해서)
		enc = config.getInitParameter("charset"); 
		
		//컨트롤러 등록
		mappings = new HashMap<>();
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberSearch.do", new MemberSearchController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberJson.do", new MemberJsonController());
		
		//ajax입력
		mappings.put("/addMemberAjax.do", new AddMemberAjaxControlloer());
		mappings.put("/removeMemberAjax.do", new RemoveMemberAjaxController());
	}
	
	@Override
	//호출 될때마다 실행됨
	//입력 요청 처리(DB입력) => view페이지로 페이지이동
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		
		//등록인지 목록인지 구별하기
		String uri = req.getRequestURI();
		//System.out.println(uri);
		//요청 정보가 가지고 있는 getContextpath메소드
		String contextPath = req.getContextPath();
		//System.out.println(contextPath);
		String path = uri.substring(contextPath.length());
		System.out.println(path);
		
		//return되는 타입이 control -> key값(=path)을 가져와서 execute를 실행
		Controller cntrl = mappings.get(path);
		cntrl.execute(req, resp);
		
	}
	
}



























