package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.bo.EmployeeBO;
import com.nit.dao.EmployeeDAO;
import com.nit.dto.EmployeeDTO;

@Repository("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO empDAO = null;
	
	

	public EmployeeServiceImpl(EmployeeDAO empDAO) {
		super();
		this.empDAO = empDAO;
	}



	public EmployeeDTO fetchEmpByNo(int no) {

		EmployeeBO bo = null;
		EmployeeDTO empDTO = null;
		bo = empDAO.getStudentByNO(no);
        BeanUtils.copyProperties(bo, empDTO);
        return empDTO;
    };

    
    public List<EmployeeDTO> fetchEmpByDesg(String desg) {
    	
    	List<EmployeeBO> listBO=null;
    	List<EmployeeDTO> listDTO=null;
    	
       	listDTO=new ArrayList();
        listBO=empDAO.getStudentsByDesg(desg);
        BeanUtils.copyProperties(listBO, listDTO);
        
        return listDTO;
    }
}
