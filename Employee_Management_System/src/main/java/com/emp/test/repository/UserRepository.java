package com.emp.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.test.entity.Employee;

public interface UserRepository extends JpaRepository<Employee,Integer>{
	
}
