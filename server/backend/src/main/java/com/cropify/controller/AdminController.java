package com.cropify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.AdminDTO;
import com.cropify.services.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// POST
	@PostMapping("/")
	public ResponseEntity<AdminDTO> createAdmin(@RequestBody @Valid AdminDTO adminDto) {
		AdminDTO createdAdminDTO = this.adminService.addAdmin(adminDto);
		return new ResponseEntity<>(createdAdminDTO, HttpStatus.CREATED);

	}

	// PUT
	@PutMapping("/{adminId}")
	public ResponseEntity<AdminDTO> updateAdmin(@Valid @RequestBody AdminDTO adminDto, @PathVariable long adminId) {
		AdminDTO updatedAdminDto = this.adminService.updateAdmin(adminDto, adminId);
		return ResponseEntity.ok(updatedAdminDto);
	}

	// DELETE
	@DeleteMapping("/{adminId}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Long adminId) {
		this.adminService.deleteAdmin(adminId);
		return ResponseEntity.ok("deleted");
	}

	// GET
	@GetMapping("/{adminId}")
	public ResponseEntity<?> getAdminById(@PathVariable Long adminId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.adminService.getAdmin(adminId));
	}

	// GET ALL
	@GetMapping("/")
	public ResponseEntity<List<AdminDTO>> getAllAdmins() {
		return ResponseEntity.ok(this.adminService.getAllAdmins());
	}

}
