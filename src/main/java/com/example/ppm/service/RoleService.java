package com.example.ppm.service;

import java.util.List;

import com.example.ppm.model.Role;


public interface RoleService {

	List<Role> getAllRoles();
	
	Role saveRole(Role role);
	
	Role getRoleById(Long id);
	
	Role updateRole(Role role);
	
	void deleteRoleById(Long id);
}
