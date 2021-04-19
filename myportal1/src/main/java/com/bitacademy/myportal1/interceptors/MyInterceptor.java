package com.bitacademy.myportal1.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal1.contoller.BoardController;

//spring-servlet.xml 등록 해줘야 한다
//인터페이스 구현 방식 인터셉터
public class MyInterceptor implements HandlerInterceptor {
	private static Logger logger= LoggerFactory.getLogger(MyInterceptor.class);
	
	//preHandel: 컨트롤로 호출 이전에 수행
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)//뒤에 연결된 인터셉터 or 컨트롤러
			throws Exception {
		logger.debug("MyInerceptor.preHandle");
		//return이 false면 실행이 중단되고 뒤에 연결된 인터셉터 or 컨트롤러 로 진행 하지 않는다
		return true;
	}
	//postHandle:호출 이후에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInerceptor.postHandle");

	}

	//afterCompletion : 뷰 랜더링까지 완료된 상태에서 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.debug("MyInerceptor.afterCompletion");
	}

}
