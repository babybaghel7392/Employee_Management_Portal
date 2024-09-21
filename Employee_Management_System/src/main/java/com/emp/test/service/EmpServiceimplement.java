package com.emp.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.emp.test.entity.Employee;
import com.emp.test.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceimplement implements Empservice {
	@Autowired
	private UserRepository emprpo;
	
	@Override
	public Employee saveEmp(Employee emp) {
		Employee newemp=emprpo.save(emp);
		return newemp;
	}

	@Override
	public List<Employee> getAllemp() {
		 return emprpo.findAll();
		
	}

	@Override
	public Employee getEmpById(int id) {
		
		return emprpo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employee emp= emprpo.findById(id).get();
		if(emp!=null)
		{
			emprpo.delete(emp);
			return true;
		}
		return false;
	}
	public void removeSessionmsg()
	{
		HttpSession session= ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}
}
