package com.cropify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.AgricultureProductsDTO;
import com.cropify.services.AgricultureProductsService;

@RestController
@RequestMapping("/api/agriProducts")
@Validated
public class AgricultureProductsController {
	@Autowired
	private AgricultureProductsService productService;
	
	// ------- GET methods ----------------
	@GetMapping("/")
	public ResponseEntity<List<AgricultureProductsDTO>> getAllAgricultureProducts()
	{
		return ResponseEntity.ok(productService.getAllAgricultureProducts());
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<AgricultureProductsDTO> getAgricultureProductById(@PathVariable @NotNull String productId)
	{
		return ResponseEntity.ok(productService.getAgricultureProductById(productId));
	}
	
	// ------- POST methods ----------------
	@PostMapping("/")
	public ResponseEntity<AgricultureProductsDTO> addAgricultureProduct(
			@RequestBody @Valid AgricultureProductsDTO productDto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addAgricultureProduct(productDto));
	}
	
	// ------- DELETE methods ----------------
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable @NotNull String productId)
	{
		productService.deleteAgricultureProductById(productId);
		return ResponseEntity.ok("Product deleted successfully");
	}
}