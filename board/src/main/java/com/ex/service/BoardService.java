package com.ex.service;

import com.ex.vo.BoardVO;

public interface BoardService {

	// 게시글 작성
	public void write(BoardVO board) throws Exception;
}
