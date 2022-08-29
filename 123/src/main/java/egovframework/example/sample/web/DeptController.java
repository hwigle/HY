package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {
	
	@Resource(name="deptService")
	private DeptService deptService;
	
	@RequestMapping(value="/deptWrite.do")
	public String deptWrite() {
		
		return "dept/deptWrite";
	}
	// 부서 추가 
	@RequestMapping(value="/deptWriteSave.do")
	public String InsertDept(DeptVO vo) throws Exception {
		
		System.out.println(vo.getDeptno());
		System.out.println(vo.getDname());
		System.out.println(vo.getLoc());
		
		String result = deptService.InsertDept(vo);
		if( result == null ) {   // ok
			System.out.println("저장완료");
		} else {
			System.out.println("저장실패");
		}
		
		return "redirect:deptList";
	}
	
	// 부서 목록
	@RequestMapping(value="/deptList.do")
	public String selectDeptList(DeptVO vo, ModelMap model) throws Exception{
		List<?> list = deptService.selectDeptList(vo);
		System.out.println(list);
		model.addAttribute("deptList", list);
		return "dept/deptList";
	}
	
	// 부서 상세
	@RequestMapping(value = "/deptDetail.do")
	public String selectDeptDetail(int deptno, ModelMap model) throws Exception{ //Model로 jsp에 데이터 전달
		DeptVO vo = deptService.selectDeptDetail(deptno);
		model.addAttribute("deptVO",vo);
		System.out.println(vo);
		return"dept/deptDetail";
	}
	
	// 부서 수정 화면
	@RequestMapping(value="/deptModifyWrite.do")
	public String selectDeptModify(int deptno, ModelMap model) throws Exception{
		DeptVO vo = deptService.selectDeptDetail(deptno);
		model.addAttribute("vo",vo);
		return "dept/deptModifyWrite";
	}
	
	// 부서 수정
	@RequestMapping(value ="/deptModifySave.do")
	public String updateDept(DeptVO vo) throws Exception {
		
		int result = deptService.updateDept(vo);		
		
		return"dept/deptDetail";
	}
	
	// 부서 삭제
	@RequestMapping(value="deptDelete.do")
	public String deleteDept(int deptno) throws Exception {
		deptService.deleteDept(deptno);
		return"";
	}
	
	
	
}
