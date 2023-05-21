package com.ssm;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssm.domain.Employees;
import com.ssm.mapper.EmployeesMapper;
/**
 * update / delete / insert 默认返回 int
 * @author interface
 *
 */
public class MybatisTest {
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 * 
	 * SqlSession 和Connection一样都是非线程安全的
	 * 
	 */
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			Employees employees = session.selectOne("com.ssm.mapper.EmployeesMapper.selectEmployees", 1);
			System.out.println(employees);
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void test1() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			Employees employees = mapper.selectEmployees(4);
			System.out.println(employees);
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testInsert() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			
			Employees addEmployees = new Employees("张三", "zhangsan@qq.com", "1");
			
			mapper.addEmployees(addEmployees);
			
			System.out.println(addEmployees);
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testUpdate() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			boolean updateEmployees = mapper.updateEmployees(new Employees(6,"张三", "zhangsan@qq.com", "0"));
			
			System.out.println(updateEmployees);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	
	@Test
	public void testDelete() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			Long deleteEmployeesById = mapper.deleteEmployeesById(4);
			System.out.println(deleteEmployeesById);
			session.commit();
		} finally {
			session.close();
		}
		
		

	}
	
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testselectEmployeesByNameAndEmail() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			List<Employees> selectEmployeesByNameAndEmail = mapper.selectEmployeesByNameAndEmail("张三", "zhangsan@qq.com");
			for(Employees employees:selectEmployeesByNameAndEmail){
				System.out.println(employees);
			}
			
		} finally {
			session.close();
		}
	}
	
	

	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testselectEmployeesByNameAndEmail1() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			List<Employees> selectEmployeesByNameAndEmail = mapper.selectEmployeesByNameAndEmail1("张三", "zhangsan@qq.com");
			for(Employees employees:selectEmployeesByNameAndEmail){
				System.out.println(employees);
			}
			
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testselectEmployeesByMap() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("lastName", "张三");
			paramMap.put("email", "zhangsan@qq.com");
			List<Employees> selectEmployeesByNameAndEmail = mapper.selectEmployeesByMap(paramMap);
			for(Employees employees:selectEmployeesByNameAndEmail){
				System.out.println(employees);
			}
			
		} finally {
			session.close();
		}
	}
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testselectEmployeesByLikeName() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("lastName", "张三");
			paramMap.put("email", "zhangsan@qq.com");
			List<Employees> selectEmployeesByNameAndEmail = mapper.selectEmployeesByLikeName("三");
			for(Employees employees:selectEmployeesByNameAndEmail){
				System.out.println(employees);
			}
			
		} finally {
			session.close();
		}
	}
	
	
	
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testselectEmployeesById() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("lastName", "张三");
			paramMap.put("email", "zhangsan@qq.com");
			Map selectEmployeesById = mapper.selectEmployeesById(1);
			System.out.println(selectEmployeesById);
			
		} finally {
			session.close();
		}
	}
	
	
	
	/**
	 * 根据mybatis-config.xml 创建一个 SqlSessionFactory对象
	 */
	@Test
	public void testselectEmployeesByIdMap() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeesMapper mapper = (EmployeesMapper) session.getMapper(EmployeesMapper.class);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("lastName", "张三");
			paramMap.put("email", "zhangsan@qq.com");
			Map selectEmployeesById = mapper.selectEmployeesByIdMap("%三%");
			System.out.println(selectEmployeesById);
			
		} finally {
			session.close();
		}
	}
}
