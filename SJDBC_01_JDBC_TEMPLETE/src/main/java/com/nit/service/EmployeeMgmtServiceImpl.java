package com.nit.service;

import com.nit.dao.EmployeeDAO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	private EmployeeDAO empDAO;
	

	public EmployeeMgmtServiceImpl(EmployeeDAO empDAO) {
		System.out.println("EmployeeMgmtServiceImpl.EmployeeMgmtServiceImpl()");
		this.empDAO = empDAO;
	}


	public int fetchEmpCount() {
		int count;
		count = empDAO.getEmployeeCount();

		return count;
	}

}
