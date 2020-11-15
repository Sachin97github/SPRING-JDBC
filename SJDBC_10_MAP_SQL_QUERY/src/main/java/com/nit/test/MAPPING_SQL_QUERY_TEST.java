package com.nit.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.dto.EmployeeDTO;
import com.nit.service.EmployeeService;

public class MAPPING_SQL_QUERY_TEST {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		
		//XML to ApplicationContext 
		ctx=new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		System.out.println("==========ApplicationContext Initailized==========");
		
		service=ctx.getBean("empService",EmployeeService.class);
		
		System.out.println("==========Service Intialized======================");
		try
		{
			//dto=service.findEmployee(45);
			
			listDTO=service.findEmployeeByDesg("DEV","ENG");
			
			listDTO.forEach(System.out::println);
		}
		
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		

		System.out.println("=============End of methods===============");
		((AbstractApplicationContext) ctx).close();
		
		
	}
}
