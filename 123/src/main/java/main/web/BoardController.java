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

		int unit = 5;

		// 총 데이터 개수
		int total = service.selectBoardTotal(vo);

		// 만약 데이터가 12개가 있으면 12/10 -> 1.2 ceil함수 사용 -> 2.0 -> Integer 처리 -> 2
		int totalPage = (int) Math.ceil((double) total / unit);

		int viewPage = vo.getViewPage();

		if (viewPage > totalPage || viewPage < 1) {
			viewPage = 1;
		}
		// 1 -> 1,10 // 2 -> 11,20 // 3 -> 21,30
		// startIndex : (1-1)*10 +1 -> 1 // 1페이지
		// startIndex : (2-1)*10 +1 -> 11 // 2페이지
		int startIndex = (viewPage - 1) * unit + 1;
		int endIndex = startIndex + (unit - 1);

		int startRowNo = total - (viewPage-1)*unit;
		System.out.println("행번호 = "+startRowNo);
		vo.setStartIndex(startIndex);
		vo.setEndIndex(endIndex);

		List<?> list = service.selectBoardList(vo);

		model.addAttribute("rowNumber", startRowNo);
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);

		return "board/boardList";
	}
	
	@RequestMapping("/boardDetail.do")
	public String boardDetail(BoardVO vo, ModelMap model) throws Exception {
		
		// 조회수 증가
		service.updateBoardHits(vo.getUnq());
		
		// 상세보기
		BoardVO detail = service.selectBoardDetail(vo.getUnq());
		
		// 내용 줄바꿈
		String content = detail.getContent(); // \n
		detail.setContent(content.replace("\n", "<br>")); 
		
		model.addAttribute("detail", detail);
		
		return "board/boardDetail";
	}
}
