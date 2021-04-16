package com.bitacademy.myportal1.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal1.exception.MemberDaoException;
import com.bitacademy.myportal1.vo.MemberVo;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVo vo) {
		int insertedCount =0;
		try {
			insertedCount = sqlSession.insert("members.insert",vo);
			
		}catch(Exception e) {
			//예외 전환
			//로그 출력
			System.err.println("예외 발생:"+e.getMessage());
			throw new MemberDaoException("회원가입 중 오류 발생!!",vo);
		}
		return insertedCount;
	}

	@Override
	public MemberVo selectUser(String email, String password) {
		Map<String,String> userMap= new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		MemberVo vo = sqlSession.selectOne("members.selectUserByEmailAndPassword",userMap );
		return vo;
	}

	@Override
	public MemberVo selectUser(String email) {
		MemberVo vo=sqlSession.selectOne("members.selectUserByEmail",email);
		
		return vo;
	}

}
