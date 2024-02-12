package com.cropify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.SellerMachineryDetailsDTO;
import com.cropify.services.SellerMachineryDetailsService;

@RestController
@RequestMapping("/api/sellerMachinery")
public class SellerMachineryDetailsController {
	@Autowired
	private SellerMachineryDetailsService service;
	
	// ----------------- GET methods ----------------------
	@GetMapping("/")
	public ResponseEntity<List<SellerMachineryDetailsDTO>> getAllSellerMachineryDetails() {
		List<SellerMachineryDetailsDTO> list = service.getAllSellerMachineryDetails();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SellerMachineryDetailsDTO> getSellerMachineryDetailById(
			@PathVariable @NotNull Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getSellerMachineryDetailsById(id));
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
	@PutMapping("/{id}")
	public ResponseEntity<SellerMachineryDetailsDTO> updateSellerMachineryDetails(
			@RequestBody @Valid SellerMachineryDetailsDTO smDto,
			@PathVariable @NotNull Long id)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.updateSellerMachineryDetails(smDto, id));
	}
	
	// ----------------- DELETE methods ----------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSellerMachineryDetailsById(@PathVariable @NotNull Long id) 
	{
		service.deleteSellerMachineryDetailsById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Detalil deleted successfully");
	}
}
