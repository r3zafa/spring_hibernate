package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectPointCutCombining {
	
	
/*
 * combining pointcuts
 */

	
	// first pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.addTo*(..))")
	 private void addTo(){}	
	
	 // second pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.get*(..))")
	 private void getter(){}	
	
	 // 3rd pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.set*(..))")
	 private void setter(){}	
	
	 // 4rd pointcut
	 @Pointcut("execution(* de.demo.aopdemo.dao.*.addAccount(..))")
	 private void addAccount(){}	
	
	 
	 @Pointcut("(getter() && setter()) || !addTo()")
	 private void combined(){}	
	 
	 @Pointcut("addTo() || getter() || setter()")
	 private void combinedTwo(){}	
	
	
	 
	 
	@Before("combined()")
	public void beforeAddAccountAdvice() {	
		System.out.println("===> [9] pointcut (and) combination. setter() and getter()");	
	}
	
	@Before("combinedTwo()")
	public void beforeAddAccountAdviceTwo() {
		System.out.println("===> [10] pointcut (or) combination. ANY or getter() or setter()");	
	}
	
	@Before("!addTo() && !(getter() || addAccount())")
	public void beforeAddAccountAdviceTree() {
		
		System.out.println("===> [11] pointcut (&& !) combination. ANY and (!getter() || !addAccount())");
		
	}

}
