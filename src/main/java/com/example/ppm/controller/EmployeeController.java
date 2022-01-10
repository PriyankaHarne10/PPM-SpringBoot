package com.example.ppm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ppm.model.Allocation;
import com.example.ppm.model.MyUserDetails;
import com.example.ppm.model.Role;
import com.example.ppm.model.User;
import com.example.ppm.repository.RoleRepository;
import com.example.ppm.repository.UserRepository;
import com.example.ppm.service.EmployeeService;
import com.example.ppm.service.RoleService;

@Controller
public class EmployeeController {

	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRepository empRepo;
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	
	@GetMapping("/user_profile")
	public String vierUserProfile(@AuthenticationPrincipal MyUserDetails user,Model model)
	{
		model.addAttribute("user",user);
		return "user_profile";
	}
	
	
	
	// handler method to handle list of employee and return model and view
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
	
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		// create employee object to hold project form data 
		User employee = new User();
		model.addAttribute("employee", employee);
		model.addAttribute("listRole", roleService.getAllRoles());
		
		//model.addAttribute("employee", employeeService.getAllEmployees());
	
		return "create_employee";
	}

	/*
	 * @GetMapping("/employees/new") public String createEmployeeForm(Model model) {
	 * List<Role> listRole = roleRepo.findAll(); User employee = new User();
	 * model.addAttribute("employee",employee); model.addAttribute("listRole",
	 * listRole);
	 * 
	 * return "create_employee"; }
	 */
	@PostMapping("/employees")
	public String saveEmployee(@Valid @ModelAttribute("employee") User employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("employee", employee);
			model.addAttribute("listRole", roleService.getAllRoles());
			return "create_employee";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = employee.getPassword();
		String encodedPassword = encoder.encode(password);
		System.out.print(encodedPassword);
		employee.setPassword(encodedPassword);
		//empRepo.save(employee);
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("listRole", roleService.getAllRoles());
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") User employee, Model model) {
		// get employee from db by id
		User previousEmployee = employeeService.getEmployeeById(id);
		previousEmployee.setId(id);
		previousEmployee.setFirstname(employee.getFirstname());
		previousEmployee.setLastname(employee.getLastname());
		previousEmployee.setUsername(employee.getUsername());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = employee.getPassword();
		String encodedPassword = encoder.encode(password);		
		previousEmployee.setPassword(encodedPassword);
		previousEmployee.setPhone(employee.getPhone());
		previousEmployee.setAddress(employee.getAddress());
		previousEmployee.setRolename(employee.getRolename());
		previousEmployee.setRoles(employee.getRoles());
		/*
		 * previousEmployee.setRoletype(employee.getRoletype());
		 * previousEmployee.setRolename(employee.getRolename());
		 */

		// save updated employee object
		employeeService.updateEmployee(previousEmployee);

		return "redirect:/employees";
	}

	@GetMapping("employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
