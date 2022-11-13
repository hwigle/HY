package com.hy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.mapper.AuthorMapper;
import com.hy.model.AuthorVO;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorMapper authorMapper;

	@Override
	public void authorEnroll(AuthorVO author) throws Exception {
		
		authorMapper.authorEnroll(author);
		
	}
	
	

}
