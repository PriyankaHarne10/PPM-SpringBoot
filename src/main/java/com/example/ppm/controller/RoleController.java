package com.example.ppm.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ppm.model.Role;
import com.example.ppm.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	// handler method to handle list of role and return mode and view
	@GetMapping("/roles")
	public String listRoles(Model model) {
		model.addAttribute("roles", roleService.getAllRoles());
		return "roles";
	}
	
	@GetMapping("/roles/new")
	public String createRoleForm(Model model) {
		//create role object to hold role form data
		Role role = new Role();
		model.addAttribute("role",role);
		return "create_role";
	}
 
	@PostMapping("/roles")
	public String saveRole(@Valid @ModelAttribute("role") Role role,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "create_role";
		}

		roleService.saveRole(role);
		return "redirect:/roles";
	}
	
	@GetMapping("/roles/edit/{id}")
	public String editRoleForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("role",roleService.getRoleById(id));
		return "edit_role";
	}
	@PostMapping("/roles/{id}")
	public String updateRole(@PathVariable Long id, @ModelAttribute("role") Role role ,Model model)
	{
		//get role from db by id
		Role previousRole =roleService.getRoleById(id);
		previousRole.setRoleid(id);
		//previousRole.setRolename(role.getRolename());
		previousRole.setRoletype(role.getRoletype());
		//save updated role object
		roleService.updateRole(previousRole);
		
		return "redirect:/roles";
	}
	
	@GetMapping("roles/{id}")
	public String deleteRole(@PathVariable Long id)
	{
		roleService.deleteRoleById(id);
		return "redirect:/roles";
	}
}

