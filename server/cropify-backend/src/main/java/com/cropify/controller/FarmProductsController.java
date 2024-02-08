package com.cropify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.entity.FarmProducts;
import com.cropify.services.FarmProductsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/farmproducts")
public class FarmProductsController {

	@Autowired
	private FarmProductsService farmProductsService;
	
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
	public ResponseEntity<?> getFarmProducts(){
//		return new ResponseEntity<>(farmProductsService.getAllFarmProducts(), HttpStatus.OK);
		return ResponseEntity.ok(farmProductsService.getAllFarmProducts());
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
//	with ResponseEntity
	@GetMapping("/{pid}")
	public ResponseEntity<?> getFarmProduct(@PathVariable String pid) {
		try {
			return new ResponseEntity<>(farmProductsService.fetchFarmProductDetails(pid), HttpStatus.OK);
		}
		catch(RuntimeException e) {
//			you generate status code using HttpStatus
			System.out.println("Error in controller getFarmProduct() " + e);
			return new ResponseEntity<>("Error in controller getFarmProduct() " + e, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public FarmProducts addFarmProduct(@RequestBody FarmProducts farmProducts) {
		return farmProductsService.addFarmProduct(farmProducts);
	}
	
//	@GetMapping("/")
}
