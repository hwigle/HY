package co.dev.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.web.FrontController.MemberListJson;

public class FrontController extends HttpServlet {
	public class MemberListJson implements Control {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub

		}

	}

	HashMap<String, Control> list = null;
	String charset= null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Control>();
		list.put("/memberInsert.do", new MemberInsertControl());
		list.put("/memberUpdate.do", new MemberUpdateControl());
		list.put("/memberList.do", new MemberListControl());
		list.put("/memberSearch.do", new MemberSearchControl());
		list.put("/memberDelete.do", new MemberDeleteControl());
		
		// json 관련 등록.
		list.put("/memberListJson.do", new MemberListJson());
		list.put("/memberInsertJson.do", new MemberInsertJson());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);

		String url = req.getRequestURI(); // P20220503/memberInsert.do
		String context = req.getContextPath(); // 프로젝트 정보를 리턴
		String path = url.substring(context.length()); // path 정보는 제일 마지막 부분을 가져옴
		// cotext 이후의 값을 짜름
		Control exeCon = list.get(path);
		exeCon.execute(req, resp);
	}
}
