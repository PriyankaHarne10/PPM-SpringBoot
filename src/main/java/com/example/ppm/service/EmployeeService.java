package com.example.ppm.service;

import java.util.List;

import com.example.ppm.model.User;



public interface EmployeeService {

    List<User> getAllEmployees();
	
    User saveEmployee(User employee);
	
    User getEmployeeById(Long id);
	
    User updateEmployee(User employee);
	
	void deleteEmployeeById(Long id);
}
