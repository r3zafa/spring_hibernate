package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticAspect {
	@Before("de.demo.aopdemo.aspect.AspektPointCuts.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("-> [Ordered:3] ApiAnalyticAspect Advice");	
	}
}
