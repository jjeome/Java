package co.edu.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.service.BoardService;
import oracle.net.aso.l;

public class CartUpdateControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = req.getParameter("num");
		String qty = req.getParameter("qty");
		
		BoardService service = BoardService.getInstance();
		service.updateCart(Integer.parseInt(num), Integer.parseInt(qty));
		
		resp.getWriter().print("success");
		
	}

}
