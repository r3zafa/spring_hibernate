package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectPointCutDeclaration {
	
	
/*
 * Pointcut declaration
 * 1- Defining a pointcut as method and reuse it in multiple places
 * Example:
 * 1- define
 * @Pointcut("execution(* de.demo.aopdemo.dao.*.*(..))")
 * private void forDaoPackage(){}
 * 2-use
 * @Before("forDaoPackage()")
 * public void beforAddAccountAdvice(){
 * ...
 * }
 */

	 @Pointcut("execution(* de.demo.aopdemo.dao.*.*(..))")
	 private void forDaoPackage(){}	
	
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("===> [8] Pointcut declaration :: forDaoPackage() :: Reusable \n--> " + getClass() + 
				"\n");
		
	}
	
	

}
