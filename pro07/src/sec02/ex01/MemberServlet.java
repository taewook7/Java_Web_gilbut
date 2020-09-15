package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		MemberDAO dao = new MemberDAO();  // SQL������ ��ȸ�� MemberDAO ��ü�� �����մϴ�. 
		List list=dao.listmembers();  // listMembers() �޼���� ȸ�� ������ ��ȸ�մϴ�.
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td></tr>");
		
		for(int i=0; i<list.size(); i++) 
		{
			MemberVO memberVO = (MemberVO) list.get(i); //��ȸ�� ȸ�� ������ for���� <tr>�±׸� �̿��� ����Ʈ�� ����մϴ�.
			String id=memberVO.getId();
			String pwd=memberVO.getPwd();
			String name=memberVO.getName();
			String email=memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td></tr>");
		}
		
		out.print("</table></body></html>");
	}



}
