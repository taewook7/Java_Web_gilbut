package sec01.ex02;

import java.sql.Date;

public class MemberVO {
	//값을 전달하는 데 사용되는 VO 클래스 입니다. DTO 라고도함 . 테이블에서 조회한 레코드의 컬럼값을 속성에 저장해야 하므로 컬럼 이름과 동일한 자료형과 이름으로 
	// 속성을 선언하고 getter/setter 를 각각 생성합니다. 
	
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVO() {
		System.out.println("Member VO 생성자 호출");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
    
	
}
