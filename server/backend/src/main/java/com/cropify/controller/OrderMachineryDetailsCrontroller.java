package com.cropify.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.OrderMachineDetailsDTO;
import com.cropify.services.OrderMachineryDetailsService;

@RestController
@RequestMapping("/api/ordermachinerydetails")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderMachineryDetailsCrontroller {

    @Autowired
    private OrderMachineryDetailsService orderMachineryDetailsService;

    @PostMapping("/add/{farmerId}/{totalPrice}")
    public ResponseEntity<Long> machineIntoCartByFarmerId(@RequestParam("farmerId") Long farmerId, @RequestParam("totalPrice") Double totalPrice){
        return ResponseEntity.ok(orderMachineryDetailsService.MachineCartToOrder(farmerId, totalPrice));
    }
    
    // Order list of Machinery
    
    @GetMapping("/orderlist/{userId}")
    public ResponseEntity<List<OrderMachineDetailsDTO>> getAllOrderById(@PathVariable @NotNull Long userId){
    	List<OrderMachineDetailsDTO> detailsDTOs= orderMachineryDetailsService.getTotalOrders(userId);
    	return ResponseEntity.status(HttpStatus.OK).body(detailsDTOs);
    }

}
