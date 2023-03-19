package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	// 가상주소 http://localhost:8080/SFunWeb/member/insert
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
//		/WEB-INF/views/파일이름.jsp
//		/WEB-INF/views/member/join.jsp
		return "member/join";
	}
}
