package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class CloadLogAspekt {
	@Before("de.demo.aopdemo.aspect.AspektPointCuts.forDaoPackage()")
	public void beforeAddAccountAdvice() {	
		System.out.println("-> [Ordered:4] CloadLogAspekt Advice");	
	}
}
