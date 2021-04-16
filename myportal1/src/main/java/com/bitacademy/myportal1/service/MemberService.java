package com.bitacademy.myportal1.service;

import com.bitacademy.myportal1.vo.MemberVo;

public interface MemberService {
	public boolean join(MemberVo vo); //가입
	public MemberVo getUser(String email,String password); //로그인용
	public MemberVo getUser(String enail); //중복 체크 이메일
}
