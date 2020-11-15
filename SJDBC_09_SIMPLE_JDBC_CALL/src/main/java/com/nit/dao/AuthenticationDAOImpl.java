package com.nit.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authenDAO")
public class AuthenticationDAOImpl implements AuthenticationDAO{
	
	@Autowired
	private SimpleJdbcCall sji;

	public Map<String, Object> validate(String uname, String pword) {

		Map <String,Object> outParam=null;
		MapSqlParameterSource sps=new MapSqlParameterSource();
	
	    sps.addValue("uname","SACHIN");
	    sps.addValue("pass","SACHINEHA");
		
		sji.setProcedureName("PRO");
		
		 return sji.execute(sps);
		 //return Map<String,Object>
		 //Contains
	}

}
