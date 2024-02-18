package com.cropify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.services.OrderFarmProductDetailsService;

@RestController
@RequestMapping("/api/orderfarmproductdetails")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderFarmProductDetailsController {
    
    @Autowired
    private OrderFarmProductDetailsService orderFarmProductDetailsService;

    @PostMapping("/{customerId}/{totalPrice}")
    public String addCustomerProductToCart(@PathVariable("customerId") Long farmerId, @PathVariable("totalPrice") Double totalPrice){
        return orderFarmProductDetailsService.addFarmProductToCart(farmerId, totalPrice);
    }

}
