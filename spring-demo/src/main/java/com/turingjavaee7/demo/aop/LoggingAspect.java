package com.turingjavaee7.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.turingjavaee7.demo.controller.CartController;

import lombok.extern.slf4j.Slf4j;  
  
@Configuration  
@Aspect  
@Slf4j
public class LoggingAspect {  
    
    @Before("execution(* com.turingjavaee7.demo.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint){  
        log.info("In Aspect before "+joinPoint.toString());  
    }  

    @After("execution(* com.turingjavaee7.demo.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint){  
        log.info("In Aspect After "+joinPoint.toString());  
    }  
    @Before("within(com.turingjavaee7.demo.controller..*)")
    public void withinBefore(JoinPoint joinPoint){  
        log.info("In Aspect within before "+joinPoint.toString());  
    }  
    @AfterReturning(
    		pointcut="execution(* com.turingjavaee7.demo.controller.*.*(..))",
    		returning="retVal")
	public void doAccessCheck(Object retVal) {
		log.info("In Aspect After Return RetValue "+retVal);
	}
    @AfterThrowing(value="execution(* com.turingjavaee7.demo.controller.*.*(..))",throwing = "exception")
		public void doRecoveryActions(Exception exception) {
    	log.info("In Aspect @AfterThrowing "+exception.getMessage());
	}
    @Around("execution(* com.turingjavaee7.demo.service.*.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    	log.info("In Aspect @Around before "+pjp.toString());
		
    	for(Object param : pjp.getArgs())
    	{
    		log.info("Paramter "+param);
    	}
    	log.info("Proxy "+ pjp.getThis());
    	log.info("Target "+ pjp.getTarget());
    	log.info("Siganture name "+ pjp.getSignature().getName());
    	log.info("getDeclaringType "+ pjp.getSignature().getDeclaringType());
    	Object retVal =null;
    	retVal = pjp.proceed();
		
		log.info("In Aspect @Around after "+pjp.toString() +" return "+retVal);
		return retVal;
	}
}