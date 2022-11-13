package com.hy.mapper;

import com.hy.model.MemberVO;

public interface MemberMapper {
	
	// 회원가입
	public void memberJoin(MemberVO member);
	// 아이디 중복체크
	public int idCheck(String memberId);
	// 로그인
	public MemberVO memberLogin(MemberVO member);
	
}
