package com.edu;

import java.util.List;

public interface MemberService {
	public void addMember(Member member); // 회원추가.
	public Member getMember(int mn); //멤버 1명 조회
	public void modifyMember(Member member); // 회원정보수정.
	public List<Member> memberList(); // 회원리스트.
}
