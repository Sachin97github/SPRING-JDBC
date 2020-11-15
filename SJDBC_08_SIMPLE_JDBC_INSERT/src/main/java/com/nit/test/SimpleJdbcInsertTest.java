package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.dto.EmployeeDTO;
import com.nit.service.EmployeeService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {

		ApplicationContext ctx = null;
		EmployeeService empService = null;
		EmployeeDTO dto = new EmployeeDTO();

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		empService = ctx.getBean("empService", EmployeeService.class);

		try {
			dto.setEno(46);
			dto.setEname("ASHISH PATEL");
			dto.setSal(7665.0d);
			dto.setDesg("ENG");
			dto.setDeptno(5);
			
			System.out.println(empService.addEmployee(dto));
		} 
		catch (DataAccessException e) {
			e.printStackTrace();
		}

	}
}
