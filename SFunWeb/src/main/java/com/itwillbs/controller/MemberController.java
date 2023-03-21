package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	
	
	// 부모 인터페이스 멤버변수
	@Inject
	private MemberService memberService;
	
	
	// 가상주소 http://localhost:8080/SFunWeb/member/insert
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
//		/WEB-INF/views/파일이름.jsp
//		/WEB-INF/views/member/join.jsp
		return "member/join";
	}

	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		// 회원가입 처리 부모인터페이스 MemberService
		// 			 자식클래스 MemberServiceImpl
		// 리턴할형 없음 insertMember(MemberDTO memberDTO) 메서드 정의
		
		memberService.insertMember(memberDTO);
		return "redirect:/member/login";
	}

	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		// 회원가입 처리
		
		return "member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController loginPro()");
		
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			// 아이디 비밀번호 일치
			// 세션값 생성
			// 주소줄 변경하면서 이동
			session.setAttribute("id", memberDTO2.getId());
			return "redirect:/main/main";
		}else {
			return "member/msg";
			// 아이디 비밀번호 틀림 뒤로 이동 member/msg
		}
		
	}
	
	@RequestMapping(value = "/main/main", method = RequestMethod.GET)
	public String main() {
		// 회원가입 처리
		
		return "main/main";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("MemberController logout()");
	
		session.invalidate();
		return "redirect:/main/main";
		
	}
	
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		System.out.println("MemberController update()");
	
		String id = (String)session.getAttribute("id");
	
		MemberDTO memberDTO = memberService.getMember(id);
		
		model.addAttribute("memberDTO", memberDTO);
		
		return "member/update";	
	}
	
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController updatePro()");
		
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			memberService.updateMember(memberDTO);
			return "redirect:/main/main";
		}else {
			return "member/msg";
			// 아이디 비밀번호 틀림 뒤로 이동 member/msg
		}
		
	}
	
	
	// 가상주소 http://localhost:8080/SFunWeb/member/listmap
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String listmap(Model model) {
		
		List<Map<String,Object>> memberListmap = memberService.getMemberListMap();
		
		model.addAttribute("memberListmap", memberListmap);
		
		return "member/listmap";
	}

	
}


