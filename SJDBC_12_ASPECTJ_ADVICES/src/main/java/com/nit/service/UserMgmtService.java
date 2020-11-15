package com.nit.service;

import com.nit.dto.UserDetailsDTO;

public interface UserMgmtService {
 
	public boolean addCustomer(UserDetailsDTO dto);
	
	public UserDetailsDTO checkCustomerDetails(long accNo);
	
	public boolean withdraw(long accNo,double money);
	
	public boolean deposite(long accNo,double money);
	
	public boolean transferMoney(long srcAccNo,long destAccNo,double money);
	
	public boolean removeCustomer(long accNo);	
	
}
