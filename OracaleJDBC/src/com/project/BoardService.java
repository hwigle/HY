package com.project;

import java.util.List;

public interface BoardService {
	
	public void insertBoard(Board board); // 게시글 등록
	public void modifyBoard(Board board); // 게시글 수정
	public void deleteBoard(Board board); // 게시글 삭제
	public List<Board> boardList(); // 전체 게시글 조회
	public Board getBoard(int bno); // 게시글 한건 조회(게시글번호로)
	public List<Reply> replyList(int r_no); // 전체 댓글 조회
	public void insertReply(Reply reply); // 댓글 작성
	public void modifyReply(Reply reply); // 댓글 수정
	public void deleteReply(Reply reply); // 댓글 삭제
	public int getMaxnum(); // 게시글 번호 채우기
	public int getMaxnum2(); // 댓글 번호 채우기?

}
