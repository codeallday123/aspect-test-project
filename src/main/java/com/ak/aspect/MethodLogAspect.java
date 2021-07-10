package com.ak.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MethodLogAspect {

	@Around("@annotation( MethodLog) && (execution(* com.ak.*(..)))")
	public Object wrap(final ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("***Aspect invoked before calling method***");
		
		final Object obj = joinPoint.proceed();
		
		System.out.println("***Aspect invoked after calling method***");
		
		return obj;
	}
}
