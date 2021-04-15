package com.bitacademy.myportal1.exception;

import javax.servlet.http.HttpServletRequest;

//사용자 정의 예외
public class ControllerException extends RuntimeException{
	//필드
	private HttpServletRequest req;
	//예외 상황의 요청 정보를 저장해 둘 필드
	
	public ControllerException(String message) {
		super(message);
	}
	public ControllerException(String message, HttpServletRequest req) {
		super(message);
		this.req=req;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	
}
