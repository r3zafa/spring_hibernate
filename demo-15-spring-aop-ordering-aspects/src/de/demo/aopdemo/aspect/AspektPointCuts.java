package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspektPointCuts {
	
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.*(..))")
	 public void forDaoPackage(){}	
	

		// first pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.addTo*(..))")
	 public void addTo(){}	
	
	 // second pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.get*(..))")
	 public void getter(){}	
	
	 // 3rd pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.set*(..))")
	 public void setter(){}	
	 
	 
	 @Pointcut("(!getter() && !setter()) || !addTo()")
	 public void combined(){}	
	 
}
