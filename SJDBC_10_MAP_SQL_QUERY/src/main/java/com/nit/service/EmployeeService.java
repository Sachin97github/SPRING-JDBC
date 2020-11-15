package com.nit.service;

import java.util.List;

import com.nit.dto.EmployeeDTO;

public interface EmployeeService {
	public EmployeeDTO findEmployee(int eno);
	public List<EmployeeDTO> findEmployeeByDesg(String desg1,String desg2);

}
