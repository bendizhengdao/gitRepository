package com.ssm.test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.ssm.domain.Employees;
import com.ssm.domain.EmployeesExample;
import com.ssm.domain.EmployeesExample.Criteria;
import com.ssm.mapper.EmployeesMapper;
/**
 * Mybatis Generator
 * @author interface
 *
 */
public class MyBatisTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{

		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		
		return sqlSessionFactory;
	}
	
	
	public static void main(String[] args) throws Exception {
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File("src/main/resources/mbg.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
	}
	@Test
	public void testMapper() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
	
		EmployeesExample example = new EmployeesExample();
		Criteria criteria = example.createCriteria();
		criteria.andLastNameEqualTo("张三");
		criteria.andEmailEqualTo("zhangsan@qq.com");
		
		criteria.andIdGreaterThan(4);

		Criteria criteria1 = example.createCriteria();
		
		//criteria1.andGenderEqualTo("0");
		//example.or(criteria1);
		example.setOrderByClause("id desc");
		
		
		
		List<Employees> selectByExample = mapper.selectByExample(example);
		for (Employees employees : selectByExample) {
			System.out.println(employees);
		}
	}
	
	
	
	
}
