package com.bitacademy.myportal1.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal1.repository.MemberDaoImpl;
import com.bitacademy.myportal1.service.MemberService;
import com.bitacademy.myportal1.vo.MemberVo;

@Controller
@RequestMapping("/members")
public class MemberController {
	private static Logger logger= LoggerFactory.getLogger(MemberController.class);
	
	//서비스 연결
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value= {"","/","/join"},
			method=RequestMethod.GET)
	public String join()
	{
		return "users/joinform";
	}
	
	//가입 처리
	@RequestMapping(value= "/join",
			method=RequestMethod.POST)
	public String joinAction(@ModelAttribute MemberVo memberVo) {
		//System.out.println("form 전송된 데이터:"+memberVo);
		logger.debug("form 전송된 데이터:"+memberVo);
		boolean success = memberService.join(memberVo);
		if(success) {// insert성공
			//System.out.println("가입 성공!");
			logger.debug("가입 성공!");
			return "redirect:/members/joinsuccess";
		}else {
			System.err.println("가입실패");
			return "redirect:/members/";
		}
	}
	
	//성공 화면
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}
	
	
	//join 매핑 확인
	@ResponseBody //massageConverter 작동
	@RequestMapping("/show")
	public Object showUserByEmail(@RequestParam String email) {
		MemberVo vo = memberService.getUser(email);
		return vo;
	}
	
	
	//중복 이메일 체크
	@ResponseBody
	@RequestMapping("/emailcheck")
	public Object existsEmail(@RequestParam(value="email", required=false, defaultValue="")
	String email) {
		MemberVo vo =memberService.getUser(email);
		boolean exists = vo !=null ? true : false;
		
		Map<String,Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		return map;
	}
	//로그인 폼 처리
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm() {
		
		return "users/loginform";
	}
	//로그인 처리
	@RequestMapping(value="/login",method=RequestMethod.POST)
public String loginAction( @RequestParam String email,@RequestParam String password,
		HttpSession session) {//사용자 세션 저장르 위한 세션 객체
		
		MemberVo authUser = memberService.getUser(email, password);
		
		//만약에 찾는 유저가 없다면 login 폼으로 되돌려 보낸다
		if(authUser !=null) {
			//세션 추가
			session.setAttribute("authUser", authUser);
			//홈페이지로 리다이렉트
			return "redirect:/";
		}else {
			return "redirect:/members/login";
		}
	
	}
	
	//로그아웃 처리
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		//세션 지우기
		session.removeAttribute("authUser");
		//세션 무효화
		session.invalidate();
		return "redirect:/";
				
		
	}
	
}
