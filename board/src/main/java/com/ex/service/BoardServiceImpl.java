package com.ex.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ex.dao.BoardDAO;
import com.ex.vo.BoardVO;
@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO dao;
	@Override
	public void write(BoardVO board) throws Exception {
		dao.write(board);
	}

}
