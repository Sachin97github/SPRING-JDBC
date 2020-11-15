package com.nit.dao;

import java.util.List;

import com.nit.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public EmployeeBO getStudentByNO(int no);

	public List<EmployeeBO> getStudentsByDesg(String desg);
	
	public List<EmployeeBO> getStudentsBYDeptno(int deptno);

}
