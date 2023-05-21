package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.ssm.domain.Employees;

public interface EmployeesMapper {
	public Employees selectEmployees(int id);
	
	public Long deleteEmployeesById(int id);
	
	public boolean updateEmployees(Employees employees);
	
	public void addEmployees(Employees employees);
	
	public List<Employees> selectEmployeesByNameAndEmail(String last_Name,String email);
	
	public List<Employees> selectEmployeesByNameAndEmail1(@Param("lastName")String last_Name,@Param("email")String email);
	
	
	public List<Employees> selectEmployeesByMap(Map map);
	
	
	public List<Employees> selectEmployeesByLikeName(String name);
	
	
	public Map selectEmployeesById(Integer Id);
	
	@MapKey("id") //mybatis封装的时候，map的key为哪个属性
	public Map<Integer,Employees> selectEmployeesByIdMap(String name);
	

}
