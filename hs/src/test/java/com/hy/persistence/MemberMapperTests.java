package com.hy.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hy.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper mapper;
	
	// 아이디 중복검사
		@Test
		public void memberIdChk() throws Exception{
			String id = "admin";	// 존재하는 아이디
			String id2 = "test123";	// 존재하지 않는 아이디
			mapper.idCheck(id);
			mapper.idCheck(id2);
		}
}
