package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspektPointCuts {
	
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.*(..))")
	 public void forDaoPackage(){}	
	
	 
	 @Pointcut("execution(* de.demo.aopdemo.service.*.getFortune(..))")
	 public void getFortune(){}	

	 @Pointcut("execution(* de.demo.aopdemo.service.*.getFortuneRethrowException(..))")
	 public void getFortuneRethrowException(){}	
	 
	 
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.find*(..))")
	 public void find(){}	

	 @Pointcut("find()")
	 public void returning(){}	
	 

}
