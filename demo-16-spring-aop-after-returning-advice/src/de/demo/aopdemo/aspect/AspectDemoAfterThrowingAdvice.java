package de.demo.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(3)
public class AspectDemoAfterThrowingAdvice {
	
	@AfterThrowing(pointcut = "de.demo.aopdemo.aspect.AspektPointCuts.returning()", throwing = "theExc")
	public void afterThrowingAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		System.out.println("...........................................");
		System.out.println("[AfterThrowing Advice]: Executing advice");
		System.out.println("[AfterThrowing Advice]: the exception is -> "+ theExc);
		System.out.println("...........................................");



	}
	
	

}

