package com.ph.sinonet.spring.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class ExceptionLogger {

	@Pointcut("execution(* com.ph.sinonet.spring..*(..))")
	public void genExceptionAdvice(){}

	
	@AfterThrowing(pointcut="genExceptionAdvice()",throwing="exception")
	public void afterThrowingOfException(JoinPoint jp, Throwable exception){

	}
	
	
}
