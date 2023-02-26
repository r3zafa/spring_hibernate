package de.demo.mvc.aspect;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	/* 
	 * qualified name for PointCuts from CRMPointcuts class
	 * -------------------------------------------------------
	 * de.demo.mvc.aspect.CRMPointcuts.forControllerPackage()
	 * de.demo.mvc.aspect.CRMPointcuts.forServicePackage()
	 * de.demo.mvc.aspect.CRMPointcuts.forDaoPackage()
	 * de.demo.mvc.aspect.CRMPointcuts.forAppFlow()
	*/
	
	
	// add @Before advice
	@Before("de.demo.mvc.aspect.CRMPointcuts.forAppFlow()")
	public void before(JoinPoint theJoinpoint) {
		String theMethod = theJoinpoint.getSignature().toShortString();
		String className = getClass().getName();
		Object[] args = theJoinpoint.getArgs();	
		//display called method and arguments passed to them 
		beforFileLogging("Before","AppFlow",theMethod, className, args);
	}
	
	
	
	// add @AfterReturning advice
	@AfterReturning(pointcut = "de.demo.mvc.aspect.CRMPointcuts.forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		//String className = getClass().getName();
		// display method and data returned from them
		afterReturningFileLogging("AfterReturning","AppFlow",theMethod, theResult);
		
	}
	
	
	
	
	
	
	
	
	// setup logger methods
	public void beforFileLogging(String methodType,String loggerName, String theMethod, String className, Object[] args) {
		
	    final Logger logger = Logger.getLogger(loggerName);
	    logger.setUseParentHandlers(false);
	    FileHandler fh = null;
	    String path = "/Users/r3zafa/log/BeforeEvents - CustomerTracker.log" ;
        String argTemp = null;
        for (Object temp : args) {argTemp = "arg -> " + temp + ", " ;}
        try {fh = new FileHandler(path, true);} catch (Exception e) { e.printStackTrace(); }
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.info("\n[@"+ methodType +" Advice] FROM " + theMethod + " [Class] "+ className + 
        		" [Arguments] " + argTemp + "\n" + "-----------------------------------------------------------\n");
        for(Handler h:logger.getHandlers()) { h.close();} //must call h.close or a .LCK file will remain.

	} 
	
	public void afterReturningFileLogging(String methodType,String loggerName, String theMethod, Object result) {

	    final Logger logger = Logger.getLogger(loggerName);
	    logger.setUseParentHandlers(false);
	    FileHandler fh = null;
	    String path = "/Users/r3zafa/log/AfterReturnEvents - CustomerTracker.log" ;
        try {fh = new FileHandler(path, true);} catch (Exception e) { e.printStackTrace(); }
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.info("\n[@"+ methodType +" Advice] FROM " + theMethod + "\n[Result] " + result + "\n"
        		+ "-----------------------------------------------------------\n");

        for(Handler h:logger.getHandlers()) { h.close();} //must call h.close or a .LCK file will remain.

	} 



}







