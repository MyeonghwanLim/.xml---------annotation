package com.lim.biz.member;

import java.util.List;

public interface MemberService {

	void insert(MemberVO vo);
	void update(MemberVO vo);
	void delete(MemberVO vo);
	MemberVO selectOne(MemberVO vo);
	List<MemberVO> selectAll(MemberVO vo);
}

