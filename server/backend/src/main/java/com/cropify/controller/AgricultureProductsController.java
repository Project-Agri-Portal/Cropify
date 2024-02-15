package com.cropify.controller; 

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//For image response 
import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.dto.AgricultureProductsDTO;
import com.cropify.services.AgricultureProductsService;

@RestController
@RequestMapping("/api/agriProducts")
public class AgricultureProductsController {
	@Autowired
	private AgricultureProductsService productService;
	
	// ------- GET methods ----------------
	@GetMapping("/")
	public ResponseEntity<List<AgricultureProductsDTO>> getAllAgricultureProducts()
	{
//		return ResponseEntity.ok(productService.getAllAgricultureProducts());
		return new ResponseEntity<>(productService.getAllAgricultureProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/{apId}")
	public ResponseEntity<AgricultureProductsDTO> getAgricultureProductById(
			@PathVariable @NotNull String apId)
	{
		return ResponseEntity.ok(productService.getAgricultureProductById(apId));
	}
	
	@GetMapping(value = "/image/{apId}",
			produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(
			@PathVariable @NotNull String apId) throws IOException
	{
		return ResponseEntity.ok(productService.downloadImage(apId));
	}
	
	// ------- POST methods ----------------
	// @RequestBody => data from user is in json, to convert it into java object we use this 
	// @valid => objects validations is checked by this annotation
	@PostMapping("/")
	public ResponseEntity<AgricultureProductsDTO> addAgricultureProduct(
			@RequestBody @Valid AgricultureProductsDTO productDto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addAgricultureProduct(productDto));
	}
	
	@PostMapping(value = "/image/{apId}",
			consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(
			@PathVariable @NotNull String apId,
			@RequestParam MultipartFile image) throws IOException
	{
		String productId = productService.uploadImage(apId, image);
		return ResponseEntity.status(HttpStatus.CREATED).body("Image added for agri product id = " + productId);
	}
	
	// ------- DELETE methods ----------------
	@DeleteMapping("/{apId}")
	public ResponseEntity<String> deleteProductById(
			@PathVariable @NotNull String apId)
	{
		productService.deleteAgricultureProductById(apId);
		return ResponseEntity.ok("Product deleted successfully");
	}
}
