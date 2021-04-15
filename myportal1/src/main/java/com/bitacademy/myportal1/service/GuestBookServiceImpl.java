package com.bitacademy.myportal1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal1.repository.GuestBookDao;
import com.bitacademy.myportal1.vo.GuestBookVo;

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
		int insertedCount = guestBookDaoImpl.insert(vo);
		return insertedCount ==1;
	}

	@Override
	public boolean deleteMessage(GuestBookVo vo) {
		int deletedCount = guestBookDaoImpl.delete(vo);
		return deletedCount ==1;
	}

}
