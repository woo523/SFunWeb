package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberDTO memberDTO) {
		
		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
		// 회원가입 디비 부모인터페이스 MemberDAO,
		//            자식클래스 MemberDAOImpl
		// 리턴할형 없음 inserMember(MemberDTO memberDTO)메서드 정의
	
		memberDAO.insertMember(memberDTO);
		
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl userCheck()");
		return memberDAO.userCheck(memberDTO);
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberServiceImpl getMember()");
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl updateMember()");
		
		memberDAO.updateMember(memberDTO);
	}

	@Override
	public List<Map<String, Object>> getMemberListMap() {
		System.out.println("MemberServiceImpl getMemberListMap()");
		
		return memberDAO.getMemberListMap();
	}



}
