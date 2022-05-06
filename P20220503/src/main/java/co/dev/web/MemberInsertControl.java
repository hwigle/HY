package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// multipart 요청이 들어오면 필요한 것 : request, 디렉토리위치, 파일사이즈, 인코딩방식, 리네임정책
		response.setContentType("text/json;charset=UTF-8");
		String saveDir = "upload";
		saveDir = request.getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		// multipart 요청.
		// request(요청정보), 업로드 파일의 저장위치, 업로드 파일의 최대 크기, 인코딩방식, 리네임정책.
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		System.out.println("입력처리하는 컨트롤입니다.");
		
		String id = multi.getParameter("id");
		String ps = multi.getParameter("passwd");
		String nm = multi.getParameter("name");
		String em = multi.getParameter("email");
		String pf = multi.getFilesystemName("profile");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(nm);
		vo.setEmail(em);
		vo.setPasswd(ps);
		vo.setProfile(pf);
		
		MemberService service = new MemberService();
		service.memberInsert(vo);
		
		request.setAttribute("id", id);
		request.setAttribute("name", nm);		
		
		// Dispatcher 객체 기능 중 forward
		request.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(request, response);
	}

}
