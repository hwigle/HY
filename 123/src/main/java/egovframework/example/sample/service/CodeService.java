package egovframework.example.sample.service;

import java.util.List;

public interface CodeService {
	// 코드 추가
	public String insertCodes(CodeVO vo) throws Exception;
	// 코드 목록
	public List<?> selectCodesList(CodeVO vo) throws Exception;
	// 코드 총개수
	public int selectCodesCount(CodeVO vo) throws Exception;
	// 코드 삭제
	public int deleteCodes(int code) throws Exception;
	// 코드 상세
	public CodeVO selectCodesDetail(int code) throws Exception;
	// 코드 수정
	public int updateCodes(CodeVO vo) throws Exception;
}
