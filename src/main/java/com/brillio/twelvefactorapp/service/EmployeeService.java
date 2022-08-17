package com.brillio.twelvefactorapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.twelvefactorapp.model.Employee;
import com.brillio.twelvefactorapp.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    
    public Optional<Employee> getEmployee(int id) {
    	return employeeRepository.findById(id);
    }
    
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public int deleteEmployee(int id) {
    	employeeRepository.deleteById(id);
    	return id;
    }
    
    public Employee patchEmployees(int id, int age){
    	Employee employee = employeeRepository.findById(id).get();
    	employee.setAge(age);
    	return employeeRepository.save(employee);
    }

}
