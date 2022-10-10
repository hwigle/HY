package com.hy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.hy.model.MemberVO;

public class AdminInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		HttpSession session = request.getSession();
		
		MemberVO loginVO = (MemberVO) session.getAttribute("member");
		
		if(loginVO == null || loginVO.getAdminCk() == 0) { // 관리자 계정이 아닌 경우
			response.sendRedirect("/main");				   // main 페이지로 리다이렉트
			
			return false;
		}
		
		return true; 
	}
	
}
