package com.example.ppm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ppm.model.Allocation;
import com.example.ppm.service.AllocationService;
import com.example.ppm.service.EmployeeService;
import com.example.ppm.service.ProjectService;


@Controller
public class AllocationController {

	@Autowired
	private AllocationService allocationService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}

	@GetMapping("/allocations")
	public String listAllocations(Model model) {
		model.addAttribute("allocations", allocationService.getAllAllocations());
		return "allocations";
	}

	@GetMapping("/allocations/new")
	public String createAllocationForm(Model model) {
		// create employee object to hold project form data
		Allocation allocation = new Allocation();
		model.addAttribute("allocation", allocation);
		model.addAttribute("listEmployee", employeeService.getAllEmployees());
		model.addAttribute("listProject", projectService.getAllProjects());
		return "create_allocation";
	}

	@PostMapping("/allocations")
	public String saveAllocation(@ModelAttribute("allocation") Allocation allocation) {
		allocationService.saveAllocation(allocation);
		return "redirect:/allocations";
	}

	@GetMapping("/allocations/edit/{id}")
	public String editAllocationForm(@PathVariable Long id, Model model) {
		model.addAttribute("allocation", allocationService.getAllocationById(id));
		model.addAttribute("listEmployee", employeeService.getAllEmployees());
		model.addAttribute("listProject", projectService.getAllProjects());
		return "edit_allocation";
	}

	@PostMapping("/allocations/{id}")
	public String updateAllocation(@PathVariable Long id, @ModelAttribute("allocation") Allocation allocation,
			Model model) {

		Allocation previousAllocation = allocationService.getAllocationById(id);
		previousAllocation.setId(id);
		previousAllocation.setEmployeename(allocation.getEmployeename());
		previousAllocation.setProjectname(allocation.getProjectname());

		allocationService.updateAllocation(previousAllocation);

		return "redirect:/allocations";
	}

	@GetMapping("allocations/{id}")
	public String deleteAllocation(@PathVariable Long id) {
		allocationService.deleteAllocationById(id);
		return "redirect:/allocations";
	}

}
