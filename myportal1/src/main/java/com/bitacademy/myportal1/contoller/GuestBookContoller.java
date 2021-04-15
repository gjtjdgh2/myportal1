package com.bitacademy.myportal1.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal1.service.GuestBookService;
import com.bitacademy.myportal1.vo.GuestBookVo;

@RequestMapping("/guestbook")
@Controller
public class GuestBookContoller {
	@Autowired
	GuestBookService guestBookServiceImpl;
//	@ResponseBody
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
	
	//게시물 삭제 폼
	@RequestMapping(value="/delete/{no}",
			method=RequestMethod.GET)
	public String deleteForm(@PathVariable Long no,Model model) {
		model.addAttribute("no",no);
		return "guestbook/deleteform";
	}
	
	//게시물 삭제 기능
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo vo) {
		boolean success = guestBookServiceImpl.deleteMessage(vo);
		System.out.println("Delete Result:"+success);
		return "redirect:/guestbook";
	}
}
