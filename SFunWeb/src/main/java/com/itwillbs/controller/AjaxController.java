package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {

	
	@Inject
	private MemberService memberService;
	

	@RequestMapping(value = "/member/idCheck", method = RequestMethod.GET)
	public ResponseEntity<String> idCheck(HttpServletRequest request) {
		
		String result="";
		
		String id = request.getParameter("id");
		
		MemberDTO memberDTO = memberService.getMember(id);
		if(memberDTO!=null) {
			result ="id dup";
		} else {
			result="id ok";
		}
		
		// 출력 결과 ResponseEntity 저장 => 되돌아감
		ResponseEntity<String> entity =
				new ResponseEntity<String>(result,HttpStatus.OK);
		
		return entity;
	}

	
}
