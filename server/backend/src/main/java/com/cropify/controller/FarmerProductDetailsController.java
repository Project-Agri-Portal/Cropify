package com.cropify.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dao.FarmerProductDetailsRepository;
import com.cropify.dto.FarmerProductDetailsDTO;
import com.cropify.dto.ShopDTO;
import com.cropify.services.FarmerProductDetailsService;

@RestController
@RequestMapping("/api/farmproductdetails")
@CrossOrigin(origins = "http://localhost:3000")
public class FarmerProductDetailsController {
	
	@Autowired
	private FarmerProductDetailsService detailsService;

	@Autowired
	private FarmerProductDetailsRepository detailsRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<FarmerProductDetailsDTO>> getAllFarmProductDetails(){
		return ResponseEntity.ok(detailsService.getAllFarmProductDetails());
	}
	
	@PostMapping("/add/{id}")
	public ResponseEntity<Long> addFarmerProductDetails(@RequestBody FarmerProductDetailsDTO detailsDTO, @PathVariable @NotNull Long id){
		return new ResponseEntity<>(detailsService.addFarmerProductDetails(detailsDTO, id), HttpStatus.CREATED);
	}

	@GetMapping("/join")
	public ResponseEntity<List<ShopDTO>> getAllFarmProduct(){
		return ResponseEntity.ok(detailsService.getAllList());
	}
	
}
