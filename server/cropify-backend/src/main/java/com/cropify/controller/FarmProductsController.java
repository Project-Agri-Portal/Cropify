package com.cropify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.entity.FarmProducts;
import com.cropify.services.FarmProductsService;

@RestController
@RequestMapping("/farmproducts")
public class FarmProductsController {

	@Autowired
	private FarmProductsService farmProductsService;
	
	public FarmProductsController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@GetMapping("/all")
	public List<FarmProducts> getFarmProducts(){
		return farmProductsService.getAllFarmProducts();
	}
	
//	@GetMapping
//	public FarmProducts getById() {
//		return farmProductsService.
//	}
	
	
	@DeleteMapping("/{pid}")
	public String deleteFarmProductById(@PathVariable String pid) {
		return farmProductsService.deleteFarmProduct(pid);
	}
	
	@GetMapping("/{pid}")
	public FarmProducts getFarmProduct(@PathVariable String pid) {
		return farmProductsService.fetchFarmProductDetails(pid);
	}
	
	@PostMapping
	public FarmProducts addFarmProduct(@RequestBody FarmProducts farmProducts) {
		return farmProductsService.addFarmProduct(farmProducts);
	}
}
