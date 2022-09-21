package com.lim.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lim.biz.common.AfterReturningAdvice;
import com.lim.biz.member.MemberService;
import com.lim.biz.member.MemberVO;

@Service("MemberService")
//controller격이기떄문에 @Component를 상속받은 @Service를 사용한다.
public class MemberServiceImpl implements MemberService {
	@Autowired // MemberDAO 타입의 객체가 메모리에 있어야지만 DI(의존성주입)가능
	private MemberDAO2 memberDAO; // 핵심로직을 수행할 객체
	

	@Override
	public void insert(MemberVO vo) {
		memberDAO.insert(vo);
	}

	@Override
	public void update(MemberVO vo) {
		memberDAO.update(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		memberDAO.delete(vo);
	}

	@Override
	   public MemberVO selectOne(MemberVO vo) {
	      if(vo.getMid().equals("timo")) {
	         throw new IllegalArgumentException("[실행시예외]");
	      }
	      return memberDAO.selectOne(vo);
	   }

	@Override
	public List<MemberVO> selectAll(MemberVO vo) {
		return memberDAO.selectAll(vo);
	}

}
