package com.bitacademy.myportal1.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal1.vo.GuestBookVo;

@Repository //이름을 명시 하지 않으면 클래스 이름을 기반으로 자동 명명  guestBookDaoImpl 이됨
public class GuestBookDaoImpl implements GuestBookDao {
	//데이터 소스 연결
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<GuestBookVo> selectAll() {
		List<GuestBookVo> list = sqlSession.selectList("guestbook.selectAll");
		System.out.println("방명록:" + list);
		return list;
	}

	@Override
	public int insert(GuestBookVo vo) {
		int insertedCount =sqlSession.insert("guestbook.insert",vo);
		return insertedCount;
	}

	@Override
	public int delete(GuestBookVo vo) {
		int deletedCount = sqlSession.delete("guestbook.delete",vo);
		return deletedCount;
	}

}
