package egovframework.example.sample.service;

import java.util.List;
//interface(일반메서드 생성 불가)는 명세역할을 주로 함, 추상클래스(객체처리 가능)도 명세역할을 함(추상메서드는 일반 메서드도 실행 가능)
public interface DeptService {
	// 부서 추가	
	public String InsertDept(DeptVO vo) throws Exception;
	// 부서 목록
	public List<?> selectDeptList(DeptVO vo) throws Exception;
	// 부서 상세
	public DeptVO selectDeptDetail(int deptno) throws Exception;
	// 부서 수정
	public int updateDept(DeptVO vo) throws Exception;
	// 부서 삭제
	public int deleteDept(int deptno) throws Exception; // 처리가 되는 것을 결과를 리턴 결과란 갯수 몇개를 삭제했는지 그래서 인티저로 받는다.

}
