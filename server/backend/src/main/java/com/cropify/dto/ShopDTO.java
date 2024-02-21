package com.cropify.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
    private Long farmerId;
    private String farmProdId ;
    private String farmProdName;
    private String description;
    private LocalDate expiryDate;
    private double price; 
    private int quantity;
    private String firstName;
    private byte[] img;
	private String path;
}
