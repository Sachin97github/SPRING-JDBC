package com.nit.dto;

import java.io.Serializable;

public class UserDetailsDTO implements Serializable {
	

	private long accNo;
	private String username;
	private String password;
	private String name;
    private String accType;
    private double balance;
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserDetailsDTO [accNo=" + accNo + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", accType=" + accType + ", balance=" + balance + "]";
	}
	 
    
	
}
