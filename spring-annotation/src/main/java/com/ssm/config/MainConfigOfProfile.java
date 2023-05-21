package com.ssm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * Profile:
 * 	Spring可以根据当前环境,动态的激活和切换一系列组件的功能
 * @author interface
 *
 */
@Configuration
public class MainConfigOfProfile {
	
	@Bean("testDataSource")
	@Profile("test")
	public DataSource dataSourceTest() throws Exception{
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("123456");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
		return comboPooledDataSource;
	}
	
	@Bean("DevDataSource")
	@Profile("dev")
	public DataSource dataSourceDev() throws Exception{
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("123456");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
		return comboPooledDataSource;
	}
	
	
	@Bean("ProdDataSource")
	@Profile("prod")
	public DataSource dataSourceProd() throws Exception{
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("123456");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
		return comboPooledDataSource;
	}
}
