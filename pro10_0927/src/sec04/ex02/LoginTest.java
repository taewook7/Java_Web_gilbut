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
 * Servlet implementation class LoginTest
 */
@WebServlet("/login")
public class LoginTest extends HttpServlet {
	ServletContext context=null;
	List user_list=new ArrayList(); // 로그인한 접속자 ID를 저장하는 ArrayList 입니다.
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		context=getServletContext();
		HttpSession session=request.getSession();
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		LoginImpl loginUser=new LoginImpl(user_id,user_pw);
		
		//최초 로그인시 접속자수 ID를 ArrayList 에 차례로 저장한후 다시 context 객체에 속성으로 저장합니다.
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		out.println("<html><body>");
		out.println("아이디는 "+loginUser.user_id+"<br>");
		out.println("총 접속자수는:"+LoginImpl.total_user+"<br><br>");  // 세션에 바인딩 이벤트 처리후 총 접속자 수를 표시합니다.
		out.println(" 접속 아이디:<br>");
		List list=(ArrayList)context.getAttribute("user_list");  // context 객체의 ArrayList를 가져와 접속자 id를 차레로 브라우저로 출력한다.
		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i)+"<br>");
		}
		out.println("<a href='logout?user_id="+user_id+"'>로그아웃 </a>");
		out.println("</body></html>");
	}
}
