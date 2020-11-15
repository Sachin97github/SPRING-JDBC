package com.nit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.bo.EmployeeBO;
import com.nit.dao.EmployeeDAO;
import com.nit.dto.EmployeeDTO;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO empDAO;

	public String addEmployee(EmployeeDTO dto) {

		int count = 0;
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);

		// count = empDAO.insert(bo);
 
		count=empDAO.insert_with_MAP(bo);
		
		return count != 0 ? "Registration Succeded" : "Registration Falied";
	}

}
