package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;

@Controller
public class CodeController {

	@Resource(name = "codeService")
	private CodeService codeService;

	// 코드 작성 화면
	@RequestMapping(value = "/codeWrite.do")
	public String codeWrite() {
		return "code/codeWrite";
	}

	// 코드 작성
	@RequestMapping(value = "/codeWriteSave.do")
	public String insertCodes(CodeVO vo) throws Exception {
		String result = codeService.insertCodes(vo);

		if (result == null) { // ok
			System.out.println("저장완료");
		} else {
			System.out.println("저장실패");
		}
		return "redirect:codeList.do";
	}

	// 코드 목록
	@RequestMapping(value = "/codeList.do")
	public String codeList(CodeVO vo, ModelMap model) throws Exception {
		int total = codeService.selectCodesCount(vo);
		List<?> list = codeService.selectCodesList(vo);
		model.addAttribute("total", total);
		model.addAttribute("codeList", list);
		return "code/codeList";
	}

	// 코드 삭제
	@RequestMapping(value = "/codeDelete.do")
	public String codeDelete(int code) throws Exception {
		codeService.deleteCodes(code);

		return "redirect:codeList.do";
	}

	// 코드 수정 화면
	@RequestMapping(value = "/codeModifyWrite.do")
	public String selectCodesDetail(int code, ModelMap model) throws Exception {
		CodeVO vo = codeService.selectCodesDetail(code);
		model.addAttribute("detail", vo);
		return "code/codeModifyWrite";
	}

	// 코드 수정
	@RequestMapping(value = "/codeModifySave.do")
	public String updateCodes(CodeVO vo) throws Exception {

		codeService.updateCodes(vo);

		return "redirect:codeList.do";
	}
}
