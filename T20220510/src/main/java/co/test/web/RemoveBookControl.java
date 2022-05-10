package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class RemoveBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookCode = request.getParameter("code");
		
		if(bookCode.isEmpty()) {
			request.setAttribute("error", "도서코드를 입력하세요");
			request.getRequestDispatcher("view/remove.jsp").forward(request, response);
		}
		BookVO book = new BookVO();
		book.setBookCode(bookCode);
		
		BookService service = new BookService();
		service.removeBook(bookCode);
		
		request.setAttribute("code", bookCode);
		
		request.getRequestDispatcher("result/removeOutput.jsp").forward(request, response);
	}

}
