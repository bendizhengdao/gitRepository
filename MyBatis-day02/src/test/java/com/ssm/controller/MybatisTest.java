package com.ssm.controller;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssm.domain.Dept;
import com.ssm.domain.Employees;
import com.ssm.mapper.DeptMapper;
import com.ssm.mapper.EmployeesMapper;

public class MybatisTest {
	
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{

		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		
		return sqlSessionFactory;
	}
	
	@Test
	public void Test() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees emp = mapper.getEmpById(1);
			System.out.println(emp);
		} finally {
			openSession.close();
		}
	
	}
	
	
	@Test
	public void Test1() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees emp = mapper.getEmpById1(1);
			System.out.println(emp);
		} finally {
			openSession.close();
		}
	
	}
	@Test
	public void Test2() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees emp = mapper.getEmpAndDeptById(1);
			System.out.println(emp);
		} finally {
			openSession.close();
		}
	
	}
	
	
	
	
	@Test
	public void Test3() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees emp = mapper.getEmpAndDeptAssociationById(1);
			System.out.println(emp);
		} finally {
			openSession.close();
		}
	
	}
	
	
	
	
	@Test
	public void Test4() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees emp = mapper.getEmpAndDeptAssociationStepById(1);
			System.out.println(emp.getId());
			System.out.println("==================================");
			System.out.println(emp.getDept().getDeptName());
		} finally {
			openSession.close();
		}
	
	}
	
	
	@Test
	public void Test5() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			DeptMapper mapper = openSession.getMapper(DeptMapper.class);
			Dept deptById = mapper.getDeptAndEmployeesStepById(1);
			
			System.out.println(deptById);
		} finally {
			openSession.close();
		}
	
	}
	
	@Test
	public void Test6() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			DeptMapper mapper = openSession.getMapper(DeptMapper.class);
			Dept deptById = mapper.getDeptAndEmployeesById(1);
			
			System.out.println(deptById);
		} finally {
			openSession.close();
		}
	
	}
	
	

	@Test
	public void Test7() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees deptById = mapper.getEmpByDiscriminatorId(2);
			
			System.out.println(deptById);
		} finally {
			openSession.close();
		}
	
	}
	
	
	
}
