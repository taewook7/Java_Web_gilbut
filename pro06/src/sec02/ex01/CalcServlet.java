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
		System.out.println("�̴ָ޼ҵ�");
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter	pw=response.getWriter();
		String command=request.getParameter("command"); //������ ��û�� �޾ƿɴϴ�.
		String won=request.getParameter("won"); // ��ȯ�� ��ȭ�� �޾ƿɴϴ�. 
		String operator=request.getParameter("operator"); //��ȯ�� ��ȭ������ �޾ƿɴϴ�. 
		
		if(command !=null && command.equals("calculate"))
		{
			String result= calculate(Float.parseFloat(won),operator);
			pw.print("<html><font size=10>��ȯ ���</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro06/calc'>ȯ�� ����</a>");
			return;
		}
//���� ��û�� command�� null �̸� ���� ȭ���� ����ϰ� command���� calculate �̸� ������� ����մϴ�. 
		pw.print("<html><title>ȯ�� ����</title>");
		pw.print("<font size=5>ȯ�� ����</font><br>");
		pw.print("<form name='frmCalc' method='get' aciton='/pro06/calc' /> ");
		pw.print("��ȭ: <input type='text' name='won' size=10 />");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>�޷�</option>");
		pw.print("<option value='en'>��ȭ</option>");
		pw.print("<option value='wian'>����</option>");
		pw.print("<option value='pound'>�Ŀ��</option>");
		pw.print("<option value='euro'>����</option>");
		pw.print("</select>");	
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.println("<input type='submit' value='��ȯ' />");
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
