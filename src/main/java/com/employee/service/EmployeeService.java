package com.employee.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	
	public String addEmployee(Employee e) throws EmployeeException {
		if(repo.existsById(e.getId())) {
			throw new EmployeeException("Employee already exits"); 
		}
		repo.save(e);
		return "Success";
	}
	
	
	public Employee updateSalary(int id,double salary) {
		Employee e=repo.findById(id).get();
		e.setSalary(salary);
		repo.save(e);
		return e;
	}
	
	public List<Employee> getAll(){
		
		
		List<Employee> list= repo.findAll();
		Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary()>o2.getSalary()) {
					return 1;
				}
				if(o1.getSalary()==o2.getSalary()) {
					return o1.getName().compareTo(o2.getName());
				}
				return 0;
			}
			
		});
		return list;
	}
	
}
