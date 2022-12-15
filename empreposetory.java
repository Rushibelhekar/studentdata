package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface empreposetory extends JpaRepository<employees, Long> {
    // all crud database methods
	@GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
	
	
}