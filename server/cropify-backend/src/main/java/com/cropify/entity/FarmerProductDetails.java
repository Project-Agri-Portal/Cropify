package com.cropify.entity;

import java.time.LocalDate;

public class FarmerProductDetails {
	private Long farmerId;
	private String farmProductId;
	private int quantity;
	private double price;
	private String description;
	private LocalDate harvestDate;
	private LocalDate expiryDate;
	private FarmProductsStatus farmProductStatus;
	
}
