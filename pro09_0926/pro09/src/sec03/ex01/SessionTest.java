package sec03.ex01;

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
 * Servlet implementation class SessionTest
 */
@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SessionTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session= request.getSession();
		// getSsssion 메서드를 호출할때 인자가 없으면 세션객체를 새로생성하거나 기존세션을 반환합니다.
		out.println("세션 아이디: "+session.getId()+"<br>"); // 생성된 세션객체의 id를 얻습니다.
		out.println("최초 세션 생성 시각: "+new Date(session.getCreationTime())+"<br>");
		out.println("최근 세션 접근 시각: " + new Date(session.getLastAccessedTime())+"<br>");
		out.println("세션 유효 시간:"+session.getMaxInactiveInterval()+"<br>"); // 세션 유효시간 기본값 1800초 30분
		
		if (session.isNew()) {  // isnew는 세션이 새로 생성된건지 판단하는 메서드임.
			out.print("새 세션이 만들어졌네요");
			
		}
		
	// 이미만들어진 세션을 새 세션으로 다시하고싶을땐 크롬 시크릿모드로 다시 하면 된다. 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
