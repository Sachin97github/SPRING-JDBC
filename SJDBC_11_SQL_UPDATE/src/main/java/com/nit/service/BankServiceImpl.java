package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDAO dao;
	
	public String updateBalance(float amt, float start, float end) {
		int count;
		count=dao.setBalanceByRange(amt, start, end);
	
		return count>0?"UPDATED":"NOT UPDATED";

	}

}
