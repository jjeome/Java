package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//추상 메소드
	public void execute(HttpServletRequest req, HttpServletResponse resp );
}
