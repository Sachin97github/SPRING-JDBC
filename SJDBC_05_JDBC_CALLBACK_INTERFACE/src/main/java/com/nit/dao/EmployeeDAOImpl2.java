package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nit.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl2 implements EmployeeDAO {

	private final String GET_EMP_BY_ID = "SELECT ENO,ENAME,SAL,DESG,DEPTNO FROM EMP WHERE ENO=?";
	private final String GET_EMP_BY_DESG = "SELECT ENO,ENAME,SAL,DESG,DEPTNO FROM EMP WHERE DESG=?";
	@Autowired
	private JdbcTemplate jt = null;

	public EmployeeDAOImpl2(JdbcTemplate jt) {
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

	public List<EmployeeBO> getStudentsByDesg(String desg) {

		List<EmployeeBO> listBO = null;

		listBO = jt.query(GET_EMP_BY_DESG, new ResultSetExtractor<List<EmployeeBO>>() {

			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<EmployeeBO> listBO = new ArrayList();

				while (rs.next()) {
					EmployeeBO bo = new EmployeeBO();

					bo.setENO(rs.getInt(1));
					bo.setENAME(rs.getString(2));
					bo.setSAL(rs.getDouble(3));
					bo.setDESG(rs.getString(4));
					bo.setDEPTNO(rs.getInt(5));
					listBO.add(bo);
				}

				return listBO;
			} // Extract DATA func

		}, desg); // jt.query

		return listBO;
	}
	@Override
	public List<EmployeeBO> getStudentsBYDeptno(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}
}
