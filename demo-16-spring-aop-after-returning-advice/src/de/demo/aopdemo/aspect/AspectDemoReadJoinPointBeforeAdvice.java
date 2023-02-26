package de.demo.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AspectDemoReadJoinPointBeforeAdvice {
	
	@Before("de.demo.aopdemo.aspect.AspektPointCuts.add()")
	public void beforeAddAccountAdviceTree(JoinPoint theJoinPoint) {
		
		System.out.println("-----------------------------------------------");		
		System.out.println("-> [::Before::] AspectJoinPointDemoReadJP Advice");
		
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

