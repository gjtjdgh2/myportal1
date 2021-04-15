package com.bitacademy.myportal1.service;

import java.util.List;

import com.bitacademy.myportal1.vo.GuestBookVo;

public interface GuestBookService {
	public List<GuestBookVo> getlist();
	public boolean writeMessage(GuestBookVo vo);
	public boolean deleteMessage(GuestBookVo vo);
}
