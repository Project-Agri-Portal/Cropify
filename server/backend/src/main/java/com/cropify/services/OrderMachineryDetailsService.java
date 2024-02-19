package com.cropify.services;

import java.util.List;

import com.cropify.dto.OrderMachineDetailsDTO;
import com.cropify.entity.OrderMachineDetails;

public interface OrderMachineryDetailsService {

    Long MachineCartToOrder(Long FarmerId, Double totalPrice);

    // public List<CartMachineryDTO> getCartMachineById(Long id);
    
    
    // Order list of Machinery
    List<OrderMachineDetailsDTO> getTotalOrders(Long sellerId);
    
    Long deleteOrderByOID(Long oid);
    
    
} 
