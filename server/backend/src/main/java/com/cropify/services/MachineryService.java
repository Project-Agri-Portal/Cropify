package com.cropify.services;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.dto.MachineryDTO;
import com.cropify.dto.SellerMachineDTO;

public interface MachineryService{
	// Read operations
	List<MachineryDTO> getAllMachine();
	public MachineryDTO getMachineById(String id);

	// Create operations
	MachineryDTO addMachine(MachineryDTO machineryDTO);
	
	// Delete operations
	public void deleteMachineById(String id);
	
	//Download image
	byte[] downloadImage(String mId) throws IOException;
	
	//Upload image
	String uploadImage(String mId,MultipartFile mImage) throws IOException;
	
}

