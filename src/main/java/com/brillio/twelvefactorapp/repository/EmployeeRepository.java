package com.brillio.twelvefactorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.twelvefactorapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

	Optional<Employee> findById(int id);
	void deleteById(int id);

}
