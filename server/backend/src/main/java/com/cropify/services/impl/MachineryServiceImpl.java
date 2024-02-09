package com.cropify.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.MachineryRepository;
import com.cropify.dto.MachineryDTO;
import com.cropify.entity.Machinery;
import com.cropify.services.MachineryService;

@Service
@Transactional
public class MachineryServiceImpl implements MachineryService {
	
	@Autowired
	private MachineryRepository machineryRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Machinery> getAllMachine() {
		return machineryRepository.findAll();
	}

	@Override
	public MachineryDTO addMachine(MachineryDTO machineryDTO) {
		System.out.println(machineryDTO);
		Machinery machinery = mapper.map(machineryDTO, Machinery.class);
		machineryRepository.save(machinery);
		return mapper.map(machinery, MachineryDTO.class);
	}

	@Override
	public Machinery getMachineById(String id) {
		Optional<Machinery> optional = machineryRepository.findByMachineId(id);
		return optional.orElseThrow(() -> new RuntimeException("MachineNotFound"));
	}
	
	@Override
	public void deleteMachineById(String id) { 
		Optional<Machinery> machinery = machineryRepository.findByMachineId(id);
		if(!machinery.isEmpty()) {
			machineryRepository.delete(machinery.get());
		}
		else {
			throw new RuntimeException("MachineNotFound");
		}
	}
	
}
