package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
public class BoardSeviceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVO bVO) {
		mapper.insert(bVO);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO bVO) {
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
}
