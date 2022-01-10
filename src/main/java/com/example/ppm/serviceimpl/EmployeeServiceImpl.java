package com.example.ppm.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ppm.model.User;
import com.example.ppm.repository.UserRepository;
import com.example.ppm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private UserRepository employeeRepository;
	
	

	public EmployeeServiceImpl(UserRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<User> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public User saveEmployee(User employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public User getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public User updateEmployee(User employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
		
	}

}
