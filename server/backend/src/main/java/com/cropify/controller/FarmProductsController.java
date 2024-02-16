package com.cropify.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// For image response 
import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import com.cropify.dto.FarmProductsDTO;
import com.cropify.services.FarmProductsService;

@RestController
@RequestMapping("/api/farmProducts")
@CrossOrigin(origins = "http://localhost:3000")
public class FarmProductsController {

	@Autowired
	private FarmProductsService farmProductsService;

	// ------------- Get operation ------------------
	@GetMapping("/")
	public ResponseEntity<List<FarmProductsDTO>> getAllFarmProducts() {
		return ResponseEntity.ok(farmProductsService.getAllFarmProducts());
	}
	
	@GetMapping("/{fpId}")
	public ResponseEntity<FarmProductsDTO> getFarmProductById(
			@PathVariable @NotNull String fpId) 
	{
		return ResponseEntity.ok(farmProductsService.getFarmProductById(fpId));
	}
	// ---- Image fetch operation ----
	@GetMapping(value = "/image/{fpId}",
			// These values below are imported from http package of springframework, check import list above
			produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(
			@PathVariable @NotNull String fpId) throws IOException
	{
		return ResponseEntity.ok(farmProductsService.downloadImage(fpId));
	}

	// ------------- Post operation ------------------
	@PostMapping("/")
	public ResponseEntity<String> addFarmProduct(
			@RequestBody @Valid FarmProductsDTO farmProducts) {
		String fpId = farmProductsService.addFarmProduct(farmProducts);
		return ResponseEntity.status(HttpStatus.CREATED).body("Added farm product with ID = " + fpId);
	}
	// ---- Image adding operation ----
	@PostMapping(value = "/image/{fpId}",
			consumes = "multipart/form-data")	// this property is required only for swagger testing
	public ResponseEntity<?> addImageFarmProduct(
			@PathVariable @NotNull String fpId,
			@RequestParam MultipartFile fpImage) throws IOException
	{
		String productId = farmProductsService.uploadImage(fpId, fpImage);
		return ResponseEntity.status(HttpStatus.CREATED).body("Image added for farm product id = " + productId);
	}

	// ------------- Put operation ------------------
	@PutMapping("/{fpId}")
	public ResponseEntity<String> updateFarmProduct(
			@PathVariable @NotNull String fpId, 
			@RequestBody @Valid FarmProductsDTO farmProductsDTO) 
	{
		String productId = farmProductsService.updateFarmProduct(fpId, farmProductsDTO);
		if (productId != null)
			return ResponseEntity.status(HttpStatus.CREATED).body("Updated farm product with ID = " + productId);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter valid product ID");
	}

	// ------------- Delete operation ------------------
	@DeleteMapping("{fpId}")
	public ResponseEntity<String> deleteFarmProduct(
			@PathVariable @NotNull String fpId) 
	{
		farmProductsService.deleteFarmProduct(fpId);
		return ResponseEntity.ok("Deleted farm product of ID = " + fpId);
	}
	
}
