package com.cropify.services;

public interface OrderMachineryDetailsService {

    Long MachineCartToOrder(Long FarmerId, Double totalPrice);

    // public List<CartMachineryDTO> getCartMachineById(Long id);
    
} 
