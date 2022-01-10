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

import com.example.ppm.model.Project;
import com.example.ppm.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}
	
	// handler method to handle list of project and return model and view
		@GetMapping("/projects")
		public String listProjects(Model model) {
			model.addAttribute("projects", projectService.getAllProjects());
			return "projects";
		}
		
		@GetMapping("/projects/new")
		public String createProjectForm(Model model) {
			//create project object to hold project form data
			Project project = new Project();
			model.addAttribute("project",project);
			return "create_project";
		}
	 
		@PostMapping("/projects")
		public String saveProject(@Valid @ModelAttribute("project") Project project,BindingResult result)
		{
			if(result.hasErrors())
			{
				return "create_project";
			}
			projectService.saveProject(project);
			return "redirect:/projects";
		}
		
		@GetMapping("/projects/edit/{id}")
		public String editProjectForm(@PathVariable Long id,Model model)
		{
			model.addAttribute("project",projectService.getProjectById(id));
			return "edit_project";
		}
		@PostMapping("/projects/{id}")
		public String updateProject(@PathVariable Long id, @ModelAttribute("project") Project project ,Model model)
		{
			//get role from db by id
			Project previousProject =projectService.getProjectById(id);
			previousProject.setProjectid(id);
			previousProject.setProjectname(project.getProjectname());
			previousProject.setStartdate(project.getStartdate());
			previousProject.setEnddate(project.getEnddate());
			
			//save updated role object
			projectService.updateProject(previousProject);
			
			return "redirect:/projects";
		}
		
		@GetMapping("projects/{id}")
		public String deleteProject(@PathVariable Long id)
		{
			projectService.deleteProjectById(id);
			return "redirect:/projects";
		}
}

