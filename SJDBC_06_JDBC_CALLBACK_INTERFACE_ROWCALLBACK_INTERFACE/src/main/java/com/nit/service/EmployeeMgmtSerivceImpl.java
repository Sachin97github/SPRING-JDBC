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
public class EmployeeMgmtSerivceImpl implements EmployeeMgmtService {

	@Autowired
	private EmployeeDAO empDAO;

	public List<EmployeeDTO> fetchEmpByNo(int deptno) {

		// use DAO
		List<EmployeeBO> listbo = empDAO.getEmpByDeptno(deptno);
		List<EmployeeDTO> listdto = new ArrayList();

		listbo.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public List<EmployeeDTO> fetchEmpByDesg(String desg) {
		// use DAO
		List<EmployeeBO> listbo = empDAO.getEmpByDesg(desg);
		List<EmployeeDTO> listdto = new ArrayList();

		listbo.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}

}
