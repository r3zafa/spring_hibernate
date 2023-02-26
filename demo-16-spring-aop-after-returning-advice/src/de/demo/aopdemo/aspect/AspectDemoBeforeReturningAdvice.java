package de.demo.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AspectDemoBeforeReturningAdvice {
	
	@Before("de.demo.aopdemo.aspect.AspektPointCuts.returning()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("-----------------------------------------------");		
		System.out.println("-> [BeforeReturning] AspectJoinPointDemoReadJP Advice");
		
		MethodSignature mSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("-> method: " + mSig);
		Object[] args = theJoinPoint.getArgs();
		// loop and print
		System.out.println("-> Arguments:");
		int index = 0;
		for (Object tempArg : args) {
			index ++;
			System.out.println(index + ".Arg: " + tempArg );
		}
		System.out.println("-----------------------------------------------");		
	}		
}

