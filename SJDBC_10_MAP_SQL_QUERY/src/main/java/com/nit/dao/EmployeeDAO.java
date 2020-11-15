package com.nit.dao;

import java.util.List;

import com.nit.bo.EmployeeBO;

public interface EmployeeDAO {
	public EmployeeBO getEmpByNo(int eno);
	
	public List<EmployeeBO> getEmpsByDesg(String desg1,String desg2);

}
