package com.cropify.services;

import java.util.List;

import com.cropify.dto.OrderDTO;
import com.cropify.dto.OrderFarmProductDetailsDTO;
import com.cropify.dto.OrderMachineDetailsDTO;

public interface OrderFarmProductDetailsService {
    String addFarmProductToCart(Long farmerId, Double totalPrice);

    List<OrderDTO> getAllOrder(Long customerId);

    Long deleteOrderById(Long cid);
    
    // ------------
    List<OrderFarmProductDetailsDTO> getTotalOrders(Long farmerId);

}
