package com.employeeManage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManage.entity.Employee;
import com.employeeManage.exception.EmailAlreadyExistsException;
import com.employeeManage.exception.ResourceNotFoundException;
import com.employeeManage.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee) {
        // Check if the email already exists
        if (employeeRepository.existsByEmailId(employee.getEmailId())) {
            throw new EmailAlreadyExistsException("Email is already taken!");
        }
        return employeeRepository.save(employee);
    }
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Employee not found with id " + id)
        );
    }
    
    

    public Employee updateEmployee(long id, Employee employeeDetails) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Employee not found with id " + id)
        );

        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setDateOfJoin(employeeDetails.getDateOfJoin());
        existingEmployee.setDepartment(employeeDetails.getDepartment());
        existingEmployee.setSalary(employeeDetails.getSalary());
        existingEmployee.setExperience(employeeDetails.getExperience());
        existingEmployee.setAddress(employeeDetails.getAddress());
        existingEmployee.setEducationDetails(employeeDetails.getEducationDetails());
        existingEmployee.setContactNo(employeeDetails.getContactNo());
        existingEmployee.setEmailId(employeeDetails.getEmailId());
        existingEmployee.setActiveStatus(employeeDetails.getActiveStatus());

        return employeeRepository.save(existingEmployee);
    }
    
    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        employeeRepository.delete(employee);
    }
    
    public List<Employee> getActiveEmployees() {
        return employeeRepository.findByActiveStatusTrue();
    }

    public Employee inactivateEmployee(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setActiveStatus(false); // Set the active status to inactive
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id " + employeeId);
        }
    }
    
    
    
}
