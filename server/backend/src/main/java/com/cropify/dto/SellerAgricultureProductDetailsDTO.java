package com.cropify.dto;

import java.time.LocalDate;

import com.cropify.entity.AgricultureProducts;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmProductsStatus;

public class SellerAgricultureProductDetailsDTO {

	private Long sellerAgricultureProductId;

	private AgricultureProducts agriProductId;

	private UserDetails sellerId;

	private int quantity;

	private double price;

	private String description;

	private LocalDate expiryDate;

	private FarmProductsStatus sellerProductStatus;
	
	//-----------------------------Getter and Setters--------------------

	public Long getSellerAgricultureProductId() {
		return sellerAgricultureProductId;
	}

	public void setSellerAgricultureProductId(Long sellerAgricultureProductId) {
		this.sellerAgricultureProductId = sellerAgricultureProductId;
	}

	public AgricultureProducts getAgriProductId() {
		return agriProductId;
	}

	public void setAgriProductId(AgricultureProducts agriProductId) {
		this.agriProductId = agriProductId;
	}

	public UserDetails getSellerId() {
		return sellerId;
	}

	public void setSellerId(UserDetails sellerId) {
		this.sellerId = sellerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public FarmProductsStatus getSellerProductStatus() {
		return sellerProductStatus;
	}

	public void setSellerProductStatus(FarmProductsStatus sellerProductStatus) {
		this.sellerProductStatus = sellerProductStatus;
	}

}
