package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.nit.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	private final static String GET_EMP_BY_NO = "SELECT ENO,ENAME,SAL,DESG,DEPTNO FROM EMP WHERE ENO=?";
	private EmployeeSelector selector = null;

	//@Autowired
	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("=========EmployeeDAOImpl==============");
		selector = new EmployeeSelector(ds, GET_EMP_BY_NO);

	}

	public EmployeeBO getEmpByNo(int eno) {
        EmployeeBO bo = null;
        bo = selector.findObject(eno);
        return bo;
	}

	class EmployeeSelector extends MappingSqlQuery<EmployeeBO> {

		public EmployeeSelector(DataSource ds, String sqlQuery) {
			
			super(ds, sqlQuery);
			System.out.println("=========EmployeeSelector==========");
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}

		@Override
		protected EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {

			EmployeeBO bo = new EmployeeBO();

			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setSal(rs.getDouble(3));
			bo.setDesg(rs.getString(4));
			bo.setDeptno(rs.getInt(5));
			return bo;
		}

	}

	public List<EmployeeBO> getEmpsByDesg(String desg1, String desg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
