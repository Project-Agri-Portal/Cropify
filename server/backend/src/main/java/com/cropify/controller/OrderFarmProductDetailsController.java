package com.cropify.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.OrderDTO;
import com.cropify.dto.OrderFarmProductDetailsDTO;
import com.cropify.dto.OrderMachineDetailsDTO;
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

    @GetMapping("/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrderById(@PathVariable Long customerId){
        // return orderFarmProductDetailsService.getOrder(customerId);
        return ResponseEntity.ok(orderFarmProductDetailsService.getAllOrder(customerId));
    }

    @DeleteMapping("/{oid}")
    public ResponseEntity<Long> deleteOrder(@PathVariable Long oid){
        return ResponseEntity.ok(orderFarmProductDetailsService.deleteOrderById(oid));
    }
    
    // -------------
    @GetMapping("/orderlist/{userId}")
    public ResponseEntity<List<OrderFarmProductDetailsDTO>> getAllOrderById(@PathVariable @NotNull Long userId){
    	List<OrderFarmProductDetailsDTO> detailsDTOs= orderFarmProductDetailsService.getTotalOrders(userId);
    	return ResponseEntity.status(HttpStatus.OK).body(detailsDTOs);
    }
}
