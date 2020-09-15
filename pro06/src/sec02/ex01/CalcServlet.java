package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static float USD_RATE=1700.24f;
	private static float EUR_RATE;
	private static float GBP_RATE;
	private static float CNY_RATE;
	private static float JPY_RATE;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("이닛메소드");
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter	pw=response.getWriter();
		String command=request.getParameter("command"); //수행할 요청을 받아옵니다.
		String won=request.getParameter("won"); // 변환할 원화를 받아옵니다. 
		String operator=request.getParameter("operator"); //변환할 외화종류를 받아옵니다. 
		
		if(command !=null && command.equals("calculate"))
		{
			String result= calculate(Float.parseFloat(won),operator);
			pw.print("<html><font size=10>변환 결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro06/calc'>환율 계산기</a>");
			return;
		}
//최초 요청시 command가 null 이면 계산기 화면을 출력하고 command값이 calculate 이면 계산결과를 출력합니다. 
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' aciton='/pro06/calc' /> ");
		pw.print("원화: <input type='text' name='won' size=10 />");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");	
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.println("<input type='submit' value='변환' />");
		pw.println("</form");
		pw.println("</html>");
		pw.close();
	}

	private static String calculate(float won,String operator) {
		String result=null;
		if (operator.equals("dollar")) {
			result=String.format("%.6f", won / USD_RATE);
		} else if(operator.equals("en")) {
			result=String.format("%.6f", won / JPY_RATE);
		} else if(operator.equals("wian")) {
			result=String.format("%.6f", won / CNY_RATE);
		} else if(operator.equals("pound")) {
			result=String.format("%.6f", won / GBP_RATE);
		} else if(operator.equals("euro")) {
			result=String.format("%.6f", won / EUR_RATE);
		}
		return result;
	}

}
