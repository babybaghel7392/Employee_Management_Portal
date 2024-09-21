package com.emp.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.test.entity.Employee;
import com.emp.test.service.Empservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private Empservice empservice;
	
	@GetMapping("/")
	public String base1(Model m)
	{
		List<Employee>list=empservice.getAllemp();
		m.addAttribute("emplist",list);
		return "base1";
	}
	@GetMapping("/EmpSave")
	public String loadEmpsave()
	{
		return "emp_save";
	}
	
	@GetMapping("/Edit/{id}")
	public String loadEditSave(@PathVariable int id,Model m)
	{
		System.out.println(id);
		Employee emp=empservice.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit_emp";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session)
	{
		Employee newemp= empservice.saveEmp(emp);
		if(newemp!=null)
		{
			//System.out.println("save");
			session.setAttribute("msg"," Register successfully");
		}
		else
		{
			//System.out.println("not save");
			session.setAttribute("msg","wrong in server");
		}
		return "redirect:/EmpSave";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session)
	{
		Employee updateemp= empservice.saveEmp(emp);
		if(updateemp!=null)
		{
			//System.out.println("save");
			session.setAttribute("msg"," Update successfully");
		}
		else
		{
			//System.out.println("not save");
			session.setAttribute("msg","wrong in server");
		}
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteemp(@PathVariable int id,HttpSession session)
	{
		boolean f=empservice.deleteEmp(id);
		if(f)
		{
			session.setAttribute("msg"," Delete successfully");
		}
		else
		{
			session.setAttribute("msg"," Delete successfully");
		}
		return "redirect:/";
	}
}

