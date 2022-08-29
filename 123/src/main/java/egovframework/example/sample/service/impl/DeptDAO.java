package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//SQL 연결
@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO {

	
	// 부서 입력
	public String InsertDept(DeptVO vo) {
		return (String) insert("deptDAO.InsertDept", vo);
	}
	
	// 부서 목록
	public List<?> selectDeptList(DeptVO vo){
		return list("deptDAO.selectDeptList", vo);
				
	}
	// 부서 상세
	public DeptVO selectDeptDetail(int deptno) {
		return (DeptVO) select("deptDAO.selectDeptDetail",deptno);
	}
	// 부서 수정
	public int updateDept(DeptVO vo) {
		return update("deptDAO.updateDept",vo);
	}

	public int deleteDept(int deptno) {
		return delete("deptDAO.deleteDept",deptno);
	}
}
