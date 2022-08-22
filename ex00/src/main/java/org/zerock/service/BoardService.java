package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();
	public void insert(BoardVO bVO);
	public BoardVO read(int bno);
	public boolean delete(int bno);
	public boolean update(BoardVO bVO);
}
