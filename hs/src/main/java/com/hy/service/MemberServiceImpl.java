package com.hy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.mapper.MemberMapper;
import com.hy.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper dao;
	
	@Override
	public void memberJoin(MemberVO member) throws Exception {
		dao.memberJoin(member);
	}

	@Override
	public int idCheck(String memberId) throws Exception {
		return dao.idCheck(memberId);
	}

	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		
		return dao.memberLogin(member);
	}

}
