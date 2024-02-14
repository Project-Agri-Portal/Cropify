package com.cropify.controller;

import java.util.List;

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
@RequestMapping("/api/cartmachinery")
public class CartMachineryController {
	
	@Autowired
	private CartMachineryService cartMachineryService;
	
	@PostMapping("/add")
	public ResponseEntity<CartMachineryDTO> addMachineryIntoCart(@RequestBody CartMachineryDTO cartMachineryDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartMachineryService.addMachineryIntoCart(cartMachineryDTO));
	}

	@GetMapping("/{farmerId}")
	public ResponseEntity<List<CartMachineryDTO>> getAllCartMachineByFarmerId(@RequestParam Long farmerId){
		return ResponseEntity.status(HttpStatus.OK).body(cartMachineryService.getAllCartMachineByFarmerId(farmerId));
	}

	@GetMapping("/{machineId}")
	public ResponseEntity<int> deleteCartMachineByMachineId(@RequestParam String machineId){
		return ResponseEntity.status(HttpStatus.OK).body(cartMachineryService.deleteCartMachineById(machineId));
	}

	@GetMapping("/all")
	public ResponseEntity<List<CartMachineryDTO>> getAllCartMachine(){
		return ResponseEntity.status(HttpStatus.OK).body(cartMachineryService.getAllCartMachine());
	}
	
}
