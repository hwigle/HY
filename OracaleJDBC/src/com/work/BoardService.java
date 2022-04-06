package com.work;

import java.util.List;

public interface BoardService {
	
	public void insertBoard(Board board); // 게시글 등록
	public void modifyBoard(Board board); // 게시글 수정
	public void deleteBoard(Board board); // 게시글 삭제
	public List<Board> boardList(); // 전체 게시글 조회
	public Board getBoard(int bno); // 게시글 한건 조회(게시글번호로)
	public List<Reply> replyList(int bno); // 전체 댓글 조회
	public void insertReply(Reply reply);
	public void deleteReply(int r_no);
	public int getMaxnum();
	public int getMaxnum2();		

}
