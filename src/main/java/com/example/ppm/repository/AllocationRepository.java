package com.example.ppm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ppm.model.Allocation;


@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>  {

}
