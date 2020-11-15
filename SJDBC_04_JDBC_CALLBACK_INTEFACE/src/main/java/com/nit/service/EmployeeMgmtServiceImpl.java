package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.bo.EmployeeBO;
import com.nit.dao.EmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
	private EmployeeDAO empDao=null;
	
	
	public EmployeeBO fetchEmpByNO() {
	
		EmployeeBO bo=null;
		
		bo=empDao.getEmployeeByNo(2);		
		
		return bo;
	}
}
