package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest4
 */
//@WebServlet("/login")
public class SessionTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTest4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session= request.getSession();
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
//		 로그인 창에서 전송된 ID와 비밀번호를 가져옵니다.
		
//		아래는 최초 요청시 수행하는 코드
		if (session.isNew()) {    // 세션이 존재한다면 또는 없다면 새로 생성하고 
			if (user_id != null) {   // user id 가 널이 아니라면 
				session.setAttribute("user_id", user_id);   // user_id 로  사용자 id 를 바인딩 한다.
				out.print("<a href='login'>로그인 상태 확인</a>");  
			} else {
				out.print("<a href='login2.html'>다시 로그인 하세요</a>");
				session.invalidate();   // 세션 삭제
			}
		} else {
			user_id=(String) session.getAttribute("user_id");
			if(user_id!=null && user_id.length() !=0) {
				out.print("안녕하세요 " + user_id + "님!!");
				
			} else {
				out.print("<a href='login2.html'> 다시 로그인 하세요.!!,</a>");
				session.invalidate();
			}
		}

	}

	
}










