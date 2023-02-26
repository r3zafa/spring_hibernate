package de.demo.aopdemo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemoAroundAdvice {
	
	@Around("de.demo.aopdemo.aspect.AspektPointCuts.returning()")
	public Object foundAroundAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n\n  [Around Fortune Advice] Executing @Around on method: " + method);
		
		// preprocessing
		// get begin time stamp
        System.out.println("\n\n  [Around Advice] preprocessing ...\n");
        long start = System.currentTimeMillis();
        System.out.println("  [Start time: "+ start + " ms]\n");
        // executing method
        Object retval = theProceedingJoinPoint.proceed();
        
        // pastprocessing
        // get end time stamp
        System.out.println("  [Around Advice] pastprocessing ...\n");
        long end = System.currentTimeMillis();
        System.out.println("  [End time: " + end + " ms]\n");
        // compute duration and display it
        double duration = (end - start)/ 1000.0;
        System.out.println("  [Duration " + duration + " s]\n");


        System.out.println("  [Around Advice] exiting ...\n");
    
		
		
		
		
		
		return retval;
	}		
}

