package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	// 게시글 전체 조회
	public List<BoardVO> getList();

	// 게시글 삽입 : insert 처리 후 생성된 PK값을 알 필요 없는 경우
	public void insert(BoardVO bVO);

	// 게시글 삽입 : insert 처리 후 생성된 PK값을 알아야 하는 경우
	public void insertSelectKey(BoardVO bVO);

	// 게시글 읽기 : 게시글 번호를 통해서 1개의 글 읽어오기
	public BoardVO read(Long bno);

	// 게시글 삭제
	// 삭제하고자하는 게시글이 있다면 1, 없으면 0 반환
	public void delete(Long bno);
	// 게시글 수정
	// 수정하고자하는 게시글이 있다면 1, 없으면 0 반환
	public int update(BoardVO bVO);
}
