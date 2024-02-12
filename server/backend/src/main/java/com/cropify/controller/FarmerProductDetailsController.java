package com.cropify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.FarmerProductDetailsDTO;
import com.cropify.services.FarmerProductDetailsService;

@RestController
@RequestMapping("/api/farmproductdetails")
public class FarmerProductDetailsController {
	
	@Autowired
	private FarmerProductDetailsService detailsService;
	
	@GetMapping("/all")
	public ResponseEntity<List<FarmerProductDetailsDTO>> getAllFarmProductDetails(){
		return ResponseEntity.ok(detailsService.getAllFarmProductDetails());
	}
	
	@PostMapping("/add")
	public ResponseEntity<FarmerProductDetailsDTO> addFarmerProductDetails(@RequestBody FarmerProductDetailsDTO detailsDTO){
		return new ResponseEntity<>(detailsService.addFarmerProductDetails(detailsDTO), HttpStatus.CREATED);
	}
	
}
