package com.nit.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JdbcTemplate jt=null;
		DataSource ds=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		jt=ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		
		ds=jt.getDataSource();
		
		System.out.println("WELL FORMED XML");
	
		
	}

}
