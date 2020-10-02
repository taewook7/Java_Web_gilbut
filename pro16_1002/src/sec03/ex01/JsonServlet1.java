package sec03.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * Servlet implementation class JsonServlet1
 */
@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonServlet1() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
// 먼저 Ajax 로 전달된 JSON 문자열을 getParameter() 메서드를 이용해 가져옵니다.
// 그런다음 JSONParser 클래스의 parse() 메서드를 이용해 JSONObject 를 가져오고 JSON데이터의 name 속성으로 value를 출력한다.
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String jsonInfo = request.getParameter("jsonInfo");
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
			System.out.println("* 회원 정보*");
			System.out.println(jsonObject.get("name"));
			System.out.println(jsonObject.get("age"));
			System.out.println(jsonObject.get("gender"));
			System.out.println(jsonObject.get("nickname"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}








