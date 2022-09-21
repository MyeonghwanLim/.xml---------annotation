package com.lim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lim.biz.member.MemberVO;
import com.lim.biz.member.impl.MemberDAO;



public class DeleteController implements Controller {
			@Override
			public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				MemberVO vo = new MemberVO();
				MemberDAO dao = new MemberDAO();

				HttpSession session=request.getSession();
				MemberVO mvo = (MemberVO)session.getAttribute("member"); // 접속한 멤버
				
				vo.setMid(mvo.getMid()); // 접속한 멤버의 id
				vo.setMpw(mvo.getMpw()); // 입력받은 pw
				vo = dao.selectOne(vo);
				ModelAndView mav = new ModelAndView();
				if(vo != null) {
					System.out.println("1");
						dao.delete(vo);
						session.invalidate();
						mav.setViewName("redirect:main.do");
						
			}
				return mav;
				

}
}