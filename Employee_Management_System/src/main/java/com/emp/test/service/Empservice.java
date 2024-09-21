package com.emp.test.service;

import java.util.List;

import com.emp.test.entity.Employee;

public interface Empservice {
	public Employee saveEmp(Employee emp);
	public List<Employee> getAllemp();
	public Employee getEmpById(int id);
	public boolean deleteEmp(int id);
}
