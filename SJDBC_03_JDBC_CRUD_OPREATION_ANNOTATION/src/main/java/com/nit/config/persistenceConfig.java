package com.nit.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nit.dao")
public class persistenceConfig {
	
 
	@Bean
	public DataSource createDs()
	{
	 HikariDataSource ds=null;
	 ds=new HikariDataSource();
	
	 ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	 ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
	 ds.setUsername("system");
     ds.setPassword("manager");
     ds.setMinimumIdle(10);
	 return ds;
	}
	
	@Bean
	public JdbcTemplate createTemplete()
	{
		return new JdbcTemplate(createDs());
	}
	

}
