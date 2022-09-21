package com.lim.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// around에서 사용되어야하는 advice는 반드시 pjt라는 input을 가져야한다.
// ex) .필터 서블릿 클래스
@Service //Impl 클래스를 사용하기 떄문에 서비스류라고 알려주기위해 @Service 사용
@Aspect
public class AroundAdvice {
	
	@Around("PointCommon.bPointcut()")
	public Object printLogAround(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		System.out.println("수행중인 핵심메서드명2: "+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start();
		Object returnObj= pjp.proceed(); // 수행해야할 포인트컷
		//pjp.proceed()에 의행 비즈니스메서드가 수행됨
		sw.stop();
		System.out.println("수행시간2 : "+sw.getTotalTimeMillis()+"ms");
		return returnObj;
	}
}

