package com.lim.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCommon {
	@Pointcut("execution(* com.lim.biz..*Impl.*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* com.lim.biz..*Impl.select*(..))")
	public void bPointcut() {}
}
