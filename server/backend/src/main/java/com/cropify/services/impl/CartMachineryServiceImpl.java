package com.cropify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.CartMachineryRepository;
import com.cropify.dao.MachineryRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.CartMachineryDTO;
import com.cropify.entity.CartMachinery;
import com.cropify.entity.Machinery;
import com.cropify.entity.UserDetails;
import com.cropify.services.CartMachineryService;

@Service
@Transactional
public class CartMachineryServiceImpl implements CartMachineryService{
	
	@Autowired
	private CartMachineryRepository cartMachineryRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MachineryRepository machineryRepository;

	@Autowired
	private UserDetailsRepository detailsRepository;

	@Override
	public Long addMachineIntoCart(CartMachineryDTO cartMachineryDTO) {

		UserDetails farmer = detailsRepository.getReferenceById(cartMachineryDTO.getFarmerId());
		Machinery machinery = machineryRepository.getReferenceById(cartMachineryDTO.getMachineId());
		UserDetails seller = detailsRepository.getReferenceById(cartMachineryDTO.getSellerId());

		CartMachinery cart = mapper.map(cartMachineryDTO, CartMachinery.class);
		farmer.addCartMachineryFarmerList(cart);
		machinery.addCartMachinery(cart);
		seller.addCartMachinerySellerList(cart);
		cart = cartMachineryRepository.save(cart);
		// return mapper.map(machinery, CartMachineryDTO.class);
		return cart.getCid();
	}

	@Override
	public List<CartMachineryDTO> getALLCartMachinery() {
		List<CartMachinery> cartMachineries = cartMachineryRepository.findAll();
		List<CartMachineryDTO> cartMachineryDTOs = cartMachineries.stream()
												   .map(cart -> mapper.map(cart, CartMachineryDTO.class))
												   .collect(Collectors.toList());
		return cartMachineryDTOs;
	}

	@Override
	public List<CartMachineryDTO> getCartMachine(Long id) {
		List<CartMachinery> cartMachinery = cartMachineryRepository.findCartMachineryById(id);
		List<CartMachineryDTO> cartDto = cartMachinery
										.stream()
										.map(cart -> mapper.map(cart, CartMachineryDTO.class))
										.collect(Collectors.toList());
		return cartDto;
	}
	
}
