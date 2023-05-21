package com.ssm.mapper;

import java.util.List;

import com.ssm.domain.Employees;

public interface EmployeesMapper {
	public Employees getEmpById(Integer id);
	
	
	public Employees getEmpById1(Integer id);
	
	
	public Employees getEmpAndDeptById(Integer id);
	
	public Employees getEmpAndDeptAssociationById(Integer id);
	
	
	public Employees getEmpAndDeptAssociationStepById(Integer id);
	
	public List<Employees> getEmpByDeptId(Integer id);
	
	public Employees getEmpByDiscriminatorId(Integer id);
	
}
