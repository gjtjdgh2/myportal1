package com.bitacademy.myportal1.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bitacademy.myportal1.vo.MemberVo;

//인증이 필요한 url 패턴에 인터셉터 적용, 필요시 로그인 창으로 변환
public class Authlntercrptor extends HandlerInterceptorAdapter {
	private static Logger logger= LoggerFactory.getLogger(Authlntercrptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("Authlntercrptor");
		HttpSession session = request.getSession();
		MemberVo authUser = null;
		
		if(session != null) {
			authUser = (MemberVo)session.getAttribute("authUser");
		}
		//authUser가 null(로그인 안함)이면
		//-> 로그인 창으로 redirect
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/members/login");
			return false; //요철을 뒤로 보내는 것을 중단
		}
		return true;
	}

}
