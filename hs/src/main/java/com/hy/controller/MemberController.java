package com.hy.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.model.MemberVO;
import com.hy.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	private MemberService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	// 로그 기록을 남기기 위해서 Logger 클래스 인 logger 변수를 선언
		private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	// 회원가입 페이지 이동
	@RequestMapping(value="join", method = RequestMethod.GET)
	public void joinGet() {
		logger.info("회원가입 페이지 진입");
	}	
	
	// 회원가입
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(MemberVO member) throws Exception{
		logger.info("join 진입");
		
		// 회원가입 서비스 실행
		service.memberJoin(member);
		
		logger.info("join service 성공");
		
		return "redirect:/main";
	}
	
	// 회원가입 아이디 중복체크
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {

		logger.info("memberIdChk() 진입");

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
		int checkNum = random.nextInt(888888)+111111;
		
		// 이메일 보내기
		String setFrom = "fhaktj5wkd8wjf@naver.com";
		String toMail = email;
		String title ="회원가입 인증 이메일 입니다.";
		String content =
				"홈페이지를 방문해주셔서 감사합니다." +
				"<br><br>" +
				"인증 번호는" + checkNum + "입니다." +
				"<br>" +
				"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String num = Integer.toString(checkNum);
		
		return num;
	}
	
	
	// 로그인 페이지 이동
	@RequestMapping(value="login", method = RequestMethod.GET)
	public void loginGet() {
		logger.info("로그인 페이지 진입");
	}
}
