package com.cropify.entity;

import java.time.LocalDate;

public class SellerAgricultureProductDetails {
	private Long sellerId;
	private String sellerProductId;
	private int quantity;
	private double price;
	private String description;
	private LocalDate expiryDate;
	private FarmProductsStatus sellerProductStatus;
	
}
