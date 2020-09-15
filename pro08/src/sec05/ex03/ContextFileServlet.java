package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextFileServlet
 */
@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt"); // 해당 위치의 파일을 읽어 들입니다. 
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		// getResourceAsStream() 메서드에서 읽어 들일 파일 위치를 지정한 후 파일에서 데이터를 입력 받습니다.
	
		String menu=null;
		String menu_member=null;
		String menu_order=null;
		String menu_goods=null;
		while( (menu=buffer.readLine()) !=null    ) {
			StringTokenizer tokens=new StringTokenizer(menu, ",");
			menu_member=tokens.nextToken();
			menu_order=tokens.nextToken();
			menu_goods=tokens.nextToken();
		}
		out.print("<html><body>");
		out.print(menu_member+"<br>");
		out.print(menu_order+"<br>");
		out.print(menu_goods+"<br>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
