package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.productDto;
import service.productSvc;

@WebServlet("/product")
public class productCtrl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private productSvc psvc = null;
	private productDto pdto = new productDto();
	
	@Override
	protected void doGet(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession(false);
		if(session != null) {			
			System.out.println("로그인 상태 입니다.");
		} else {
			System.out.println("로그인 상태가 아닙니다.");
		}
			
		// 파라메터 처리
		// req.getParameter("name");
		String word = req.getParameter("search");		
		
		// 서비스 호출
		psvc = new productSvc();
		List<productDto> pList = psvc.printList();
		List<productDto> sWord = null;

		if (word != null && !word.isEmpty()) {
		    sWord = psvc.search(word);
		}
		// 웹브라우저 데이터 전송

		// Step 0: 데이터 추가
		
		req.setAttribute("productList", pList);
		req.setAttribute("searchList", sWord);
		// Step 1: 리퀘스트 디스패처(request dispatcher) 얻기
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/WEB-INF/view/productView.jsp");
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
