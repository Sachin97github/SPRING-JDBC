package com.nit.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.AuthenticationDAO;

@Service("loginService")
public class LoginMgmtServiceImpl implements LoginMgmtService {

	@Autowired
	private AuthenticationDAO authenDAO;
	
	public String signIn(String uname, String pword) {
	
		Map<String,Object> outParam=null;
		
		outParam=authenDAO.validate(uname, pword);	
		
		String result=(String)outParam.get("RESULT");
	 
		return result;
	}

}
