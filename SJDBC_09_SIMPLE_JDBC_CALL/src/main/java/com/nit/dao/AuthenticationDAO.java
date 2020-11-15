package com.nit.dao;

import java.util.Map;

public interface AuthenticationDAO {
	
	public Map<String,Object> validate(String  uname,String pword);

}
