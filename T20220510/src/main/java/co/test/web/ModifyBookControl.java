package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookCode = request.getParameter("code");
		String bookTitle = request.getParameter("title");
		String bookAuthor = request.getParameter("author");
		String bookPress = request.getParameter("press");
		String bookPrice = request.getParameter("price");

		if (bookCode.isEmpty() || bookTitle.isBlank() || bookAuthor.isBlank() || bookPress.isBlank() || bookPrice.isBlank()) {
			request.setAttribute("error", "모든 항목을 입력하세요!");
			request.getRequestDispatcher("result/modifyOutput.jsp").forward(request, response);
		}
		BookVO book = new BookVO();
		book.setBookCode(bookCode);
		book.setBookTitle(bookTitle);
		book.setBookAuthor(bookAuthor);
		book.setBookPress(bookPress);
		book.setBookPrice(Integer.parseInt(bookPrice));
		
		BookService service = new BookService();
		service.modifyBook(book);
		
		request.setAttribute("title", bookTitle);
		
		request.getRequestDispatcher("result/modifyOutput.jsp").forward(request, response);
	}
}