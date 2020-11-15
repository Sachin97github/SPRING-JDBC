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

@Repository("empDAO")
public class EmployeeDAOImpl_one implements EmployeeDAO {
	
	private static final String GET_EMPS_BY_DESG="SELECT ENO,ENAME,SAL,DESG,DEPTNO FROM EMP WHERE DESG IN(?,?)";
    private EmployeesSelector selector=null;
	
	
	@Autowired
	public EmployeeDAOImpl_one(DataSource ds) {
		System.out.println("EmployeeDAOImpl_one.EmployeeDAOImpl_one()");
		selector=new EmployeesSelector(ds,GET_EMPS_BY_DESG);
	}

	public List<EmployeeBO> getEmpsByDesg(String desg1, String desg2) {
		
		List<EmployeeBO> listbo=null;
		
		listbo=selector.execute(desg1,desg2);
		
		return listbo;
	}


  public class EmployeesSelector extends MappingSqlQuery<EmployeeBO>
	{

		public EmployeesSelector(DataSource ds, String sql) {
			
			super(ds, sql);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
			//Number of parameter in Query
			System.out.println("EmployeeDAOImpl_one.EmployeesSelector.EmployeesSelector()");
			}

		@Override
		protected EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			System.out.println("EmployeeDAOImpl_one.EmployeesSelector.mapRow()");
			EmployeeBO bo = new EmployeeBO();

			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setSal(rs.getDouble(3));
			bo.setDesg(rs.getString(4));
			bo.setDeptno(rs.getInt(5));
		
			return bo;
			
		}
	}


	public EmployeeBO getEmpByNo(int eno) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
