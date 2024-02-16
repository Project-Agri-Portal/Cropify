package com.cropify.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.dto.LoginDTO;
import com.cropify.dto.UserDetailsDTO;
import com.cropify.services.UserDetailsService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class UserDetailsController {
	@Autowired
	UserDetailsService userService;
	
	// ------- GET methods ----------------
	@GetMapping("/")
	public ResponseEntity<List<UserDetailsDTO>> getAllUsers()
	{
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDetailsDTO> getUserById(@PathVariable @NotNull Long userId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
	}
	
	// ------- POST methods ----------------
	@PostMapping("/") 
	public ResponseEntity<UserDetailsDTO> createUser(@RequestBody @Valid UserDetailsDTO userDto)
	{
		UserDetailsDTO createdUserDto = userService.createUser(userDto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDetailsDTO> loginCustomer(
			@RequestBody LoginDTO credentials)
	{
		return ResponseEntity.ok(userService.loginCustomer(credentials.getEmail(), credentials.getPassword()));
	}
	
	// ------- UPDATE methods ----------------
	@PutMapping("/{userId}")
	public ResponseEntity<UserDetailsDTO> updateUser(
			@PathVariable @NotNull Long userId,
			@RequestBody @Valid UserDetailsDTO userDto)
	{
		UserDetailsDTO updatedUserDto = userService.updateUser(userDto, userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedUserDto);
	}
	
	// ------- DELETE methods ----------------
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable @NotNull Long userId)
	{
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted");
	}
	
	
	// Image Operations ------------------------------------------------------

	@PostMapping(value="/image/{userId}",
			consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImageUser(@PathVariable @NotNull Long userId, 
													@RequestParam MultipartFile userImage)throws IOException{
		Long userId1=userService.uploadImage(userId, userImage);
		return ResponseEntity.status(HttpStatus.CREATED).body("image Uploaded for user Id :"+userId1);
	}
	
	
	@GetMapping(value="/image/{userId}",
			produces = { IMAGE_GIF_VALUE , IMAGE_JPEG_VALUE , IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(@PathVariable @NotNull Long userId) throws IOException{
		return ResponseEntity.ok(userService.downloadImage(userId));
	}
}
