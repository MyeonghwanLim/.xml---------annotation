package com.lim.biz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lim.biz.member.MemberVO;
import com.lim.biz.member.impl.MemberDAO;

/**
 * Servlet implementation class DIspatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 의존관계  
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	// init() 통해서 DI(주입)
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./"); // 현재 디렉토리 
		viewResolver.setSuffix(".jsp"); // 파일타입
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command=request.getRequestURI();
		command=command.substring(command.lastIndexOf("/"));
		System.out.println(command);
		
//		Controller ctrl = handlerMapping.getController(command);
//		String viewName=ctrl.handleRequest(request, response); //null 은 handleRequest를 할수없다.
//		
//		String view=null;
//		if(viewName.contains(".do")) {
//			view=viewName;
//		}
//		else {
//			view=viewResolver.getView(viewName);
//		}
//		response.sendRedirect(view);
	}

}
