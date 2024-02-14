package com.cropify.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.CartMachineryRepository;
import com.cropify.dto.CartMachineryDTO;
import com.cropify.entity.CartMachinery;
import com.cropify.services.CartMachineryService;

@Service
@Transactional
public class CartMachineryServiceImpl implements CartMachineryService{
	@Autowired
	private CartMachineryRepository cartMachineryRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CartMachineryDTO addMachineryIntoCart(CartMachineryDTO cartMachineryDTO) {
		CartMachinery cartMachinery = mapper.map(cartMachineryDTO, CartMachinery.class);
		return mapper.map(cartMachineryRepository.save(cartMachinery), CartMachineryDTO.class);
	}

	@Override
	public List<CartMachineryDTO> getAllCartMachineByFarmerId(Long farmerId) {
		List<CartMachinery> cartMachineries = cartMachineryRepository.findCartByFarmerId(farmerId);
		List<CartMachineryDTO> cartMachineryDTOs = cartMachineries.stream()
												   .map(cart -> mapper.
												   map(cart, CartMachineryDTO.class))
												   .collect(Collectors.toList());
		return cartMachineryDTOs;
	}

	@Override
	public int deleteCartMachineById(String machineId) {
		int count = cartMachineryRepository.deleteByMachineId(machineId);
		return count;
	}

	@Override
	public List<CartMachineryDTO> getAllCartMachine() {
		List<CartMachinery> cartMachineries = cartMachineryRepository.findAll();
		List<CartMachineryDTO> cartMachineryDTOs = cartMachineries.stream().map(cart -> mapper.map(cart, CartMachineryDTO.class)).collect(Collectors.toList());
		return cartMachineryDTOs;
	}
	
}
