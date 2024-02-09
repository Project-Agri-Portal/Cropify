package com.cropify.services;

import java.util.List;

import com.cropify.dto.MachineryDTO;
import com.cropify.entity.Machinery;

public interface MachineryService{
	List<Machinery> getAllMachine();
	MachineryDTO addMachine(MachineryDTO machineryDTO);
	public Machinery getMachineById(String id);
	public void deleteMachineById(String id);
}
