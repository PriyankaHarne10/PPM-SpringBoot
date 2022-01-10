package com.example.ppm.service;

import java.util.List;

import com.example.ppm.model.Project;



public interface ProjectService {
	 List<Project> getAllProjects();
		
		Project saveProject(Project project);
		
		Project getProjectById(Long id);
		
		Project updateProject(Project Project);
		
		void deleteProjectById(Long id);
}
