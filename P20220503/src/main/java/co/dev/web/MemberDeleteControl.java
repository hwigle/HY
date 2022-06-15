package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberDeleteControl implements Control {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하세요!");
			request.getRequestDispatcher("memberView/memberDelete.jsp").forward(request, response);
		}
		MemberVO member = new MemberVO();
		member.setId(id);

		MemberService service = new MemberService();
		service.memberDelete(id);

		request.setAttribute("id", id);

		request.getRequestDispatcher("memberResult/memberDeleteOutput.jsp").forward(request, response);

	}
}