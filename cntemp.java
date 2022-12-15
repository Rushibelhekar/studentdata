package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.employees;
import net.javaguides.springboot.repository.empreposetory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.management.ServiceNotFoundException;
import javax.management.relation.RoleNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class cntemp {

    @Autowired
    private empreposetory employeeRepository;

    @GetMapping
    public List<employees> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public employees createEmployee(@RequestBody employees employee) {
        return employeeRepository.save(employee);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<employees> getEmployeeById(@PathVariable  long id) throws ServiceNotFoundException{
        employees employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<employees> updateEmployee(@PathVariable long id,@RequestBody employees employeeDetails) throws RoleNotFoundException {
        employees updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) throws RoleNotFoundException{

        employees employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}