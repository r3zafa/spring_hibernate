package de.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectOnAnyReturnType {
	
	
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("===> [5] Execute On Any Return Type * \n#### " + getClass() + 
				"\n#### Executing @Before\n");
	}
	
	

}
