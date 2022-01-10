package com.example.ppm.service;

import java.util.List;

import com.example.ppm.model.Allocation;


public interface AllocationService {
	List<Allocation> getAllAllocations();

	Allocation saveAllocation(Allocation allocation);
	
	Allocation getAllocationById(Long id);
	
	Allocation updateAllocation(Allocation allocation);
	
	void deleteAllocationById(Long id);

}
