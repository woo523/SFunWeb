package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {

	
	@Inject
	private MemberService memberService;
	
	@Inject
	private BoardService boardService;
	

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

	@RequestMapping(value = "/board/listjson", method = RequestMethod.GET)
	public ResponseEntity<List<BoardDTO>> listjson() {
		// 디비 최근글 5개 가져오기
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageSize(5);
		pageDTO.setPageNum("1");
		pageDTO.setCurrentPage(1);
		
		List<BoardDTO> boardList=boardService.getBoardList(pageDTO);
		// 출력 결과 ResponseEntity 저장 => 되돌아감
		ResponseEntity<List<BoardDTO>> entity =
				new ResponseEntity<List<BoardDTO>>(boardList,HttpStatus.OK);
		// List<BoardDTO> 형을 => json데이터 형으로 변경
		// 스프링 자동으로 json 형태로 변환
		// jackson databind
		return entity;
	}
	
	
	
}
