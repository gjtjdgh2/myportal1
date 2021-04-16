package com.bitacademy.myportal1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal1.repository.MemberDao;
import com.bitacademy.myportal1.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	//Dao 연결
	@Autowired
	MemberDao memberDao;
	
	@Override
	public boolean join(MemberVo vo) {
		int insertedCount = memberDao.insert(vo);
		return insertedCount==1;
	}

	@Override
	public MemberVo getUser(String email, String password) {
		MemberVo vo = memberDao.selectUser(email, password);
		return vo;
	}

	//이메일 중복 처리용
	@Override
	public MemberVo getUser(String enail) {
		MemberVo vo =memberDao.selectUser(enail);
		return vo;
	}

}
