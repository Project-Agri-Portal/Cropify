package com.cropify.services;

import java.util.List;

import com.cropify.dao.MachineryRepository;
import com.cropify.entity.Machinery;

public interface MachineryService{
	List<Machinery> getAllMachine();
	void addMachine(Machinery machinery);
//	public void updateMachine(String name, String id);
}
