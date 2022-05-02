package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// IOC : Introversion of control
public class StudentServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		String method = req.getMethod();
		PrintWriter out = resp.getWriter(); // 출력스트림을 생성한다는 의미
		out.print("<h3>Student Sample page.</h3>");
		if (method.equals("GET")) {
			out.print("<h3>Get방식 호출</h3>");
			doGet(req, resp);
		} else if (method.equals("POST")) {
			out.print("<h3>Post방식 호출</h3>");
		}

		out.print("<a href='../index.jsp?user_name=kildong&user_id=hong'>index page</a>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출.");
	}

}
