package com.cropify.dto;

import java.time.LocalDate;

import com.cropify.entity.enums.FarmOrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long oid;
    private String orderId;
    private String farmProductName;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private int quantity;
    private double totalPrice;
    private FarmOrderStatus farmOrderStatus;
}
