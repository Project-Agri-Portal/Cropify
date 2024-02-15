package com.cropify.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.customexception.ResourceNotFoundException;
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
	public List<MachineryDTO> getAllMachine() {
		List<MachineryDTO> list = machineryRepository.findAll()
				.stream()
				.map(machine -> mapper.map(machine, MachineryDTO.class))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public MachineryDTO addMachine(MachineryDTO machineryDTO) {
		System.out.println(machineryDTO);
		Machinery machinery = mapper.map(machineryDTO, Machinery.class);
		machineryRepository.save(machinery);
		return mapper.map(machinery, MachineryDTO.class);
	}

	@Override
	public MachineryDTO getMachineById(String id) {
		Machinery machine = machineryRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("machine not found"));
		return mapper.map(machine, MachineryDTO.class);
	}
	
	@Override
	public void deleteMachineById(String id) { 
		boolean machineExists = machineryRepository.existsById(id);
		if (machineExists)
			machineryRepository.deleteById(id);
		else
			throw new RuntimeException("machine with id = " + id + " not found");
	}

	//Download Image
	
	@Override
	public byte[] downloadImage(String mId) throws IOException {
		Machinery machine= machineryRepository.findById(mId).orElseThrow(()-> new ResourceNotFoundException("Machine is not present"));
		
		return machine.getImgPath();
	}
	
	//Upload Image

	@Override
	public String uploadImage(String mId, MultipartFile mImage) throws IOException {
		Machinery machine= machineryRepository.findById(mId).orElseThrow(()-> new ResourceNotFoundException("Machine image not found"));
		machine.setImgPath(mImage.getBytes());
		return machine.getMachineId();
	}
	
}
