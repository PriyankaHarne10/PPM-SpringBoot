package com.example.ppm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ppm.model.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
