package com.nit.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.dto.EmployeeDTO;
import com.nit.service.EmployeeService;

public class CallBackInterfaceTEST {

	public static void main(String[] args) {

		ApplicationContext ctx = null;
		EmployeeService service = null;
		List<EmployeeDTO> listDTO=null;
		
		ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		service = ctx.getBean("empService", EmployeeService.class);

		try {
			/*dto = service.fetchEmpByNo(4);
			System.out.println(dto);*/
			System.out.println("_------------------------------_");
			
			listDTO=service.fetchEmpByDesg("'DEV'");
			
			System.out.println(listDTO);
			
			listDTO.forEach((dto2)->System.out.println(dto2));

			
			
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();
		
	}

}
