package com.nit.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.dao.DataAccessException;

public class LoggingAspect {
	
	private static Logger logger=(Logger) Logger.getInstance(LoggingAspect.class);
	
	static
	{
		PropertyConfigurator.configure("src/main/java/com/nit/commons/log4j.properties");
		
	}
	
	public Object logging(ProceedingJoinPoint pjp) throws Exception
	{
		Object ratVal=null;
		logger.info("{Request came} Parameters :: "+Arrays.deepToString(pjp.getArgs()));
		System.out.println("{Request came} Parameters :: "+Arrays.deepToString(pjp.getArgs()));
		try {
			ratVal=pjp.proceed();
		} catch (Throwable e) {
			logger.fatal("Unknown Error",e);
			e.printStackTrace();
		}
		logger.info("{Executed } Result :: "+ratVal);	
		System.out.println("{Executed } Result :: "+ratVal);
		return ratVal;
	}

}
