package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.service.EmployeeMgmtService;

public class SPRING_JDBC {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;

		ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		service = ctx.getBean("empService", EmployeeMgmtService.class);

		try {
			System.out.println(service.fetchEmpCount());
		} catch (DataAccessException ex) {
			ex.getStackTrace();
		}
		
		System.out.println("-----------------------------");

		((AbstractApplicationContext) ctx).close();

	}

}
