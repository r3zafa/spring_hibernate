package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	
	// all of our related advises for logging
	
	
	// @Before(PointCut expression) advice
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {

		System.out.println("===> [1] ANY with addAccount method \n#### " + getClass() + 
				"\n#### Executing @Before\n");
		
		
	}
	
	

}
