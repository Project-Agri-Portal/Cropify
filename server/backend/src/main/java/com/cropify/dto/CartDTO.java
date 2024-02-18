package com.cropify.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private String farmProductName;
    private Long cid;
    private int quantity;
    private double totalAmount;
    private Long customerId;
    private String farmProductId;
    private Long farmerId;
    private LocalDate deliveryDate;
}
