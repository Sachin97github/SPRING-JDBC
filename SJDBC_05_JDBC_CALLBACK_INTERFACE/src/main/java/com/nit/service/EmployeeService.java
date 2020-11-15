package com.nit.service;

import java.util.List;

import com.nit.dto.EmployeeDTO;

public interface EmployeeService {
	public EmployeeDTO fetchEmpByNo(int no);
	public List<EmployeeDTO> fetchEmpByDesg(String desg);

}
