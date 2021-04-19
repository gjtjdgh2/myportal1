package com.bitacademy.myportal1.contoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal1.service.BoardService;
import com.bitacademy.myportal1.vo.BoardVo;
import com.bitacademy.myportal1.vo.MemberVo;

@Controller
@RequestMapping ("/board")
public class BoardController {
	private static Logger logger= LoggerFactory.getLogger(BoardController.class);
	//서비스 연결 
	@Autowired
	BoardService boardServiceIpml;
	
	@RequestMapping({"","/","/list"})
	public String list(Model model) {
		List<BoardVo> list = boardServiceIpml.getlist();
		model.addAttribute("list",list);
		logger.debug("계시물 목록:",list);
		
		return "board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		//사용자를 체크해서 로그인 안한 사용자는 쓰기 기능 제한
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if(authUser ==null) {
			return "redirect:/";
		}
		return "board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writeAction(@ModelAttribute BoardVo vo,
			HttpSession session)
	{
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if(authUser ==null) {
			return "redirect:/board/write";
		}
		//전달 받은 BoardVo 객체의 현재 로그인 한 사용자의 pk를 삽입
		vo.setMemberNo(authUser.getNo());
		boolean success = boardServiceIpml.write(vo);
		logger.debug("계시물 등록 결과:",success);
		if(success) {
			return "redirect:/board";
		}
		return "redirect:/board/write";
	}
	@RequestMapping("/{no}")
	public String view(@PathVariable Long no,Model model) {
		BoardVo vo = boardServiceIpml.getContent(no);
		model.addAttribute("vo",vo);
		return "/board/view";
	}
	@RequestMapping("/{no}/modify")
	public String modifyForm(@PathVariable Long no,Model model,HttpSession session) {
		//기존 계시물 받기
		BoardVo vo = boardServiceIpml.getContent(no);
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		
		if(authUser==null) {
			return "redirect:/board";
		}else if(authUser.getNo() !=vo.getMemberNo()) {//계시물 작성자가 아니면
			return "redirect:/board";
		}
		model.addAttribute("vo",vo);
		return "/board/modify";
		
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyAction(@ModelAttribute BoardVo updateVo) {
	//기존 계시물 확인
		BoardVo vo= boardServiceIpml.getContent(updateVo.getNo());
	//변경된 내용 교채
		vo.setTitle(updateVo.getTitle());
		vo.setContent(updateVo.getContent());
		
		boolean success = boardServiceIpml.update(vo);
		logger.debug("게시물 업데이트:",success);
		
		return "redirect:/board";
}
}
