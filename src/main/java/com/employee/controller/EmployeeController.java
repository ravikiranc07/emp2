package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee e) {
		try {
			service.addEmployee(e);
		}catch(EmployeeException ex) {
			return ex.getMessage();
		}
		return "Success";
	}
	
	@GetMapping("getAllEmployees")
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@PutMapping("/update/{id}/{salary}")
	public Employee updateSalary(@PathVariable int id,@PathVariable double salary) {
		return service.updateSalary(id, salary);
		
	}
}
