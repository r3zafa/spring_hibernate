package de.demo.aopdemo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemoAroundFortuneAdviceRethrow {
	
	@Around("de.demo.aopdemo.aspect.AspektPointCuts.getFortune()")
	public Object foundAroundAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n\n  [Around Fortune Advice] Executing @Around on method: " + method);
		
		
		// preprocessing
		// get begin time stamp
        System.out.println("\n\n  [Around Fortune Advice] preprocessing ...\n");
        long start = System.currentTimeMillis();
        System.out.println("  [Start time: "+ start + " ms]\n");
        
        
        
        Object result = null;
        // executing method        
        try {
        	
        	
        	result = theProceedingJoinPoint.proceed();
			
        	// error/Exception handling
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\n\n  [Around Fortune Advice Rethrow Exception] " + e.getMessage());

			throw e;
		}
        
        
        
        
        
        
        
        
        
        
        
        // pastprocessing
        // get end time stamp
        long end = System.currentTimeMillis();
        System.out.println("  [End time: " + end + " ms]\n");
        // compute duration and display it
        double duration = (end - start)/ 1000.0;
        System.out.println("  [Duration " + duration + " s]\n");


        System.out.println("  [Around Fortune Advice] exiting ...\n\n");
        
        return result;


	}		
}

