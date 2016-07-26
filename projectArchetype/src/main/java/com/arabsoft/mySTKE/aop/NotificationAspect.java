package com.arabsoft.mySTKE.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NotificationAspect {

	@Pointcut("execution(* com.arabsoft.mySTKE.controller.*.*Notifier(..))")
	public void pc(){}
	
	@After("pc()")
	public void notifier(){
		
	}
	
}
