package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingDemoAspectDemo {
	@Before("de.demo.aopdemo.aspect.AspektPointCuts.combined()")
	public void beforeAddAccountAdviceTree() {
		System.out.println("-> [Ordered:2] LoggingDemoAspectDemo Advice");
	}
}
