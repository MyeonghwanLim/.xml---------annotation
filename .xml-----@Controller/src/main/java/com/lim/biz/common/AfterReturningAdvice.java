package com.lim.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.lim.biz.member.MemberVO;
@Service //Impl 클래스를 사용하기 떄문에 서비스류라고 알려주기위해 @Service 사용
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(value="PointCommon.bPointcut()", returning = "returnObj")
	public void printLogAfterReturning(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		// 현재 수행중인 포인트컷(핵심로직,CRUD)의 메서드명
		Object[] args=jp.getArgs();
		// 현재 수행중인 포인트컷(핵심로직,CRUD)이 사용하는 인자들의 정보
		System.out.println("수행중인 핵심메서드명1: "+methodName);
		System.out.println("사용하는 인자: ");
		System.out.println("==========");
		for(Object v: args) {
			System.out.println(v);
	}
		System.out.println("===========");
		if(returnObj instanceof MemberVO) {
			MemberVO mvo= (MemberVO)returnObj;
			if(mvo.getRole().equals("ADMIN")) {
				System.out.println("관리자입니다.");
			}
			else {
				System.out.println("일반계정입니다.");
			}
		}
		System.out.println("핵심메서드의 반환값: "+returnObj);
	}
}
