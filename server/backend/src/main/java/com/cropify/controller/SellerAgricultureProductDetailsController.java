package com.cropify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.SellerAgricultureProductDetailsDTO;
import com.cropify.services.SellerAgricultureProductDetailsService;

@RestController
@RequestMapping("/api/sellerAgriProducts")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class SellerAgricultureProductDetailsController {
	
	@Autowired
	private SellerAgricultureProductDetailsService service;
	
	// ------- GET methods ----------------
	@GetMapping("/")
	public ResponseEntity<List<SellerAgricultureProductDetailsDTO>> getAllAgricultureProducts()
	{
		List<SellerAgricultureProductDetailsDTO> list = service.getAllAgricultureProducts();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	@GetMapping("/{productId}")
	public ResponseEntity<SellerAgricultureProductDetailsDTO> getAgricultureProductById(
			@PathVariable @NotNull Long productId)
	{
		return ResponseEntity.ok(service.getAgricultureProductById(productId));
	}
	
	// ------- POST methods ----------------
	@PostMapping("/{sellerId}")
	public ResponseEntity<String> addAgricultureProduct(
			@PathVariable @NotNull Long sellerId,
			@RequestBody @Valid SellerAgricultureProductDetailsDTO sapDto)
	{
		int sapId = service.addAgricultureProduct(sellerId, sapDto).intValue();
		return ResponseEntity.status(HttpStatus.CREATED).body("Product saved with ID = " + sapId);
	}
	
	// ------- PUT methods ----------------
	@PutMapping("/{productId}")
	public ResponseEntity<String> updateAgricultureProduct(
			@PathVariable @NotNull Long productId,
			@RequestBody @Valid SellerAgricultureProductDetailsDTO sapDto)
	{
//		SellerAgricultureProductDetailsDTO updatedProductDTO = service.updateAgricultureProduct(productId, sapDto);
//		if (updatedProductDTO != null) 
//			return ResponseEntity.status(HttpStatus.CREATED).body("Updated the agriculture product");
//		else
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such agriculture product found");
		
		int rows = service.updateSellerAgriucltureProductDetails(productId, sapDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("updated rows = " + rows);
	}
	
	// ------- DELETE methods ----------------
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteAgricultureProduct(
			@PathVariable @NotNull Long productId)
	{
		service.deleteAgricultureProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted product with ID = " + productId);
	}
}
