package com.bitacademy.myportal1.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitacademy.myportal1.Vo.GuestBookVo;

@Repository //이름을 명시 하지 않으면 클래스 이름을 기반으로 자동 명명  guestBookDaoImpl 이됨
public class GuestBookDaoImpl implements GuestBookDao {

	@Override
	public List<GuestBookVo> selectAll() {
		//가상 데이터
		List<GuestBookVo> list = new ArrayList<>();
		list.add(new GuestBookVo(1l,"홍길동","1234","왔다감",new Date()));
		list.add(new GuestBookVo(2l,"전우치","pass","저두",new Date()));
		list.add(new GuestBookVo(3l,"길동","test","반갑다",new Date()));
		return list;
	}

	@Override
	public int insert(GuestBookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GuestBookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
