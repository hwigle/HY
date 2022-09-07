package main.service;

import java.util.List;

public interface BoardService {
	
	// 게시글 작성
	public String insertBoard(BoardVO vo) throws Exception;
	// 게시글 목록
	public List<?> selectBoardList(BoardVO vo) throws Exception;
	// Total 개수
	public int selectBoardTotal(BoardVO vo) throws Exception;
}