package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("deptService")
public class DeptServiceImpl extends EgovAbstractServiceImpl implements DeptService {
	@Resource(name = "deptDAO")
	private DeptDAO deptDAO;

	// 부서 추가
	@Override
	public String InsertDept(DeptVO vo) throws Exception {
		return deptDAO.InsertDept(vo);
	}
	// 부서 목록
	@Override
	public List<?> selectDeptList(DeptVO vo) throws Exception {
		return deptDAO.selectDeptList(vo);
	}
	// 부서 상세
	@Override
	public DeptVO selectDeptDetail(int deptno) throws Exception {
		return deptDAO.selectDeptDetail(deptno);
	}
	// 부서 수정
	@Override
	public int updateDept(DeptVO vo) throws Exception {
		return deptDAO.updateDept(vo);
	}
	// 부서 삭제
	@Override
	public int deleteDept(int deptno) throws Exception {
		return deptDAO.deleteDept(deptno);
	}
	
	
}
