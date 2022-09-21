package com.lim.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //Impl 클래스를 사용하기 떄문에 서비스류라고 알려주기위해 @Service 사용
@Aspect //횡단관심사로 설정된 서비스라는걸 알려주기위해
public class LogAdvice {
	
	
	@After(value="PointCommon.aPointcut()")
	public void printlog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		// 현재 수행중인 포인트컷(핵심로직,CRUD)의 메서드명
		Object[] args=jp.getArgs();
		// 현재 수행중인 포인트컷(핵심로직,CRUD)이 사용하는 인자들의 정보
		System.out.println("수행중인 핵심메서드명: "+methodName);
		System.out.println("사용하는 인자: ");
		for(Object v: args) {
			System.out.println(v);
		}
	}
	public void printlog2() {
		System.out.println("데이터를 탐색합니다...");
	}
	public void printlog3() {
		System.out.println("데이터가 성공적으로 등록되었습니다.");
	}
}
