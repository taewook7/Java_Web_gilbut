package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest3
 */
@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest3() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		out.print("세션 아이디: " + session.getId());
		out.print("세션 생성시간: "+new Date(session.getCreationTime()));
		out.print("세션 마지막 접근시간: " +new Date(session.getLastAccessedTime()));
		out.print("세션 유효시간 : "+session.getMaxInactiveInterval());
		if (session.isNew()) {
			out.print("새 세션이 만들어짐");
		}
		session.invalidate();  // invalidate() 를 호출하여 생성된 세션 객체를 강제로 삭제합니다. 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
