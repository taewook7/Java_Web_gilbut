package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		String user_address=request.getParameter("user_address");
		String user_hp=request.getParameter("user_hp");
		String user_email=request.getParameter("user_email");
		
		String data="안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data+="<html><body>";
		data+="아이디 : "+user_id;
		data+="<br>";
		data+="비밀번호 : "+user_pw;
		data+="<br>";

		data+="주소 : "+user_address;
		data+="<br>";

		data+="이메일 : "+user_email;
		data+="<br>";

		data+="휴대 전화 : "+user_hp;
		data+="<br>";
		out.print(data);
		}
	public void destroy() {
		System.out.println("디스트로이 호출");
	}

}
