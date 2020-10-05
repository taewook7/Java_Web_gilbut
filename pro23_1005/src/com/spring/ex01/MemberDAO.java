package com.spring.ex01;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper=null;
	public static SqlSessionFactory getInstance() {
		if (sqlMapper==null) {
			try {
				// MemberDAO의 각 메서드 호출시 src/mybatis/sqlmapconfig.xml 에서 설정 정보를 읽은 후
				// 데이터베이스와의 연동 준비를 합니다.
				String resource="mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper=new SqlSessionFactoryBuilder().build(reader);
				reader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public List<HashMap<String, String>> selectAllMemberList(){
		sqlMapper=getInstance();
		
		// 실제 member.xml 의 SQL문을 호출하는 데 사용되는 sqlsession 객체를 가져옵니다.
		SqlSession session=sqlMapper.openSession();
//		List<MemberVO> memlist=null;
		List<HashMap<String,String>> memlist=null;
		
		// 여러개의 레코드를 조회하므로 selectList() 메서드에 실행하고자하는 SQL문의 id를 인자로 전달합니다.
		memlist=session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
}
