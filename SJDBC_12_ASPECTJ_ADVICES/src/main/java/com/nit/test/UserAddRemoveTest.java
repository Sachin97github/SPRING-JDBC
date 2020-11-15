package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.dto.UserDetailsDTO;
import com.nit.service.UserMgmtService;

public class UserAddRemoveTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		UserMgmtService service = null;
		UserDetailsDTO dto = null;
		boolean status;

		ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		service = ctx.getBean("userService", UserMgmtService.class);
		System.out.println("XML CHECKED \n SERVICE INITILIZED");

		
		/*
		 * dto=new UserDetailsDTO(); dto.setAccNo(123456789); dto.setUsername("GEEK");
		 * dto.setPassword("GEEK"); dto.setName("ASHISH PATEL");
		 * dto.setAccType("SAVING"); dto.setBalance(850000);
		 * status=service.addCustomer(dto); if(status)
		 * System.out.println("CUSTOMER ADDED"); else System.out.println("NOT ADDED");
		 */

		/*
		 * ============DELETE CUSTOMER=================
		 * status=service.removeCustomer(12345678); if(status)
		 * System.out.println("CUSTOMER DELETED"); else
		 * System.out.println("CUSTOMER NOT DELETED");
		 */

		/*
		 * =============ONE CUSTOMER FETCH===============
		 * dto=service.checkCustomerDetails(1234); System.out.println(dto);
		 */

		
		  //=============WITH DRAW AND DEPOSITE============
		 // dto=service.checkCustomerDetails(1234);
		//  System.out.println("===========BEFORE DEPOSITE===========");
		//  System.out.println("NAME :: "+dto.getName()+" BALANCE :: "+dto.getBalance());
		 
		//service.deposite(123456789,000);
		//service.withdraw(12345678,30000);
		 
		/*
		 * System.out.println("===========AFTER DEPOSITE=============");
		 * dto=service.checkCustomerDetails(1234);
		 * System.out.println("NAME :: "+dto.getName()+" BALANCE :: "+dto.getBalance());
		 * 
		 * dto=service.checkCustomerDetails(1234);
		 * System.out.println("===========BEFORE WITHDRAW==========");
		 * System.out.println("NAME :: "+dto.getName()+" BALANCE :: "+dto.getBalance());
		 * service.withdraw(1234,5);
		 * System.out.println("============AFTER WITHDRAW==========");
		 * dto=service.checkCustomerDetails(1234);
		 * System.out.println("NAME :: "+dto.getName()+" BALANCE :: "+dto.getBalance());
		 */
   
		/*  ==============TRANSFER MONEY=========================
 		 * status=service.transferMoney(12345678,123456789, 40000); if(status)
		 * System.out.println("SUCESS"); else System.out.println("FAILED");
		 */
		
	}
}
