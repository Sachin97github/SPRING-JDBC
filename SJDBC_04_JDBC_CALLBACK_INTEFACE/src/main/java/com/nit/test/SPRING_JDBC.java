package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nit.service.EmployeeMgmtService;

public class SPRING_JDBC {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;

		ctx = new AnnotationConfigApplicationContext();
 ((AbstractApplicationContext) ctx).refresh();
		service = ctx.getBean("empService", EmployeeMgmtService.class);
		

            System.out.println(	service.fetchEmpByNO());	
		
		((AbstractApplicationContext) ctx).close();

	}

}
