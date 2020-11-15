package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nit.bo.EmployeeBO;

@Repository("empDao")
public class EmployeeDAOimpl implements EmployeeDAO {

	private String GET_EMP_BY_NO = "SELECT ENO,ENAME,DESG,SAL,DEPTNO FROM EMP WHERE ENO=?";
	@Autowired
	private JdbcTemplate jt;

	public EmployeeBO getEmployeeByNo(int eno) {

		EmployeeBO bo = null;

		bo = jt.queryForObject(GET_EMP_BY_NO, new EmployeeRowMapper(), eno);

		return bo;
	}

	private static class EmployeeRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

			EmployeeBO bo = null;
			bo = new EmployeeBO();

			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setDesg(rs.getString(3));
			bo.setSal(rs.getDouble(4));
			bo.setDeptno(rs.getInt(5));

			return bo;
		}

	}

}
