package com.cropify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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


	@GetMapping
	public List<FarmProducts> getFarmProducts(){
		return farmProductsService.getAllFarmProducts();
	}
	
}
