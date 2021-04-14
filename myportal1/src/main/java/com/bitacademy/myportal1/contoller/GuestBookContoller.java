package com.bitacademy.myportal1.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String list() {
		List<GuestBookVo> list =guestBookServiceImpl.getlist();
		return list.toString();
	}

}
