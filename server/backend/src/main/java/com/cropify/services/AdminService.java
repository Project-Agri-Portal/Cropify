package com.cropify.services;

import java.util.List;

import com.cropify.dto.AdminDTO;

public interface AdminService {

	// add
	public AdminDTO addAdmin(AdminDTO adminDto);

	// delete
	public void deleteAdmin(Long adminId);

	// get
	public AdminDTO getAdmin(Long adminId);

	// getAll
	public List<AdminDTO> getAllAdmins();

	// update
	public AdminDTO updateAdmin(AdminDTO adminDto, Long adminId);
}
