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
import javax.servlet.http.HttpSession;

import dto.memberDto;
import service.loginSvc;

@WebServlet("/login")
public class loginCtrl extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private loginSvc lsvc = null;
	private memberDto mdto = new memberDto();
	
	@Override
	protected void doGet(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();		

		// 파라메터 처리
		// req.getParameter("name");
		String id = req.getParameter("userId");		
		String pw = req.getParameter("userPassword");
		
		// 로그인 세션 객체 생성
		if(session.isNew() || session.getAttribute("userId") == null) {
			session.setAttribute("userId", id);			
			System.out.println(session.getAttribute("userId"));
		}
		
		// 서비스 호출
		lsvc = new loginSvc();
		int loginResult = 0;
		if (id != null && !id.isEmpty()) {  // id값이 입력된 경우 로그인 메소드 실행
			loginResult = lsvc.login(id, pw);
		}
		List<Integer> loginRes = new ArrayList<>();
		loginRes.add(loginResult);
		
		
		// 웹브라우저 데이터 전송
		// Step 0: 데이터 추가
		req.setAttribute("loginRes", loginRes);
		// Step 1: 리퀘스트 디스패처(request dispatcher) 얻기
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/WEB-INF/view/loginView.jsp");
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
