package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectOnSpecificClasses {
	
	
	// all of our related advises for logging
	
	
	// @Before(PointCut expression) advice
	@Before("execution(public void de.demo.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("===> [2] Specific CLASSES with AddAccount() \n#### " + getClass() + 
				"\n#### Executing @Before\n");
	}
	
	

}
