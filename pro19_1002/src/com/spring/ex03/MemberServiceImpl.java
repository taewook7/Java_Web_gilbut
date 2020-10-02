package com.spring.ex03;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO1;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO1 = memberDAO;
	}



	@Override
	public void listMembers() {
		memberDAO1.listMembers();
	}
}
