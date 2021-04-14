package com.bitacademy.myportal1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal1.Vo.GuestBookVo;
import com.bitacademy.myportal1.repository.GuestBookDao;

@Service
public class GuestBookServiceImpl implements GuestBookService {

	//DAO 연결
	@Autowired
	GuestBookDao guestBookDaoImpl;
	
	@Override
	public List<GuestBookVo> getlist() {
		List<GuestBookVo> list = guestBookDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean writeMessage(GuestBookVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(GuestBookVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
