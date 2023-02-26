package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectOnAny {
	
	
	// all of our related advises for logging
	
	
	// @Before(PointCut expression) advice
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("===> [3] ANY with Add* method \n#### " + getClass() + 
				"\n#### Executing @Before\n");
		
	}
	
	

}
