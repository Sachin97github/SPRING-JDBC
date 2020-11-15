package com.nit.service;

import java.util.List;

import com.nit.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	
	public List<EmployeeDTO> fetchEmpByNo(int deptno);
	public List<EmployeeDTO> fetchEmpByDesg(String desg);

}
