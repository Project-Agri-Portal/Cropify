package com.cropify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.CartMachineryDTO;
import com.cropify.services.CartMachineryService;

@RestController
@RequestMapping("/api/cartmachinery")
public class CartMachineryController {
	
	@Autowired
	private CartMachineryService cartMachineryService;
	
	@PostMapping("/add")
	public ResponseEntity<CartMachineryDTO> addMachineryIntoCart(CartMachineryDTO cartMachineryDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartMachineryService.addMachineryIntoCart(cartMachineryDTO));
	}
	
}
