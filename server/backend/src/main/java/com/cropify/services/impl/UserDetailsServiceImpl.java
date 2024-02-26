package com.cropify.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.UserDetailsDTO;
import com.cropify.entity.UserDetails;
import com.cropify.services.UserDetailsService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsRepository userRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private MailSenderService mailSenderService;

	// Custom error message for user not found by ID
	private StringBuilder errorMessage = new StringBuilder("User Not found for ID = ");

	// ---------------- Service Interface Methods ---------------------------
	// ---------------- Get operations ----------------
	@Override
	public List<UserDetailsDTO> getAllUsers() {
		List<UserDetails> users = userRepo.findAll();
		List<UserDetailsDTO> userDtos = users.stream().map(user -> mapper.map(user, UserDetailsDTO.class))
				.collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDetailsDTO getUserById(Long userId) {

		// UserDetails user = userRepo.getReferenceById(userId);
		UserDetails user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(errorMessage.append(userId).toString()));
		UserDetailsDTO userDto = mapper.map(user, UserDetailsDTO.class);
		return userDto;
	}

	@Override
	public List<UserDetailsDTO> getUser(String userType) {
		List<UserDetails> userDetails = userRepo.findUser(userType.toUpperCase());
		List<UserDetailsDTO> userDetailsDTOs = userDetails.stream()
				.map((user) -> mapper.map(user, UserDetailsDTO.class)).collect(Collectors.toList());
		return userDetailsDTOs;
	}

	// ---------------- Create operations ----------------
	@Override
	public UserDetailsDTO createUser(UserDetailsDTO userDto) {
		String email = userDto.getEmail();
		UserDetails user = mapper.map(userDto, UserDetails.class);
		UserDetails savedUser = userRepo.save(user);
		
		if (user.getUserType().toString().toUpperCase() == "CUSTOMER") {
			mailSenderService.sendEmail(email, "Welcome to Cropify - Your Agriculture Portal", "Dear "
					+ user.getFirstName() + ",\n"
					+ "Welcome to Cropify, your one-stop destination for all your agriculture needs. We are excited to have you on board and look forward to connecting farmers, customers, and sellers in a thriving agricultural community."
					+ "\n \n Congratulations on becoming a valued member of Cropify! As a customer, you now have access to a wide variety of fresh and high-quality fruits and vegetables directly from local farmers. Explore our marketplace, place your orders, and enjoy the goodness of farm-fresh produce delivered right to your doorstep"
					+ "Remember, Cropify is more than just a platform; it's a community. Feel free to explore, engage, and make the most out of your agricultural journey with Cropify.\r\n"
					+ //
					"\r\n" + //
					"If you have any questions, concerns, or feedback, our support team is here to help. Don't hesitate to reach out.\r\n"
					+ //
					"\r\n" + //
					"Happy farming!\r\n" + //
					"\r\n" + //
					"Best regards,\r\n" + //
					"\r\n" + //
					"The Cropify Team");
		} else if (user.getUserType().toString().toUpperCase() == "FARMER") {
			mailSenderService.sendEmail(email, "Welcome to Cropify - Your Agriculture Portal", "Dear "
					+ user.getFirstName() + ","
					+ " \n We're thrilled to have you as a part of Cropify's farming community! Now, you can showcase your agricultural products to a broader audience. List your fruits, vegetables, and other farm produce on our platform and connect with customers eager to support local farmers."
					+ "Remember, Cropify is more than just a platform; it's a community. Feel free to explore, engage, and make the most out of your agricultural journey with Cropify.\r\n"
					+ //
					"\r\n" + //
					"If you have any questions, concerns, or feedback, our support team is here to help. Don't hesitate to reach out.\r\n"
					+ //
					"\r\n" + //
					"Happy farming!\r\n" + //
					"\r\n" + //
					"Best regards,\r\n" + //
					"\r\n" + //
					"The Cropify Team");
		} else if (user.getUserType().toString().toUpperCase() == "SELLER") {
			mailSenderService.sendEmail(email, "Welcome to Cropify - Your Agriculture Portal", "Dear "
					+ user.getFirstName() + ","
					+ " \n Welcome to Cropify! As a seller offering machine rental services, you play a crucial role in supporting farmers and contributing to the success of agriculture. List your machinery on Cropify, and let farmers find the right equipment for their needs effortlessly."
					+ "Remember, Cropify is more than just a platform; it's a community. Feel free to explore, engage, and make the most out of your agricultural journey with Cropify.\r\n"
					+ //
					"\r\n" + //
					"If you have any questions, concerns, or feedback, our support team is here to help. Don't hesitate to reach out.\r\n"
					+ //
					"\r\n" + //
					"Happy farming!\r\n" + //
					"\r\n" + //
					"Best regards,\r\n" + //
					"\r\n" + //
					"The Cropify Team");
		}
		
		return mapper.map(savedUser, UserDetailsDTO.class);
	}

	// ---------------- Update operations ----------------
	@Override
	public int updateUser(UserDetailsDTO userDto, Long userId) {
		UserDetails user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(errorMessage.append(userId).toString()));
		int rowsAffected = userRepo.updateUserDetails(userDto.getFirstName(), userDto.getLastName(),
				userDto.getMobileNo(), userDto.getEmail(), userId);
		return rowsAffected;
	}

	@Override
	public void updateStatusById(Long id, String status) {
		userRepo.updateStatusById(id, status);
	}

	// ---------------- Delete operations ----------------
	@Override
	public void deleteUser(Long userId) {
		boolean userExists = userRepo.existsById(userId);
		if (userExists)
			userRepo.deleteById(userId);
		else
			throw new ResourceNotFoundException(errorMessage.append(userId).toString());
	}

	// Download Image

	@Override
	public byte[] downloadImage(Long userId) throws IOException {
		UserDetails userDetails = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User is not Found"));

		return userDetails.getImgPath();
	}

	// Upload Image

	@Override
	public Long uploadImage(Long userId, MultipartFile userImage) throws IOException {
		UserDetails userDetails = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User is not Found"));
		userDetails.setImgPath(userImage.getBytes());
		return userDetails.getId();
	}

	// --------------- Login Operation ----------------------
	@Override
	public UserDetailsDTO loginCustomer(String email, String password) {

		UserDetails user = userRepo.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials"));

		return mapper.map(user, UserDetailsDTO.class);
	}

}
