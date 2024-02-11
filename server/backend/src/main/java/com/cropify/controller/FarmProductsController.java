package com.cropify.controller;


import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.FarmProductsDTO;
import com.cropify.entity.FarmProducts;
import com.cropify.services.FarmProductsService;

@RestController
@RequestMapping("/api/farmproducts")
public class FarmProductsController {

	@Autowired
	private FarmProductsService farmProductsService;
	
	@Autowired
	private ModelMapper mapper;
	
	public FarmProductsController() {
		super();
		// TODO Auto-generated constructor stub
	}


//	without ResponseEntity
//	@GetMapping("/all")
//	public List<FarmProducts> getFarmProducts(){
//		return farmProductsService.getAllFarmProducts();
//	}
//	with ResponseEntity
	@GetMapping("/all")
	public ResponseEntity<List<FarmProductsDTO>> getAllFarmProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(farmProductsService.getAllFarmProducts());
	}
	
	@GetMapping("/{farmProductId}")
	public ResponseEntity<?> getFarmProduct(@PathVariable String farmProductId){
		return ResponseEntity.ok(farmProductsService.getFarmProductById(farmProductId));
	}
	
	@PostMapping("/add")
	public ResponseEntity<FarmProductsDTO> addFarmProduct(@RequestBody @Valid FarmProductsDTO farmProductsDTO){
		return new ResponseEntity<>(farmProductsService.addFarmProduct(farmProductsDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{pid}")
	public String deleteFarmProductById(@PathVariable String pid) {
		return farmProductsService.deleteFarmProduct(pid);
	}
	
//	without ResponseEntity
//	@GetMapping("/{pid}")
//	public FarmProducts getFarmProduct(@PathVariable String pid) {
//		return farmProductsService.fetchFarmProductDetails(pid);
//	}
	
}
