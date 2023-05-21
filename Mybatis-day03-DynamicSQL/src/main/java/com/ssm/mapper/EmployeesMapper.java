package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.domain.Employees;

public interface EmployeesMapper {
	
	public List<Employees> getEmployeesByConditionIf(Employees employees);
	
	public List<Employees> getEmployeesByConditionIf1(Employees employees);
	
	public List<Employees> getEmployeesByConditionIf2(Employees employees);
	
	public List<Employees> getEmployeesByConditionChoose(Employees employees);
	
	
	public  void updateEmployeesByConditionSet(Employees employees);
	
	public  void updateEmployeesByConditionSet1(Employees employees);
	
	public  void updateEmployeesByConditionSet2(Employees employees);
	
	public  List<Employees> getEmployeesByConditionList(List<Integer> list);
	
	public  void addEmployeesList(List<Employees> employeesList);
	
	public  void addEmployeesList1(@Param("employeesList")List<Employees> employeesList);
	
	
	public  void addEmployeesList2(@Param("employeesList")List<Employees> employeesList);
	
	public  void addEmployeesList3(List<Employees> employeesList);
	
	
	
}
