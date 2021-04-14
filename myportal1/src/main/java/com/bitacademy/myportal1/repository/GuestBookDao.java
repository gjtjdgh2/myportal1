package com.bitacademy.myportal1.repository;

import java.util.List;

import com.bitacademy.myportal1.Vo.GuestBookVo;

public interface GuestBookDao {
	public List<GuestBookVo> selectAll();
	public int insert(GuestBookVo vo);
	public int delete(GuestBookVo vo);
}
