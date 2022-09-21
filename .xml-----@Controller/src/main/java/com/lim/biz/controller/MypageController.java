package com.lim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lim.biz.member.MemberVO;
import com.lim.biz.member.impl.MemberDAO;



public class MypageController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		HttpSession session=request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		vo.setMid(mvo.getMid()); // 현재 접속한 사람 id
		vo.setMpw(mvo.getMpw()); // 현재 접속한 사람 id
		vo = dao.selectOne(vo); // 마이 페이지용 selectOne
		System.out.println(vo);
		if(vo != null) {
			mav.addObject("data",vo);
			mav.setViewName("redirect:mypage.jsp");
					
		}
		else {
			mav.setViewName("redirect:main.do");
		}
		
		return mav;
		
		
		
	}

}
