package com.nit.dao;

import com.nit.bo.EmployeeBO;

public interface EmployeeDAO {
	public int insert(EmployeeBO bo);
	public int insert_with_MAP(EmployeeBO bo);
}
