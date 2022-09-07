package main.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.BoardService;
import main.service.BoardVO;

@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardService service;

	@RequestMapping("/boardWrite.do")
	public String boardWrite() {
		return "board/boardWrite";
	}

	@RequestMapping("/boardWriteSave.do")
	@ResponseBody
	public String insertBoard(BoardVO vo) throws Exception {
		String result = service.insertBoard(vo);
		String msg = "";
		if (result == null)
			msg = "ok";
		else
			msg = "fail";
		return msg;
	}

	@RequestMapping("/boardList.do")
	public String selectBoardList(BoardVO vo, ModelMap model) throws Exception {

		// 총 데이터 개수
		int total = service.selectBoardTotal(vo);

		// 만약 데이터가 12개가 있으면 12/10 -> 1.2 ceil함수 사용 -> 2.0 -> Integer 처리 -> 2
		int totalPage = (int) Math.ceil((double) total / 10);

		int viewPage = vo.getViewPage();
		// 1 -> 1,10 // 2 -> 11,20 // 3 -> 21,30
		// startIndex : (1-1)*10 +1 -> 1 // 1페이지
		// startIndex : (2-1)*10 +1 -> 11 // 2페이지
		int startIndex = (viewPage - 1) * 10 + 1;
		int endIndex = startIndex + (10 - 1);
		
		vo.setStartIndex(startIndex);
		vo.setEndIndex(endIndex);

		List<?> list = service.selectBoardList(vo);
		
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		return "board/boardList";
	}
}
