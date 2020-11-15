package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.nit.bo.EmployeeBO;

public class EmployeeDAOImpl_ROW_CALLBACK_HANDLER implements EmployeeDAO {

	private final String GET_EMP_BY_DESG = "SELECT ENO,ENAME,SAL,DESG,DEPTNO FROM EMP WHERE DESG=?";
	@Autowired
	private JdbcTemplate jt;

	public List<EmployeeBO> getEmpByDesg(String desg) {

		final List<EmployeeBO> listbo = new ArrayList();
		jt.query(GET_EMP_BY_DESG, new RowCallbackHandler() {

			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					EmployeeBO bo = new EmployeeBO();
					bo.setEno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setSal(rs.getDouble(3));
					bo.setDesg(rs.getString(4));
					bo.setDeptno(rs.getInt(5));
					listbo.add(bo);
				}
			}
			}, desg);
		
		return listbo;
	}

	public List<EmployeeBO> getEmpByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}
}
