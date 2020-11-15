package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.service.LoginMgmtService;

public class SIMPLE_JDBC_CALL {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=null;
		LoginMgmtService service=null;
		
     ctx=new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
     
     service=ctx.getBean("loginService",LoginMgmtService.class);
     
     try
     {
    	 System.out.println("---------------------------------------");
    	 
    	 System.out.println(service.signIn("SACHIN","SACHINEHA"));
    	 
    	 System.out.println("--------------------------------------");
     }
     catch(DataAccessException e)
     {
    	 e.printStackTrace();
     }
		
     ((AbstractApplicationContext) ctx).close();
		
		
		
		
		
	}

}
