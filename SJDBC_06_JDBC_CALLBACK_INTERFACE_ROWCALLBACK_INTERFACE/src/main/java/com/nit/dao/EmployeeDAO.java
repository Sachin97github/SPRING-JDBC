package com.nit.dao;

import java.util.List;

import com.nit.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public List<EmployeeBO> getEmpByDeptno(int deptno);
	public List<EmployeeBO> getEmpByDesg(String desg);

}
