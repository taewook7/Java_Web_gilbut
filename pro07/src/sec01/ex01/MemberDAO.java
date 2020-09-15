package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	//회원정보 조회 SQL문을 실행하여 조회한 레코드들의 컬럼 값을 다시 memberVO 객체의 속성에 설정한 다음 ArrayList 에 저장하고 호출한 곳으로 반환합니다. 
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "JSP";
	private static final String pwd = "gusxo11";
	private Connection con;
	private Statement stmt;
	
	
	public List listMembers() {
		List list=new ArrayList();
		try
		{
			connDB();  // 4가지 정보로 데이터베이스에 연결합니다.
			String query = "select * from t_member ";
			System.out.println(query);
			ResultSet rs=stmt.executeQuery(query); //SQL문으로 회원정보를 조회합니다.
			while (rs.next())
			{
				String id=rs.getString("id");
				String pwd=rs.getString("pwd");
				String name=rs.getString("name");
				String email=rs.getString("email");
				Date joinDate=rs.getDate("joinDate");
				MemberVO vo=new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private void connDB()
	{
		try
		{
			Class.forName(driver);
			System.out.println("oracle 드라이버 로딩성공");
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("커넥션 생성 성공");
			stmt=con.createStatement();
			System.out.println("statement 생성 성공");
			
		} 	catch(Exception e) {
				e.printStackTrace();
		}
	}
}
