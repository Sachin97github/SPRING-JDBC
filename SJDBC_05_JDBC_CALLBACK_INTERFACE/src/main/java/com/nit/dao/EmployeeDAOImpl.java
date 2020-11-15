package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nit.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {

	private final String GET_EMP_BY_ID = "SELECT ENO,ENAME,SAL,DESG,DEPTNO FROM EMP WHERE ENO=?";
	@Autowired
	private JdbcTemplate jt = null;
	
	
public List<EmployeeBO> getStudentsByDesg(String desg) {
	// TODO Auto-generated method stub
	return null;
}
	public EmployeeDAOImpl(JdbcTemplate jt) {
		super();
		this.jt = jt;
	}

	public EmployeeBO getStudentByNO(int no) {

		EmployeeBO bo = null;
        bo = jt.queryForObject(GET_EMP_BY_ID, new EmployeeMapper(), no);
        return bo;
	}

	private static class EmployeeMapper implements RowMapper<EmployeeBO> {
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {

			
			EmployeeBO bo = null;

			bo.setENO(rs.getInt(1));
			bo.setENAME(rs.getString(2));
			bo.setSAL(rs.getDouble(3));
			bo.setDESG(rs.getString(4));
			bo.setDEPTNO(rs.getInt(5));
			return bo;
		}
	}
	@Override
	public List<EmployeeBO> getStudentsBYDeptno(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}
}
