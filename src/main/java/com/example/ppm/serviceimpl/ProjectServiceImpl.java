package com.example.ppm.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ppm.model.Project;
import com.example.ppm.repository.ProjectRepository;
import com.example.ppm.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project getProjectById(Long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteProjectById(Long id) {
		projectRepository.deleteById(id);
		
	}

}
