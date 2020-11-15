package com.nit.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

	public int getEmployeeCount();
	public String getEmployeeNameByNo(int eno);
	public Map<String,Object> getEmployeeDetailsByNo(int eno);
    public List<Map<String,Object>> getAllEmployeeDetails();
    public int updateEmpSalByRange(float salRange,Float percentages);
    public int deleteEmpBySalRange(float start,float end);
}

