package com.employeeManage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.employeeManage.entity.Employee;
import com.employeeManage.exception.ResourceNotFoundException;
import com.employeeManage.service.EmployeeService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//@RequestBody convert json to java object
	
	@PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody @Validated Employee employee) {
        // Create a new TrainingCenter and save it to the database
        Employee newEmployee = employeeService.createEmployee(employee);
        // Return the newly created TrainingCenter with a created status
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }
	
	 @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	 @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
	        Employee employee = employeeService.getEmployeeById(id);
	        return ResponseEntity.ok(employee);
	    }

	 @PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
	        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
	        return ResponseEntity.ok(updatedEmployee);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
	        try {
	            employeeService.deleteEmployee(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (ResourceNotFoundException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @GetMapping("/active")
	    public List<Employee> getActiveEmployees() {
	        return employeeService.getActiveEmployees();
	    }

	    // Inactivate an employee by ID
	    @PutMapping("/{id}/inactivate")
	    public ResponseEntity<Employee> inactivateEmployee(@PathVariable("id") Long employeeId) {
	        Employee updatedEmployee = employeeService.inactivateEmployee(employeeId);
	        return ResponseEntity.ok(updatedEmployee);
	    }
	
}
