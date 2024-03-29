package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.MemberService;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;
import co.edu.vo.Page;

public class BoardListPagingControll implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		
		Criteria cri = new Criteria();
		cri.setPageNum(Integer.parseInt(pageNum));
		cri.setAmount(Integer.parseInt(amount));
		
		//페이징 처리된 리스트 출력
		//서비스 -> DAO 구현
		BoardService service = BoardService.getInstance();
		List<BoardVO> pagesList = service.getListPaging(cri);
		System.out.println(pagesList.size());
		
		req.setAttribute("boardList", pagesList);
		
		List<BoardVO> totalList = service.boardList();
		int total = totalList.size();
		req.setAttribute("pageInfo", new Page(cri, total));
		
		HttpUtil.forward(req, resp, "board/boardList.tiles");
		
	}

}
