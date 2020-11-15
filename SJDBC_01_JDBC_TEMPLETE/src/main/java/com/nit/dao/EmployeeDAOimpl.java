package com.nit.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOimpl implements EmployeeDAO {

	private String GET_EMP_COUNT = "SELECT COUNT(*) FROM EMP";
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

}
