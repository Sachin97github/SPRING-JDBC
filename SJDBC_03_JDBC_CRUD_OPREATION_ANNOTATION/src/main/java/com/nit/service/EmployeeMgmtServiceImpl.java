package com.nit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.EmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
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

	public String fetchEmpName(int eno) {
		// Use DAO
		String name = null;
		name = empDAO.getEmployeeNameByNo(eno);
		return name;
	}

	public Map<String, Object> fetchEmpDetails(int eno) {
		Map<String, Object> map = null;

		map = empDAO.getEmployeeDetailsByNo(eno);

		return map;
	}

	public List<Map<String, Object>> fetchEmpDetails() {
		List<Map<String, Object>> listMap = null;
		listMap = empDAO.getAllEmployeeDetails();

		return listMap;
	}

	public String HikeEmpSalByPercentages(float salRange, float percentages) {

		int count = 0;
		// useDAO
		count = empDAO.updateEmpSalByRange(salRange, percentages);
		if (count > 0)
			return count + " NO. OF ROWS ARE AFFECTED";
		else
			return "NO ROWS ARE AFFECTED";
	}

	public String fireEmpBySalRange(float start, float end) {

		int count = 0;
		count = empDAO.deleteEmpBySalRange(start, end);
		if (count > 0)
			return count + " NO OF ROWS ARE AFFECTED";
		else
			return "ZERO ROWS ARE AFFECTED";
	}
}
