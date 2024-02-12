package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.cropify.entity.AgricultureProducts;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmProductsStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class SellerAgricultureProductDetailsDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long sellerAgricultureProductId;
	private String agriProductId;
	private Long sellerId;
	private int quantity;
	private double price;
	private String description;
	private boolean verified;
	
	@Future
	private LocalDate expiryDate;
	private FarmProductsStatus sellerProductStatus;
	
	//-----------------------------Getter and Setters--------------------

	public Long getSellerAgricultureProductId() {
		return sellerAgricultureProductId;
	}

	public void setSellerAgricultureProductId(Long sellerAgricultureProductId) {
		this.sellerAgricultureProductId = sellerAgricultureProductId;
	}

	public String getAgriProductId() {
		return agriProductId;
	}

	public void setAgriProductId(String agriProductId) {
		this.agriProductId = agriProductId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
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

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
