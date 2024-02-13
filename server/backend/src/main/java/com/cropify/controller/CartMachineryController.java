package com.cropify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.CartMachineryDTO;
import com.cropify.services.CartMachineryService;

@RestController
@RequestMapping("/api/cartMachinery")
public class CartMachineryController {
	
	@Autowired
	private CartMachineryService cartMachineryService;
	
	@PostMapping("/add")
	public ResponseEntity<Long> addMachineryIntoCart(@RequestBody @Valid CartMachineryDTO cartMachineryDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartMachineryService.addMachineIntoCart(cartMachineryDTO));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CartMachineryDTO>> getAllCartMachinery(){
		return new ResponseEntity(cartMachineryService.getALLCartMachinery(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<CartMachineryDTO>> getCartMachineOfFarmerById(@RequestParam Long id){
		return ResponseEntity.ok(cartMachineryService.getCartMachine(id));
	}
	
}
