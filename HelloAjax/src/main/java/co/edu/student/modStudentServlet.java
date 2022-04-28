package co.edu.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/modStudentServlet")
public class modStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public modStudentServlet() {
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String sNo = req.getParameter("a");
		String sName = req.getParameter("b");
		String eng = req.getParameter("c");
		String kor = req.getParameter("d");

		Student std = new Student();
		std.setStudentNo(Integer.parseInt(sNo));
		std.setEngScore(Integer.parseInt(eng));
		std.setKorScore(Integer.parseInt(kor));
		std.setStudentName(sName);

		StudentDAO dao = new StudentDAO();
		boolean success = dao.modifyStudent(std);

		if (success) {
			resp.getWriter().println("{\"retCode\":\"Success\",\"studNo\":" + sNo + ", \"studName\":\"" + sName
					+ "\",\"engScore\":" + eng + ",\"korScore\":" + kor + "}");
		} else {
			resp.getWriter().println("{\"retCode\":\"Fail\"}");
		}

	}
}
