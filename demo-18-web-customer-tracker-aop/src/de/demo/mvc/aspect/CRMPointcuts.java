package de.demo.mvc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CRMPointcuts {
	
	
	// setup pointcut
	@Pointcut("execution(* de.demo.mvc.controller.*.*(..))")
	public void  forControllerPackage() {};
	
	@Pointcut("execution(* de.demo.mvc.service.*.*(..))")
	public void  forServicePackage() {};	
	
	@Pointcut("execution(* de.demo.mvc.dao.*.*(..))")
	public void  forDaoPackage() {};
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void  forAppFlow() {};

}
