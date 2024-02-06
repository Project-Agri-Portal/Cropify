package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SellerAgricultureProductDetails {
	@ManyToOne	// owning
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;
	
	@JoinColumn(name = "seller_prod_id", nullable = false)
	private AgricultureProducts sellerAgriProductId;
	
	@Column
	private int quantity;
	
	@Column
	private double price;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	@Column(name = "seller_prod_status")
	@Enumerated(EnumType.STRING)
	private FarmProductsStatus sellerProductStatus;
	
	//-----------------------------Getter and Setters--------------------

	public UserDetails getSellerId() {
		return sellerId;
	}

	public void setSellerId(UserDetails sellerId) {
		this.sellerId = sellerId;
	}

	public AgricultureProducts getSellerAgriProductId() {
		return sellerAgriProductId;
	}

	public void setSellerAgriProductId(AgricultureProducts sellerAgriProductId) {
		this.sellerAgriProductId = sellerAgriProductId;
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
