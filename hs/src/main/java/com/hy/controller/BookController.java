package com.hy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 이클래스가 컨트롤러 역할을 한다고 스프링에 선언하는 역할
public class BookController {
	// 로그 기록을 남기기 위해서 Logger 클래스 인 logger 변수를 선언
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	// 메인 페이지 이동
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainPageGet() {
		logger.info("메인 페이지 진입");
	}

}
