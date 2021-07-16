package com.ak.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MethodLogAspect {

	@Around("@annotation(MethodLog) && execution(* com.ak..*(..))")
	public Object wrap(final ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[BEFORE] " + joinPoint);
		try {
			return joinPoint.proceed();
		} finally {
			System.out.println("[AFTER]  " + joinPoint);
		}
	}
}
