package com.nit.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceAspect {
	
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable
	{
		Object ratVal=null;
	    long start,end;
	    start=System.currentTimeMillis();
	    ratVal=pjp.proceed();
	    end=System.currentTimeMillis();
	    
	    System.out.println(pjp.getSignature()+" TOOK EXECUTION TIME :: "+(end-start)+" ms");		
		return ratVal;
	}

}
