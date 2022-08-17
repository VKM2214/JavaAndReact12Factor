package com.brillio.twelvefactorapp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.twelvefactorapp.model.Employee;
import com.brillio.twelvefactorapp.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
    @PostMapping("/createNew")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    
    @GetMapping
    public List<Employee> getAllEmployees(){
    	return employeeService.getAllEmployees();
    }
    
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") int id){
    	LOGGER.info("Employee Get Id"+id);
    	return employeeService.getEmployee(id);
    }
    
    @PutMapping("/updateCall/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
    	LOGGER.warn("Employee Put Id"+id);
    	employee.setId(id);
    	return employeeService.updateEmployee(employee);
    }
    
    @DeleteMapping("/deleteCall/{id}")
    public int deleteEmployee(@PathVariable("id") int id){
    	employeeService.deleteEmployee(id);
    	return id;
    }
    
    @PatchMapping("/patchCall/{id}/{age}")
    public Employee patchData(@PathVariable("id") int id, @PathVariable("age") int age) {
		return employeeService.patchEmployees(id, age);    	
    }

}
