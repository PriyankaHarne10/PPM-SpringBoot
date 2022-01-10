package com.example.ppm.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ppm.model.Role;
import com.example.ppm.repository.RoleRepository;
import com.example.ppm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}



	@Override
	public List<Role> getAllRoles() {
		
		return roleRepository.findAll();
	}



	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}



	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).get();
	}



	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}



	@Override
	public void deleteRoleById(Long id) {
	roleRepository.deleteById(id);
		
	}

}
