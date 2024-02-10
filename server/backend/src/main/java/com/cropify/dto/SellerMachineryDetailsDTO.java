package com.cropify.dto;

import com.cropify.entity.Machinery;
import com.cropify.entity.UserDetails;

public class SellerMachineryDetailsDTO {

	private Long sellerMachineryId;
	private Machinery machineryId;
	private UserDetails sellerId;
	private int quantity;
	private double price;
	private String description;
	private boolean isAvailable;
	private boolean verified;
	
	//-----------------------------Getter and Setters--------------------

	public Long getSellerMachineryId() {
		return sellerMachineryId;
	}

	public void setSellerMachineryId(Long sellerMachineryId) {
		this.sellerMachineryId = sellerMachineryId;
	}

	public Machinery getMachineryId() {
		return machineryId;
	}

	public void setMachineryId(Machinery machineryId) {
		this.machineryId = machineryId;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
