package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectOnOneParameterType {
	
	
/*
 * For Param-pattern
 * () matches a method with no argument
 * (*) matches a mrthod with one argument of any type
 * (..) matches a method with 0 or more arguments of any type
 */

	
	
	
	@Before("execution(public void *(*))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("===> [7] One Parameter of any Type \n#### " + getClass() + 
				"\n#### Executing @Before\n");
		
	}
	
	

}
