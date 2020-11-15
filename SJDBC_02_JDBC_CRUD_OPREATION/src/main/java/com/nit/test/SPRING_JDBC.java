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

		/*
		 * try { System.out.println("ALL EMPLOYEES :: " + service.fetchEmpCount()); }
		 * catch (DataAccessException ex) { ex.getStackTrace(); }
		 * 
		 * System.out.println("------------------------");
		 * 
		 * try { System.out.println("EMPLOYEE NAME BY NO :: " +
		 * service.fetchEmpName(2)); } catch (DataAccessException ex) {
		 * ex.printStackTrace(); }
		 * 
		 * 
		 * System.out.println("------------------------");
		 * 
		 * try { System.out.println("EMPLOYEE DETAILS BY NO :: " +
		 * service.fetchEmpDetails(2)); } catch (DataAccessException ex) {
		 * ex.printStackTrace(); }
		 * 
		 * System.out.println("------------------------");
		 * 
		 * try { System.out.println("ALL EMPLOYEE DETAILS :: " 
		 * service.fetchEmpDetails()); } catch (DataAccessException ex) {
		 * ex.printStackTrace(); }
		 * 
		 */
		/*
		 * System.out.println("_____________________________");
		 * 
		 * System.out.println("UPDATION :: "+service.HikeEmpSalByPercentages(75000,(50/
		 * 100.f)));
		 */
		
		try
		{
			System.out.println("UPDATION  :: "+service.fireEmpBySalRange(70000, 80000));
		}
	
		 catch(DataAccessException ex)
		{
			 ex.printStackTrace();
		}
		
		((AbstractApplicationContext) ctx).close();

	}

}
