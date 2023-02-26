package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectOnReturnType {
	
	
	@Before("execution(boolean add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("===> [4] Execute On Return Type Boolean \n#### " + getClass() + 
				"\n#### Executing @Before\n");
	}
	
	

}
