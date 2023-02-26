package de.demo.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.demo.aopdemo.Account;

@Aspect
@Component
@Order(4)
public class AspectDemoAfterReturningAdvice {
	
	@AfterReturning(pointcut = "de.demo.aopdemo.aspect.AspektPointCuts.returning()",returning = "result")
	public void beforeAddAccountAdviceTree(JoinPoint theJoinPoint, List<Account> result) {
		
		System.out.println("-----------------------------------------------");		
		System.out.println("-> [AfterReturning] AspectJoinPointDemoReadJP Advice");
		
		
		String method = theJoinPoint.getSignature().toString();
		
		
		
		System.out.println("-> method: " + method);
		System.out.println("\n-> loaded result is: " + result);

		
		// call post Processing
		convertAccountNamesToUpperCase(result);
		

		System.out.println("\n-> processed result is: " + result);
		System.out.println("-----------------------------------------------");		
		

	}
	
	// Function for post processing
	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts

		for (Account tempAccount : result) {
			
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}
	}

}

