package com.bitacademy.myportal1.repository;

import java.util.List;

import com.bitacademy.myportal1.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> selectAll();//게시물 목록 조화ㅣ용
	public int insert(BoardVo vo); //게시물 추가용
	public BoardVo getContent(Long no); //게시물 조회용
	public int update(BoardVo vo);	//게시물 수정용
	
}
