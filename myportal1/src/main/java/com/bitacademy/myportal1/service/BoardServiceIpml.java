package com.bitacademy.myportal1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal1.repository.BoardDao;
import com.bitacademy.myportal1.vo.BoardVo;

@Service
public class BoardServiceIpml implements BoardService {
	@Autowired
	BoardDao boardDaoImpl;

	@Override
	public List<BoardVo> getlist() {
		List<BoardVo> list = boardDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean write(BoardVo vo) {
		int insertedCount = boardDaoImpl.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public BoardVo getContent(Long no) {
		BoardVo vo = boardDaoImpl.getContent(no);
		return vo;
	}

	@Override
	public boolean update(BoardVo vo) {
		int updatedCount =  boardDaoImpl.update(vo);
		return updatedCount == 1;
	}

}
