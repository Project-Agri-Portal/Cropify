package com.cropify.services;

import java.util.List;

import com.cropify.dto.MachineryDTO;
import com.cropify.entity.Machinery;

public interface MachineryService{
	// Read operations
	List<Machinery> getAllMachine();
	public Machinery getMachineById(String id);

	// Create operations
	MachineryDTO addMachine(MachineryDTO machineryDTO);
	
	// Delete operations
	public void deleteMachineById(String id);
}
