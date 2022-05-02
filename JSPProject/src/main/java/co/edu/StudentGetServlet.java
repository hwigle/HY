package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/StudentGetServlet")
public class StudentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentGetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charshet=utf-8");
		// GET방식으로 요청할 경우 cmd = search, cmd = null이면 JSON으로 반환.
		String cmd = request.getParameter("cmd"); // cmd로 넘어온 값 확인

		if (cmd != null && cmd.equals("search")) {
			String id = request.getParameter("user_id");
			StudentDAO dao = new StudentDAO();
			Student student = dao.searchStudent(id);

			response.setContentType("text/html;charset=utf-8");
			if (student != null) {				
				response.getWriter().println("<h3>아이디: " + student.getStudentNo() + "</h3>");
				response.getWriter().println("<h3>이름: " + student.getStudentName() + "</h3>");
				response.getWriter().println("<h3>영어: " + student.getEngScore() + "</h3>");
				response.getWriter().println("<h3>국어: " + student.getKorScore() + "</h3>");
				
			} else {
				response.getWriter().println("<h3>조회된 데이터가 없습니다.</h3>");
			} 
			response.getWriter().println("<a href='studentList.jsp'>목록으로</a>");
		} else if (cmd != null && cmd.equals("list")) {
			StudentDAO dao = new StudentDAO();
			Student stud = new Student();
			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			System.out.println("id: " + id + ",user_name: " + name);

			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);

			dao.addStudent(stud);

			response.getWriter().print("입력성공");
		} else {
			response.setContentType("text/json;charset=UTF-8");
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.studentList();
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(list));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charshet=utf-8");

		String cmd = request.getParameter("cmd");
		if (cmd != null && cmd.equals("add")) {

			StudentDAO dao = new StudentDAO();
			Student stud = new Student();

			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("eng_score");
			String kor = request.getParameter("kor_score");

			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));

			dao.addStudent(stud);

			response.getWriter().print("입력성공");

		} else if (cmd != null & cmd.equals("del")) {
			String id = request.getParameter("user_id");

			StudentDAO dao = new StudentDAO();
			if (dao.removeStudent(id)) {
				response.getWriter().print("<script>alert('삭제성공')</script>");
			} else {
				response.getWriter().print("<script>alert('삭제실패')</script>");
			}

		} else if (cmd != null & cmd.equals("mod")) {
			// 사용자 입력 파라메터를 읽고
			Student stud = new Student();

			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("eng_score");
			String kor = request.getParameter("kor_score");

			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));

			StudentDAO dao = new StudentDAO();
			dao.modifyStudent(stud);

		}
		response.sendRedirect("studentList.jsp");
	} // end of doPost()

}
