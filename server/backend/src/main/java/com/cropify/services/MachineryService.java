package com.cropify.services;

import java.util.List;

import com.cropify.dto.MachineryDTO;

public interface MachineryService{
	// Read operations
	List<MachineryDTO> getAllMachine();
	public MachineryDTO getMachineById(String id);

	// Create operations
	MachineryDTO addMachine(MachineryDTO machineryDTO);
	
	// Delete operations
	public void deleteMachineById(String id);
}
