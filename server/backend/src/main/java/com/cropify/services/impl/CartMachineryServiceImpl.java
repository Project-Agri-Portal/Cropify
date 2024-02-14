package com.cropify.services.impl;

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
		cartMachinery = cartMachineryRepository.save(cartMachinery);
		return mapper.map(cartMachinery, CartMachineryDTO.class);
	}
	
}
