package com.nit.service;

import java.util.ArrayList;
import java.util.List;

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

	public EmployeeServiceImpl() {

		System.out.println("=========EmployeeServiceImpl==========");
	}

	public EmployeeDTO findEmployee(int eno) {

		EmployeeDTO dto = new EmployeeDTO();
		EmployeeBO bo = null;

		bo = empDAO.getEmpByNo(eno);
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	public List<EmployeeDTO> findEmployeeByDesg(String desg1, String desg2) {

		final List<EmployeeDTO> listDTO = new ArrayList();
		List<EmployeeBO> listBO = null;

		listBO = empDAO.getEmpsByDesg(desg1, desg2);
		listBO.forEach(bo->
		{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});

		return listDTO;
	}
}
