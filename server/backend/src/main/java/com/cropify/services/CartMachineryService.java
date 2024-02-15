package com.cropify.services;

import java.util.List;

import com.cropify.dto.CartMachineryDTO;

public interface CartMachineryService {
	
	CartMachineryDTO addMachineryIntoCart(CartMachineryDTO cartMachineryDTO);

	Long deleteCartMachineById(Long cartId);

	List<CartMachineryDTO> getAllCartMachine();

	public List<CartMachineryDTO> getAllCartMachineByFarmerId(Long farmerId);
	
	Long addMachineryIntoCart(Long farmerId, CartMachineryDTO cartMachineryDTO);
}
