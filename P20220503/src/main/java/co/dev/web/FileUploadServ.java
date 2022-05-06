package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class FileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title: " + title + ", content: " + content);
		
		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		// multipart 요청.
		// request(요청정보), 업로드 파일의 저장위치, 업로드 파일의 최대 크기, 인코딩방식, 리네임정책.
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		title= multi.getParameter("title");
		content=multi.getContentType("content");
		String profile = multi.getOriginalFileName("profile");
		String fileName = multi.getFilesystemName("profile");
		System.out.println("title: " + title + ", content: " + content+", profile: " + profile +",file: " + fileName);

	}

}
