package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
//@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("�̴�");
	}
	public void destroy() {
		System.out.println("��Ʈ����");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("sendRedirect �� �̿��� redirect �ǽ��Դϴ�.");
		out.println("</body></html>");
	}
}
