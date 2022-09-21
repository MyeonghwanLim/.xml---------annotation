package com.lim.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lim.biz.board.BoardVO;
import com.lim.biz.board.impl.BoardDAO;
import com.lim.biz.member.MemberVO;
import com.lim.biz.member.impl.MemberDAO;

@Controller
public class MemberController {
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		return "login.jsp";
	}
	@RequestMapping(value="/insert.do",method=RequestMethod.GET)
	public String insert() {
		System.out.println("insert GET방식");
		return "insert.jsp";
	}
	@RequestMapping(value="/signin.do",method=RequestMethod.GET)
	public String signin() {
		System.out.println("signin GET방식");
		return "signin.jsp";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String selectOne(ModelAndView mav,MemberVO mVO,MemberDAO mDAO,HttpSession session){

		mVO=mDAO.selectOne(mVO);
		if(mVO==null) {
			return "login.jsp";
		}
		else {
			session.setAttribute("member", mVO);
			return "redirect:main.do";
		}

	}
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:main.do";

	}

	@RequestMapping("/main.do")
	public ModelAndView main(ModelAndView mav,BoardVO bVO,BoardDAO bDAO){

		List<BoardVO> datas=bDAO.selectAllBoard(bVO);

		mav.addObject("datas",datas);
		mav.setViewName("main.jsp");
		return mav;
	}
	@RequestMapping("/mypage.do")
	public ModelAndView mypage(ModelAndView mav,MemberVO vo,MemberDAO dao,HttpSession session) {

		vo=(MemberVO) session.getAttribute("member");
		vo = dao.selectOne(vo); 
		System.out.println(vo);
		if(vo != null) {
			session.setAttribute("data", vo);
			mav.setViewName("mypage.jsp");
		}
		else {
			mav.setViewName("main.do");
		}	
		return mav;
	}
	@RequestMapping(value="/signin.do",method=RequestMethod.POST)
	public ModelAndView signin(MemberVO mVO,MemberDAO mDAO,ModelAndView mav) {
		mDAO.insert(mVO);
		mav.setViewName("redirect:main.do");
		return mav;

	}
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String update(MemberVO vo,MemberDAO dao,HttpSession session){
		if(vo != null) {
			dao.update(vo);
			session.setAttribute("member", vo);
		}
		else {
			return"signin.jsp";
		}
		return "redirect:main.do";
	}
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	public String delete(MemberVO vo,MemberDAO dao,HttpSession session ) {

		vo = (MemberVO)session.getAttribute("member"); 
		vo = dao.selectOne(vo);

		if(vo != null) {
			System.out.println("1");
			dao.delete(vo);
			session.invalidate();
		}
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/insert.do" ,method=RequestMethod.POST)
	public String handleRequest(BoardDAO dao,BoardVO vo){
		dao.insertBoard(vo); 

		return "redirect:main.do";			

	}

}
