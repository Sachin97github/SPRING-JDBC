package com.nit.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nit.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SimpleJdbcInsert sji;

	public int insert(EmployeeBO bo) {

		BeanPropertySqlParameterSource bpsp = null;

		sji.setTableName("EMP");

		// Map BO object
		bpsp = new BeanPropertySqlParameterSource(bo);


		// return Zero if not updated
		return sji.execute(bpsp);
	}
	
	
	public int insert_with_MAP(EmployeeBO bo)
	{
		int count;
		Map<String,Object> map=null;
		
		map=new HashMap();
	
		map.put("eno",bo.getEno());
		map.put("ename",bo.getEname());
		map.put("sal",bo.getSal());
		map.put("desg",bo.getDesg());
		map.put("deptno",bo.getDeptno());
		
		sji.setTableName("EMP");
		count=sji.execute(map);
		
		return count;
	}

}
