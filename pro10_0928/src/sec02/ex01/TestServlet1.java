package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.GetAttribute;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/first/test")
// 정확히 이름까지 일치하는 url 패턴 
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String context=request.getContextPath();  // 컨텍스트 이름만 가져옵니다.
		String url=request.getRequestURL().toString();  // 전체 URL 을 가져옵니다.
		String mapping=request.getServletPath(); // 서블릿매핑 이름만 가져옵니다.
		String uri=request.getRequestURI(); // uri 를 가져옵니다. 
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet1</title></head><body bgcolor='green'>");
		out.println("<b>TestServlet1 입니다.</b><br>");
		out.print("컨텍스트 이름 :"+context+"</b><br>");
		out.println("전체 경로:"+url);
		out.println("매핑이름:"+mapping);
		out.println("uri:"+uri);
		
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
