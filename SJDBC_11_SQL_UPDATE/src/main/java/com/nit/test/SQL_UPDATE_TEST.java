package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.service.BankService;

public class SQL_UPDATE_TEST {

	public static void main(String[] args) {
		
		ApplicationContext ctx=null;
		BankService service=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		service=ctx.getBean("bankService",BankService.class);
	
		try
		{
			System.out.println(service.updateBalance(510.0f,60000,70000));
		}
		catch(Exception ex)
		{
	     			ex.printStackTrace();
		}
		
	}
}
