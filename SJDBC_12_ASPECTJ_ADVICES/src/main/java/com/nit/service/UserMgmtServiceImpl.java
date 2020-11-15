package com.nit.service;

import org.springframework.beans.BeanUtils;

import com.nit.bo.UserDetailsBO;
import com.nit.dao.UserMgmtDAO;
import com.nit.dto.UserDetailsDTO;

public class UserMgmtServiceImpl implements UserMgmtService {
	
	private UserMgmtDAO dao=null;
	
	
	//Constructor Inejection
    public UserMgmtServiceImpl(UserMgmtDAO dao) {
		super();
		this.dao = dao;
	}

	public boolean addCustomer(UserDetailsDTO dto) {
		int count;
		UserDetailsBO bo=new UserDetailsBO();
		BeanUtils.copyProperties(dto,bo);
		count= dao.addUser(bo);
		 
		return count!=0?true:false;
	}

	public UserDetailsDTO checkCustomerDetails(long accNo) {
        
		UserDetailsDTO dto=null;
		UserDetailsBO bo=null;
		dto=new UserDetailsDTO();
		bo=dao.checkUserDetails(accNo);
		BeanUtils.copyProperties(bo,dto);		
		return dto;
	}

	public boolean withdraw(long accNo, double money) {
		int count;
		System.out.println(" CLASS :: "+this.getClass().getName()+" SUPER CLASS :: "+this.getClass().getSuperclass() );
		count=dao.withdraw(accNo, money);
		return count!=0?true:false;
	}

	public boolean deposite(long accNo, double money) {
		int count;
		System.out.println(" CLASS :: "+this.getClass().getName()+" SUPER CLASS :: "+this.getClass().getSuperclass() );
		count=dao.deposite(accNo, money);
		return count!=0?true:false;
	}

	public boolean transferMoney(long srcAccNo, long destAccNo ,double money) {
		  return dao.transferMoney(srcAccNo, destAccNo, money);
	}

	public boolean removeCustomer(long accNo) {
		 int count;
		count=dao.removeUser(accNo);
		return count!=0?true:false;
	}

}
