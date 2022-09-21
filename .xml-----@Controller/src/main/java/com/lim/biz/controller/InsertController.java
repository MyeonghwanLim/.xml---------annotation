package com.lim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lim.biz.board.BoardVO;
import com.lim.biz.board.impl.BoardDAO;




public class InsertController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		
		
		vo.setTitle(request.getParameter("title"));		
		vo.setContent(request.getParameter("content")); 	
		vo.setWriter(request.getParameter("writer")); 


		ModelAndView mav = new ModelAndView();
		
		dao.insertBoard(vo); // 게시글 등록
			mav.setViewName("redirect:main.do");
		
					
		return mav;
	}
	
	}


