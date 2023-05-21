package com.ssm.mapper;

import com.ssm.domain.Dept;

public interface DeptMapper {
	public Dept getDeptById(Integer did);
	
	
	public Dept getDeptAndEmployeesStepById(Integer did);
	
	
	public Dept getDeptAndEmployeesById(Integer id);
}
