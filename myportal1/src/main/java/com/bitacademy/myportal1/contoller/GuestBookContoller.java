package com.bitacademy.myportal1.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal1.Vo.GuestBookVo;
import com.bitacademy.myportal1.service.GuestBookService;

@RequestMapping("/guestbook")
@Controller
public class GuestBookContoller {
	@Autowired
	GuestBookService guestBookServiceImpl;
	@ResponseBody
	@RequestMapping({"","/","/list"})
	// ->/guestbook ,/guestbook/ ,guestbook/list
	public String list(Model model) {
		List<GuestBookVo> list = guestBookServiceImpl.getlist();
		//데이터를 모델에 추가
		model.addAttribute("list",list);
		return "guestbook/list";
	}

//	게시물 작성 메서드
	@RequestMapping(value="/write",
			method=RequestMethod.POST)
	public String write(@ModelAttribute GuestBookVo vo) {
		System.out.println("VO:" + vo);
		boolean success = guestBookServiceImpl.writeMessage(vo);
		System.out.println("Write Result:" + success);

		//	리스트 페이지로 리다이렉트
		return "redirect:/guestbook";
	}
	
}
