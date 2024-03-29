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

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO bVO, RedirectAttributes rttr) {
		service.register(bVO);
		rttr.addFlashAttribute("result", bVO.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("get", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bVO, RedirectAttributes rttr) {
		if(service.modify(bVO)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("remove")
	public String remove(@RequestParam("bno") Long bno, Model model, RedirectAttributes rttr) {
		if(service.remove(bno)){
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
