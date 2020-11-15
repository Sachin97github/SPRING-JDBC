package com.nit.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements BankDAO {

	private final static String SET_BAL_BY_RANGE="UPDATE BANK_LIST SET BALANCE=BALANCE+:AMT  WHERE BALANCE>=:START AND BALANCE <=:END";

	
	private SalaryUpdator updator;
	
	public BankDAOImpl(DataSource ds) {
		updator=new SalaryUpdator(ds,SET_BAL_BY_RANGE);
	}

	public int setBalanceByRange(float amt,float start, float end) {
	
		int count;
		Map <String,Object> paramsMap=new HashMap();
		
		paramsMap.put("AMT",amt);
		paramsMap.put("START",start);
		paramsMap.put("END",end);
		count=updator.updateByNamedParam(paramsMap);
		return count;
	}

	class SalaryUpdator extends SqlUpdate
	{

		public SalaryUpdator(DataSource ds, String sql) {
			super(ds, sql);
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
	        super.compile();
		}	
	}
	
}
