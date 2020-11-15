package com.nit.dao;

import com.nit.bo.UserDetailsBO;

public interface UserMgmtDAO {
	
	public int addUser(UserDetailsBO bo);
	
	public UserDetailsBO checkUserDetails(long accNo);
	
	public int withdraw(long accNo,double money);
	
	public int deposite(long accNo,double money);
	
	public boolean transferMoney(long srcAccNo,long destAccNo,double money);
	
	public int  removeUser(long accNo);

}
