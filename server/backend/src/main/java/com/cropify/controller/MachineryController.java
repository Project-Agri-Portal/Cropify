package com.cropify.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.dto.FarmProductsDTO;
import com.cropify.dto.MachineryDTO;
import com.cropify.services.MachineryService;


@RestController
@RequestMapping("/api/machinery")
@Validated
public class MachineryController {
	
	@Autowired
	private MachineryService machineryService;
	
	@GetMapping("/")
	public ResponseEntity<List<MachineryDTO>> getAllMachine(){
		return ResponseEntity.status(HttpStatus.OK).body(machineryService.getAllMachine());
	}
	
	@GetMapping("/{machineId}")
	public ResponseEntity<MachineryDTO> getMachineById(@PathVariable @NotNull String machineId){
		return ResponseEntity.status(HttpStatus.OK).body(machineryService.getMachineById(machineId));
	}

	@PostMapping("/")
	public ResponseEntity<MachineryDTO> addMachinery(@RequestBody @Valid MachineryDTO machineryDTO) {
//		System.out.println(machineryDTO);
		machineryService.addMachine(machineryDTO);
		return new ResponseEntity<>(machineryDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{machineId}")
	public ResponseEntity<String> deleteMachineById(@PathVariable @NotNull String machineId){
		machineryService.deleteMachineById(machineId);
		return ResponseEntity.status(HttpStatus.OK).body("Machine of ID = " + machineId + " is deleted");
	}
	
	
	
	
	// Image Operations ------------------------------------------------------

	@PostMapping(value="/image/{mId}",
			consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImageMachinery(@PathVariable @NotNull String mId, 
													@RequestParam MultipartFile mImage)throws IOException{
		String machineId= machineryService.uploadImage(mId, mImage);
		return ResponseEntity.status(HttpStatus.CREATED).body("image Uploaded for machine Id :"+machineId);
	}
	
	
	@GetMapping(value="/image/{mId}",
			produces = { IMAGE_GIF_VALUE , IMAGE_JPEG_VALUE , IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(@PathVariable @NotNull String mId) throws IOException{
		return ResponseEntity.ok(machineryService.downloadImage(mId));
	}
	
}
