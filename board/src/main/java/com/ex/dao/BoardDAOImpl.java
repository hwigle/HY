package com.ex.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ex.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	@Override
	public void write(BoardVO board) throws Exception {
		sqlSession.insert("boardMapper.insert", board);
	}

}
