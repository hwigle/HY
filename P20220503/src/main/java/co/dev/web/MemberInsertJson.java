package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertJson implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		MemberVO vo = new MemberVO();
		
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		
		if(isMulti) {
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
			
			vo = new MemberVO();
			vo.setId(id);
			vo.setName(nm);
			vo.setEmail(em);
			vo.setPasswd(ps);
			vo.setProfile(pf);
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
			
		} else {
			String id = request.getParameter("id");
			String ps = request.getParameter("passwd");
			String nm = request.getParameter("name");
			String em = request.getParameter("email");
			
			vo = new MemberVO();
			vo.setId(id);
			vo.setName(nm);
			vo.setEmail(em);
			vo.setPasswd(ps);		
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
			response.getWriter().print("{\"msg\": \"처리완료\"}");
			
		}
		// json 형태의 결고 반환
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));
		
				
		
	}

}
