package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "JSP";
	private static final String pwd = "gusxo11";
	private Connection con;
	private PreparedStatement pstmt;


	public List listmembers() {
		List list=new ArrayList();
		try {
			connDB();
			
			String query="select * from t_member";
			System.out.println("prepareStatement: " +query);
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			
			while (rs.next())
			{
				String id=rs.getString("id");
				String pwd=rs.getString("pwd");
				String name=rs.getString("name");
				String email=rs.getString("email");
				Date joinDate=rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				vo.setName(name);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle ����̹� ���� ����");
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("connection ���� ����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
