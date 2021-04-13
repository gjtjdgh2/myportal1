package com.bitacademy.myportal.contoller.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/main")
	public ModelAndView main(@RequestParam String name) {
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("message","Hello"+name);
		mav.setViewName("/WEB-INF/views/home.jsp");
		return mav;
	}

}
