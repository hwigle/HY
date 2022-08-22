package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private BoardService service;
	// 글 목록
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}
	// 글 작성
	@PostMapping("/insert")
	public String register(BoardVO bVO, RedirectAttributes rda) {
		service.insert(bVO);
		rda.addFlashAttribute("result", bVO.getBno());
		return "redirect:/board/list";
	}
	// 글 조회
	@GetMapping("/read")
	public void read(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", service.read(bno));
	}
	// 글 수정
	@PostMapping("/update")
	public String update(BoardVO bVO, RedirectAttributes rda) {
		if(service.update(bVO)) {
			rda.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	// 글 삭제
	@PostMapping("delete")
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rda) {
		if(service.delete(bno)) {
			rda.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
