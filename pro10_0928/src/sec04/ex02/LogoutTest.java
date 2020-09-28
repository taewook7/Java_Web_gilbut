package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutTest
 */
@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	ServletContext context;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutTest() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		context=getServletContext();
		HttpSession session=request.getSession();
		String user_id=request.getParameter("user_id");  // user_list 에서 삭제할 id를 가져옵니다.
		session.invalidate(); // 로그아웃시 세션을 소멸 시킨다.
		List user_list=(ArrayList)context.getAttribute("user_list");
		user_list.remove(user_id);
		context.removeAttribute("user_list");
		context.setAttribute("user_list", user_list); // user_list에서 로그아웃한 접속자 ID를 삭제한후 다시 user_list를 컨텍스트에 저장한다.
		out.println("<br>로그아웃햇습니다.");
		
	}
	
	
	
}
