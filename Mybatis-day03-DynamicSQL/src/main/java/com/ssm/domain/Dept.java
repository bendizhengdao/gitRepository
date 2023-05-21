package com.ssm.domain;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {
	
	private Integer id;
	
	private String deptName;
	
	private List<Employees> employeesList ;
	
	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employees> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employees> employeesList) {
		this.employeesList = employeesList;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", employeesList=" + employeesList + "]";
	}

}
