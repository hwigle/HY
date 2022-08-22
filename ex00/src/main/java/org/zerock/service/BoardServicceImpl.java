package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServicceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public void insert(BoardVO bVO) {
		mapper.insert(bVO);
	}

	@Override
	public BoardVO read(int bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean delete(int bno) {
		return mapper.delete(bno) == 1;
	}

	@Override
	public boolean update(BoardVO bVO) {
		return mapper.update(bVO) == 1;
		
	}

}
