package sec03.ex02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("�̴ϸ޼ҵ�");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget�޼ҵ� ȣ��");
		doHandle(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("������Ʈȣ��");
		
		doHandle(request, response);
	
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String user_id=request.getParameter("user_id");
		System.out.println("doHandle �޼��� ȣ��");
		String user_pw=request.getParameter("user_pw");
		
		System.out.println("���̵�:"+user_id);
		System.out.println("��й�ȣ:"+user_pw);
	
	}
	
	public void destroy() {
		System.out.println("��Ʈ����");
	}
}






