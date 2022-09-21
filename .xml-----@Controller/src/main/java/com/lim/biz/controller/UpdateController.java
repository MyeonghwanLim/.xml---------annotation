package com.lim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lim.biz.member.MemberVO;
import com.lim.biz.member.impl.MemberDAO;



public class UpdateController implements Controller {
			@Override
			public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				MemberVO vo = new MemberVO();
				MemberDAO dao = new MemberDAO();

				
				
				vo.setMid(request.getParameter("mid")); // 접속한 멤버의 id
				vo.setMpw(request.getParameter("mpw")); // 접속한 멤버의 id
				vo.setName(request.getParameter("name")); // 접속한 멤버의 id
				
				
				ModelAndView mav = new ModelAndView();
				if(vo != null) {
					     dao.update(vo);
						
						mav.setViewName("redirect:main.do");
						
			}
				return mav;
				

}
}