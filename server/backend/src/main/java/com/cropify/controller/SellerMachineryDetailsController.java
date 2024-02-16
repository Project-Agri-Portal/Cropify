package com.cropify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.SellerMachineDTO;
import com.cropify.dto.SellerMachineryDetailsDTO;
import com.cropify.services.SellerMachineryDetailsService;

@RestController
@RequestMapping("/api/sellerMachinery")
@CrossOrigin(origins = "http://localhost:3000")
public class SellerMachineryDetailsController {
	@Autowired
	private SellerMachineryDetailsService service;
	
	// ----------------- GET methods ----------------------
	@GetMapping("/")
	public ResponseEntity<List<SellerMachineryDetailsDTO>> getAllSellerMachineryDetails() {
		List<SellerMachineryDetailsDTO> list = service.getAllSellerMachineryDetails();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{smId}")
	public ResponseEntity<SellerMachineryDetailsDTO> getSellerMachineryDetailById(
			@PathVariable @NotNull Long smId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getSellerMachineryDetailsById(smId));
	}
	
	// ----------------- POST methods ----------------------
	@PostMapping("/{sellerId}")
	public ResponseEntity<String> addSellerMachineryDetails(
			@PathVariable @NotNull Long sellerId,
			@RequestBody @Valid SellerMachineryDetailsDTO smDto)
	{
		int id = service.addSellerMachineryDetails(sellerId, smDto).intValue();
		return ResponseEntity.status(HttpStatus.CREATED).body("Detail saved with ID = " + id);
	}
	
	// ----------------- PUT methods ----------------------
	@PutMapping("/{smId}")
	public ResponseEntity<String> updateSellerMachineryDetails(
			@RequestBody @Valid SellerMachineryDetailsDTO smDto,
			@PathVariable @NotNull Long smId)
	{
		int rows = service.updateSellerMachineryDetails(smDto, smId);
		return ResponseEntity.status(HttpStatus.CREATED).body("Rows updated = " + rows);
	}
	
	// ----------------- DELETE methods ----------------------
	@DeleteMapping("/{smId}")
	public ResponseEntity<String> deleteSellerMachineryDetailsById(@PathVariable @NotNull Long smId) 
	{
		service.deleteSellerMachineryDetailsById(smId);
		return ResponseEntity.status(HttpStatus.OK).body("Detalil deleted successfully");
	}
	
	//method for SellerMachineDTO 
	
	
	@GetMapping("/productlist/{userId}")
	public ResponseEntity<List<SellerMachineDTO>> getAllMachineDetails(@PathVariable @NotNull Long userId){
		List<SellerMachineDTO> dtos=service.getAllMachineIntoNewDTO(userId);
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
	

}
