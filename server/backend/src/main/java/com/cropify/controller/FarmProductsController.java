package com.cropify.controller;


import java.util.List;
import java.util.stream.Collectors;

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

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dto.FarmProductsDTO;
import com.cropify.entity.FarmProducts;
import com.cropify.services.FarmProductsService;

@RestController
@RequestMapping("/api/farmProducts")
public class FarmProductsController {

	@Autowired
	private FarmProductsService farmProductsService;

	// ------------- Get operation ------------------
	@GetMapping("/")
	public ResponseEntity<List<FarmProductsDTO>> getAllFarmProducts() {
		return ResponseEntity.ok(farmProductsService.getAllFarmProducts());
	}

	@GetMapping("/{fpId}")
	public ResponseEntity<FarmProductsDTO> getFarmProductById(
			@PathVariable @NotNull String fpId) 
	{
		return ResponseEntity.ok(farmProductsService.getFarmProductById(fpId));
	}

	// ------------- Post operation ------------------
	@PostMapping("/")
	public ResponseEntity<String> addFarmProduct(
			@RequestBody @Valid FarmProductsDTO farmProducts) {
		String fpId = farmProductsService.addFarmProduct(farmProducts);
		return ResponseEntity.status(HttpStatus.CREATED).body("Added farm product with ID = " + fpId);
	}

	// ------------- Put operation ------------------
	@PutMapping("/{fpId}")
	public ResponseEntity<String> updateFarmProduct(
			@PathVariable @NotNull String fpId, 
			@RequestBody @Valid FarmProductsDTO farmProductsDTO) 
	{
		String productId = farmProductsService.updateFarmProduct(fpId, farmProductsDTO);
		if (productId != null)
			return ResponseEntity.status(HttpStatus.CREATED).body("Updated farm product with ID = " + productId);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Enter valid product ID");
	}

	// ------------- Delete operation ------------------
	@DeleteMapping("{fpId}")
	public ResponseEntity<String> deleteFarmProduct(
			@PathVariable @NotNull String fpId) 
	{
		farmProductsService.deleteFarmProduct(fpId);
		return ResponseEntity.ok("Deleted farm product of ID = " + fpId);
	}
	
}
