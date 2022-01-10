package com.example.ppm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ppm.model.Allocation;
import com.example.ppm.repository.AllocationRepository;
import com.example.ppm.service.AllocationService;

@Service
public class AllocationServiceImpl implements AllocationService {

	@Autowired
	private AllocationRepository allocationRepository;

	public AllocationServiceImpl(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}

	@Override
	public List<Allocation> getAllAllocations() {
		return allocationRepository.findAll();
	}

	@Override
	public Allocation saveAllocation(Allocation allocation) {
		return allocationRepository.save(allocation);
	}

	@Override
	public Allocation getAllocationById(Long id) {
		return allocationRepository.findById(id).get();
	}

	@Override
	public Allocation updateAllocation(Allocation allocation) {
		return allocationRepository.save(allocation);
	}

	@Override
	public void deleteAllocationById(Long id) {
		allocationRepository.deleteById(id);

	}

}
