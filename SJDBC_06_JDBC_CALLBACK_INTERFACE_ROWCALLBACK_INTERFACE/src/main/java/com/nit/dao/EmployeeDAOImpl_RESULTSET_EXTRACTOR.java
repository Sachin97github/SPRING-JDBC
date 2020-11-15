package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nit.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl_RESULTSET_EXTRACTOR implements EmployeeDAO {

	private final String GET_EMP_BY_DEPTNO = "SELECT ENO,ENAME,SAL,DESG,DEPTNO FROM EMP WHERE DEPTNO=?";
	@Autowired
	private JdbcTemplate jt;

	public List<EmployeeBO> getEmpByDeptno(int deptno) {

		List<EmployeeBO> listbo = null;

		listbo = jt.query(GET_EMP_BY_DEPTNO, new EmployeeResultSetExtractor(), deptno);

		return listbo;

	}

	public List<EmployeeBO> getEmpByDesg(String desg) {
		// TODO Auto-generated method stub
		return null;
	}

	class EmployeeResultSetExtractor implements ResultSetExtractor<List<EmployeeBO>> {

		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {

			List<EmployeeBO> listbo = null;

			while (rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setSal(rs.getDouble(3));
				bo.setDesg(rs.getString(4));
				bo.setDeptno(rs.getInt(5));
				listbo.add(bo);
			}

			return listbo;
		}

	}

}
