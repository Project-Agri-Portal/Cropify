package com.cropify.services;

import java.util.List;


import com.cropify.dto.CartMachineryDTO;

public interface CartMachineryService {
	Long addMachineIntoCart(CartMachineryDTO cartMachineryDTO);
	
	List<CartMachineryDTO> getALLCartMachinery();

	List<CartMachineryDTO> getCartMachine(Long id);
}
