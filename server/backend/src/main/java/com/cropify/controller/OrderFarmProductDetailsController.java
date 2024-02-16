package com.cropify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.services.OrderFarmProductDetailsService;

@RestController
@RequestMapping("/api/orderfarmproductdetails")
public class OrderFarmProductDetailsController {
    
    @Autowired
    private OrderFarmProductDetailsService orderFarmProductDetailsService;

    @PostMapping("/{customerId}/{totalPrice}")
    public String addCustomerProductToCart(@Param("customerId") Long farmerId, @Param("totalPrice") double totalPrice){
        return orderFarmProductDetailsService.addFarmProductToCart(farmerId, totalPrice);
    }

}
