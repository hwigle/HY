package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	public void insert(BoardVO bVO);
	public BoardVO read(int bno);
	public int delete(int bno);
	public int update(BoardVO bVO);
}
