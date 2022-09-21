package com.lim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lim.biz.member.MemberVO;
import com.lim.biz.member.impl.MemberDAO;

public class SigninController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		String name=request.getParameter("name");
		String role=request.getParameter("role");
		MemberVO mVO=new MemberVO();
		MemberDAO mDAO=new MemberDAO();
ModelAndView mav = new ModelAndView();
		mVO.setMid(mid);
		mVO.setMpw(mpw);
		mVO.setName(name);
		mVO.setRole(role);
		
		mDAO.insert(mVO);
		mav.setViewName("redirect:main.do");
		return mav;
	}

}
