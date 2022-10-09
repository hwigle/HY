package com.hy.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hy.model.MemberVO;
import com.hy.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	private MemberService service;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
    private BCryptPasswordEncoder pwEncoder;

	// 로그 기록을 남기기 위해서 Logger 클래스 인 logger 변수를 선언
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	// 회원가입 페이지 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGet() {
		logger.info("회원가입 페이지 진입");
	}

	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception {
		String rawPw = ""; 		// 인코딩 전 비밀번호
		String encodePw = ""; 	// 인코딩 후 비밀번호

		rawPw = member.getMemberPw(); 		// 비밀번호 데이터 얻음
		encodePw = pwEncoder.encode(rawPw); // 비밀번호 인코딩
		member.setMemberPw(encodePw); 		// 인코딩된 비밀번호 member객체에 다시 저장

		/* 회원가입 쿼리 실행 */
		service.memberJoin(member);
	      
		return "redirect:/main";
	}

	// 회원가입 아이디 중복체크
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {

		int result = service.idCheck(memberId);

		if (result != 0) {
			return "fail"; // 중복 아이디 존재
		} else {
			return "success"; // 중복 아이디 없음
		}
	}

	// 회원가입 이메일 인증
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGet(String email) throws Exception {

		// 인증번호 난수 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		// 이메일 보내기
		String setFrom = "fhaktj5wkd8wjf@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는" + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);

		return num;
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGet() {
		logger.info("로그인 페이지 진입");
	}

	// 로그인
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception{
        
		HttpSession session = request.getSession();
        String rawPw = "";
        String encodePw = "";
        
		MemberVO loginVO = service.memberLogin(member);// 제출한아이디와 일치하는 아이디 있는지 
        
        if(loginVO != null) {   // 일치하는 아이디 존재시
        	
            rawPw = member.getMemberPw();       	 // 사용자가 제출한 비밀번호
            encodePw = loginVO.getMemberPw();        // 데이터베이스에 저장한 인코딩된 비밀번호
            
            if(true== pwEncoder.matches(rawPw, encodePw)) { // 비밀번호 일치여부 판단
            	
            	loginVO.setMemberPw("");  					// 인코딩된 비밀번호 정보 지움
            	session.setAttribute("member", loginVO);	// session에 사용자의 정보 저장
            	return "redirect:/main";        			// 메인페이지 이동
            	
            } else { 			
            	
            	rttr.addFlashAttribute("result", 0);            
                return "redirect:/member/login";    // 로그인 페이지로 이동
            }
            
        } else {   		        // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)
            
        	 rttr.addFlashAttribute("result", 0);            
             return "redirect:/member/login";    // 로그인 페이지로 이동
            
        }
    }
	
	// 로그아웃
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return"redirect:/main";
	}
	
	// 비동기식 로그아웃
    @RequestMapping(value="logout.do", method=RequestMethod.POST)
    @ResponseBody
    public void logoutPOST(HttpServletRequest request) throws Exception{
        
        HttpSession session = request.getSession();
        
        session.invalidate();
        
    }
	
}
