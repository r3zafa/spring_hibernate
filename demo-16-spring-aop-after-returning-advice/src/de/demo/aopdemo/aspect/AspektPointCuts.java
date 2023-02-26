package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspektPointCuts {
	
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.*(..))")
	 public void forDaoPackage(){}	
	

		// first pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.add*(..))")
	 public void add(){}	
	
	 // 2nd pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.get*(..))")
	 public void getter(){}	
	
	 // 3rd pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.find*(..))")
	 public void find(){}	
	
	 
	 // 4rd pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.set*(..))")
	 public void setter(){}	
	 
	 // 5rd pointcut
	 @Pointcut("getter() || find()")
	 public void returning(){}	
	 
	 
	 @Pointcut("(!getter() && !setter()) || !add()")
	 public void combined(){}	
	 
}
