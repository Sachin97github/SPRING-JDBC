package com.nit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOimpl implements EmployeeDAO {

	private String GET_EMP_COUNT = "SELECT COUNT(*) FROM EMP";
	private String GET_EMP_NAME_BY_NO = "SELECT ENAME FROM EMP WHERE ENO=?";
	private String GET_EMP_DETAILS_BY_NO = "SELECT ENAME,ENO,SAL,DEPTNO FROM EMP WHERE ENO=?";
	private String GET_EMPs_DETAILs = "SELECT ENAME,ENO,SAL,DEPTNO FROM EMP";
	private String UPDATE_EMP_BY_SALRANGE = "UPDATE EMP SET SAL=SAL+? WHERE SAL<?";
	private String DELETE_EMP_BY_SALRANGE="DELETE FROM EMP WHERE  SAL <=? AND SAL >= ?";

	private JdbcTemplate jt = null;

	public EmployeeDAOimpl(JdbcTemplate jt) {
		System.out.println("EmployeeDAOimpl.EmployeeDAOimpl()");
		this.jt = jt;
	}

	public int getEmployeeCount() {

		int count;
		count = jt.queryForObject(GET_EMP_COUNT, Integer.class);

		return count;
	}

	public String getEmployeeNameByNo(int eno) {
		String name = null;
		name = jt.queryForObject(GET_EMP_NAME_BY_NO, String.class, eno);
		return name;
	}

	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		Map<String, Object> map = null;
		map = jt.queryForMap(GET_EMP_DETAILS_BY_NO, eno);

		return map;
	}

	public List<Map<String, Object>> getAllEmployeeDetails() {
		List<Map<String, Object>> listMap = null;

		listMap = jt.queryForList(GET_EMPs_DETAILs);
		return listMap;
	}

	public int updateEmpSalByRange(float salRange, Float percentages) {

		int count = 0;

		count = jt.update(UPDATE_EMP_BY_SALRANGE, percentages, salRange);

		return count;
	}
	public int deleteEmpBySalRange(float start, float end) {
		int count=0;
		count=jt.update(DELETE_EMP_BY_SALRANGE,start,end);
		
		return count;
	}

}
