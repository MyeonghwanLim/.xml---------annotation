package com.lim.biz.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping { // 객체의 무분별한 생성을 막기 위해 싱글톤 패턴을 사용한다.
	//input : 어떤 요청에 대해 == String
	//output: 무슨 Controller 객체를 제공해야하는지 == Controller
//	private Map<String,Controller> mappings; // 의존관계 ->DI => 생성자 주입
//	// 누가 어디로 가야하는지 매핑을 해주어야 하기 떄문에 어떤 명령에 대해 어떤 컨트롤러를
//	// 이어줘야할지 명시해야하기 떄문에 Map객체가 필요하다.
//	public HandlerMapping() {
//		mappings=new HashMap<String,Controller>();
//		mappings.put("/login.do", new LoginController()); // 싱글톤 패턴이 유지됨
//		mappings.put("/logout.do", new LogoutController()); 
//		mappings.put("/main.do", new MainController()); 
//		mappings.put("/signin.do", new SigninController()); 
//		mappings.put("/mypage.do", new MypageController()); 
//	}
//	//위의 생성자를 사용하기 위해 기본생성자를 통해 new를 해주었다.
//	
//	public Controller getController(String command) {
//		// 들어온 요청에 대해 mapping 후 DS로 리턴한다.
//		return mappings.get(command);
//	}
}
