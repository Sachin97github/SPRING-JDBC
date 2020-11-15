package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nit.bo.UserDetailsBO;

public class UserMgmtDAOImpl implements UserMgmtDAO {

	private final static String ADD_USER = "INSERT INTO MYBANK(ACCNO,USERNAME,PASSWORD,NAME,ACCTYPE,BALANCE ) VALUES(?,?,?,?,?,?)";
	private final static String REMOVE_USER = "DELETE FROM MYBANK WHERE ACCNO=?";
	private final static String CHECK_USER_DETAILS = "SELECT ACCNO,USERNAME,PASSWORD,NAME,ACCTYPE,BALANCE FROM MYBANK WHERE ACCNO=? ";
	private final static String WITHDRAW_QUERY = "UPDATE MYBANK SET BALANCE=BALANCE+? WHERE ACCNO=?";
	private final static String DEPOSITE_QUERY = "UPDATE MYBANK SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private JdbcTemplate jt = null;

	public UserMgmtDAOImpl(JdbcTemplate jt) {
		super();
		this.jt = jt;
	}

	public int addUser(UserDetailsBO bo) {
		int count;
		System.out.println("====UserMgmtDAOImpl.addUser()====");
		count = jt.update(ADD_USER, bo.getAccNo(), bo.getUsername(), bo.getPassword(), bo.getName(), bo.getAccType(),
				bo.getBalance());
		return count;
	}

	public UserDetailsBO checkUserDetails(long accNo) {
		UserDetailsBO bo = null;
		// bo=jt.queryForObject(CHECK_USER_DETAILS,new Object[] {accNo}, new
		// CustomRowMapper());

		bo = jt.queryForObject(CHECK_USER_DETAILS, new Object[] { accNo }, new RowMapper<UserDetailsBO>() {
			public UserDetailsBO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDetailsBO bo = new UserDetailsBO();
				bo.setAccNo(rs.getLong(1));
				bo.setUsername(rs.getString(2));
				bo.setPassword(rs.getString(3));
				bo.setName(rs.getString(4));
				bo.setAccType(rs.getString(5));
				bo.setBalance(rs.getDouble(6));
				return bo;
			}// Outside mapRow()
		});// function queryForObject
		return bo;
	}

	public int withdraw(long accNo, double money) {
		int count;
		System.out.println("UserMgmtDAOImpl.withdraw()");
		count = jt.update(WITHDRAW_QUERY, money, accNo);
		return count;
	}

	public int deposite(long accNo, double money) {
		int count;
		System.out.println("UserMgmtDAOImpl.deposite()");
		count = jt.update(DEPOSITE_QUERY, money, accNo);
		return count;
	}

	public boolean transferMoney(long srcAccNo, long destAccNo, double money) {

		if (withdraw(srcAccNo, money) != 0 && deposite(destAccNo, money) != 0)
			return true;
		else
			return false;

	}

	public int removeUser(long accNo) {
		int count;
		count = jt.update(REMOVE_USER, accNo);
		return count;
	}

}
