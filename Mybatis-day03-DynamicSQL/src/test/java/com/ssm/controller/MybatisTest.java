package com.ssm.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssm.domain.Employees;
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
		SqlSession openSession1 = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees employees = new Employees("张三", "", "1");
			List<Employees> emps = mapper.getEmployeesByConditionIf(employees);
			System.out.println(emps);
			openSession.close();
			
			EmployeesMapper mapper1 = openSession1.getMapper(EmployeesMapper.class);
			List<Employees> emps1 = mapper1.getEmployeesByConditionIf(employees);
			System.out.println(emps1);
			openSession1.close();
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
			Employees employees = new Employees("张三", "10@qq.com", "1");
			List<Employees> emps = mapper.getEmployeesByConditionIf1(employees);
			System.out.println(emps);
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
			Employees employees = new Employees("张三", "", "1");
			List<Employees> emps = mapper.getEmployeesByConditionIf2(employees);
			System.out.println(emps);
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
			Employees employees = new Employees("张三", "zhangsan@qq.com", "1");
			List<Employees> emps = mapper.getEmployeesByConditionChoose(employees);
			System.out.println(emps);
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
			Employees employees = new Employees(5,"李四", "lisi@qq.com", "1");
			mapper.updateEmployeesByConditionSet(employees);
			openSession.commit();
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
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees employees = new Employees(6,"harry", "harray@qq.com", "");
			mapper.updateEmployeesByConditionSet1(employees);
			openSession.commit();
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
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			Employees employees = new Employees(6,"harry", "", "");
			mapper.updateEmployeesByConditionSet2(employees);
			openSession.commit();
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
			List<Integer> list = new ArrayList<Integer> ();
			list.add(1);
			list.add(5);
			List<Employees> employeesByConditionList = mapper.getEmployeesByConditionList(list);
			for (Employees employees : employeesByConditionList) {
				System.out.println(employees);
			}
		} finally {
			openSession.close();
		}
	
	}
	
	@Test
	public void Test8() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			List<Employees> employeesList = new ArrayList<>();
			employeesList.add(new Employees("杨希", "杨希@qq.com", "1"));
			employeesList.add(new Employees("杨一", "杨一@qq.com", "0"));
			employeesList.add(new Employees("杨二", "杨二@qq.com", "0"));
			employeesList.add(new Employees("杨三", "杨三@qq.com", "1"));
			mapper.addEmployeesList(employeesList);
			openSession.commit();
		} finally {
			openSession.close();
		}
	
	}
	
	@Test
	public void Test9() throws IOException{
		
		String mybatis = "mybatis-config.xml";
		
		Reader resourceAsReader = Resources.getResourceAsReader(mybatis);
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			EmployeesMapper mapper = openSession.getMapper(EmployeesMapper.class);
			List<Employees> employeesList = new ArrayList<>();
			employeesList.add(new Employees("王三", "王三@qq.com", "1"));
			employeesList.add(new Employees("阳痿", "阳痿@qq.com", "0"));
			employeesList.add(new Employees("杨威", "杨威@qq.com", "0"));
			employeesList.add(new Employees("彭伟", "彭伟@qq.com", "1"));
			mapper.addEmployeesList1(employeesList);
			openSession.commit();
		} finally {
			openSession.close();
		}
	
	}
	/**
	 * Map根据value的值进行排序
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> sortMap(Map<String,Integer> map){
		//利用Map的entrySet方法,转化为list进行排序
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		//利用Collections的sort方法对list排序
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				//正序排列,倒序反过来
				return o1.getValue()-o2.getValue();
			}
		});
		//遍历排序好的list,一定要放入LinkedHashMap,因为只有LinkedHashMap是根据插入顺序进行存储
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String,Integer>();
		for (Map.Entry<String, Integer> e:entryList) {
			linkedHashMap.put(e.getKey(), e.getValue());
		}
		return linkedHashMap;
	}
	
	/**
	 * 使用辗转相除法求两个数的最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getMaxCommonDivisor(int a,int b){
		//定义一个交换值
		int temp = 0;
		while (a%b!=0) {
			temp = a%b;
			a = b;
			b = temp;
		}
		return b;
	}
	
	/**
	 * 获取两个数的最小公倍数：两个数相乘  	等于	这两个数的最大公约数和最小公倍数的 	乘积
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getMinCommonMultiple(int a,int b){
		return a*b/getMaxCommonDivisor(a, b);
	}
	
	/**
	 * 求多个数的最小公倍数
	 * @param arrays
	 * @return
	 */
	public static int getMinMultiCommonMultiple(int [] arrays){
		int val = arrays[0];
		//实现原理:拿前两个数的最小公约数和后一个数比较,求他们的公约数以此来推
		for (int i = 1; i < arrays.length; i++) {
			val = getMinCommonMultiple(val, arrays[i]);
		}
		return val;
	}
}
