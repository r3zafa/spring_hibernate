package de.demo.aopdemo.aspect;

import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;






@Aspect
@Component
@Order(5)
public class AspectJoinPointDemoReadJP {
	
	
	@Before("de.demo.aopdemo.aspect.AspektPointCuts.addTo()")
	public void beforeAddAccountAdviceTree(JoinPoint theJoinPoint) {
		
		System.out.println("-----------------------------------------------");		
		System.out.println("-> [Ordered:5] AspectJoinPointDemoReadJP Advice");
		
		// display the method signature
		MethodSignature mSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("-> method: " + mSig);
		
		// display method arguments
		// get arguments
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

