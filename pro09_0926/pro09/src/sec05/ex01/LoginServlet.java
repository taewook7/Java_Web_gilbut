package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");  // 로그인 html 에서 전송된 id 와 비밀번호 pw 를 가져와서 user아이디,비번 변수에 저장 합니다.
		
		MemberVO memberVO = new MemberVO();   // 멤버 vo 객체를 생성하고 셋터를 사용해서 속성에 아이디와 비밀번호를 설정합니다. 
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);
		
		MemberDAO dao = new MemberDAO();
		boolean result=dao.isExisted(memberVO);
		
	}
}









