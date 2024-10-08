package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDto;
import service.joinSvc;

@WebServlet("/join")
public class joinCtrl extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private joinSvc jsvc = null;
	private memberDto mdto = new memberDto();
	
	@Override
	protected void doGet(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// 파라메터 처리
		// req.getParameter("name");
		String id = req.getParameter("userId");		
		String pw = req.getParameter("userPassword");
		String name = req.getParameter("userName");
		
		// 서비스 호출
		jsvc = new joinSvc();
		int join = 0;
		if(id != null && !id.isEmpty()) {
			join = jsvc.join(id, pw, name);
		}
		List<Integer> joinRes = new ArrayList<>();
		joinRes.add(join);
		
		// 웹브라우저 데이터 전송
		// Step 0: 데이터 추가
		req.setAttribute("joinRes", joinRes);
		// Step 1: 리퀘스트 디스패처(request dispatcher) 얻기
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/WEB-INF/view/joinView.jsp");
		// Step 2: JSP로 포워드(forward)
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
