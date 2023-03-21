package com.itwillbs.dao;

import java.util.List;
import java.util.Map;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {

	public void insertMember(MemberDTO memberDTO);
	
	public MemberDTO userCheck(MemberDTO memberDTO);
	
	public MemberDTO getMember(String id);
	
	public void updateMember(MemberDTO memberDTO);
	
	public List<Map<String, Object>> getMemberListMap();
}
