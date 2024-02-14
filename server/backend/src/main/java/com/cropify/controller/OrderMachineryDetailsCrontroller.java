package com.cropify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.services.OrderMachineryDetailsService;

@RestController
@RequestMapping("/api/ordermachinerydetails")
public class OrderMachineryDetailsCrontroller {

    @Autowired
    private OrderMachineryDetailsService orderMachineryDetailsService;

    @PostMapping("/add/{farmerId}/{totalPrice}")
    public ResponseEntity<Long> machineIntoCartByFarmerId(@RequestParam("farmerId") Long farmerId, @RequestParam("totalPrice") Double totalPrice){
        return ResponseEntity.ok(orderMachineryDetailsService.MachineCartToOrder(farmerId, totalPrice));
    }

}
