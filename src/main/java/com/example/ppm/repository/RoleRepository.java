package com.example.ppm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ppm.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
