package com.ex.dao;

import com.ex.vo.BoardVO;

public interface BoardDAO {
	// 게시글 작성
	public void write(BoardVO board) throws Exception;
}
