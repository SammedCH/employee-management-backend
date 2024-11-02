package com.employeeManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeeManage.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	boolean existsByEmailId(String emailId);
	
	 List<Employee> findByActiveStatusTrue();
	

}
