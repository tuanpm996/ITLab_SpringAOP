package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeMethod{
	private boolean isNumber = false;
	
	@Before("execution(* com.example.demo.*.*(..))")
	public void beforeAdvise(JoinPoint joinPoint){
		String param1 = (String)joinPoint.getArgs()[0];
		String param2 = (String)joinPoint.getArgs()[1];
		if(param1.matches("-?\\d+") && param2.matches("-?\\d+")) {
			this.isNumber = true;
		} else {
			this.isNumber = false;
		}
	}
	
	@Around("execution(* com.example.demo.*.*(..))")
	public Object beforeReturn(ProceedingJoinPoint joinPoint) throws Throwable{
		Object obj = joinPoint.proceed();
		return this.isNumber ? obj : "N/A";
	}
	
}
