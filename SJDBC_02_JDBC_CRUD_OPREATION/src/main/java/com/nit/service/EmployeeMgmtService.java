package com.nit.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {
	public int fetchEmpCount();
	public String fetchEmpName(int eno);
    public Map<String ,Object> fetchEmpDetails(int eno);
    public List<Map<String,Object>> fetchEmpDetails();
    public String HikeEmpSalByPercentages(float salRange,float percentages);
    public String fireEmpBySalRange(float start,float end);
}

