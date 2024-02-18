package com.cropify.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.CartMachineryDTO;
import com.cropify.services.CartMachineryService;

@RestController
@RequestMapping("/api/cartmachinery")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class CartMachineryController {
	
	@Autowired
	private CartMachineryService cartMachineryService;
	
	@PostMapping("/add/{farmerId}")
	public ResponseEntity<String> addMachineryIntoCart(
			@PathVariable @NotNull Long farmerId,
			@RequestBody @Valid CartMachineryDTO cartMachineryDTO)
	{
		int cartId = cartMachineryService.addMachineryIntoCart(farmerId, cartMachineryDTO).intValue();
		return ResponseEntity.status(HttpStatus.CREATED).body("Created cart with ID = " + cartId);
	}

	@GetMapping("/{farmerId}")
	public ResponseEntity<List<CartMachineryDTO>> getAllCartMachineByFarmerId(@RequestParam Long farmerId){
		return ResponseEntity.status(HttpStatus.OK).body(cartMachineryService.getAllCartMachineByFarmerId(farmerId));
	}

	@DeleteMapping("/{cartId}")
	public ResponseEntity<Long> deleteCartMachineByMachineId(@RequestParam Long cartId){
		return ResponseEntity.status(HttpStatus.OK).body(cartMachineryService.deleteCartMachineById(cartId));
	}

	@GetMapping("/all")
	public ResponseEntity<List<CartMachineryDTO>> getAllCartMachine(){
		return ResponseEntity.status(HttpStatus.OK).body(cartMachineryService.getAllCartMachine());
	}
	
}
