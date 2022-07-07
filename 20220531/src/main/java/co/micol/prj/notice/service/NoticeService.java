package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(int state, String key); //전체 글 조회
	NoticeVO noticeSelect(NoticeVO vo); //한 글 조회
	int noticeInsert(NoticeVO vo); //글 추가
	int noticeUpdate(NoticeVO vo); //글 수정
	int noticeDelete(NoticeVO vo); //글 삭제
	
	int noticeHitUpdate(int id); //조회수 변경
}