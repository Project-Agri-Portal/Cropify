package com.cropify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class SellerMachineryDetailsDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long sellerMachineryId;
	private String machineryId;
	private Long sellerId;
	private int quantity;
	private double price;
	private String description;
	private int isAvailable;
	private int verified;
	
	//-----------------------------Getter and Setters--------------------
	public Long getSellerMachineryId() {
		return sellerMachineryId;
	}
	public void setSellerMachineryId(Long sellerMachineryId) {
		this.sellerMachineryId = sellerMachineryId;
	}
	public String getMachineryId() {
		return machineryId;
	}
	public void setMachineryId(MachineryDTO machineryId) {
		this.machineryId = machineryId.getMachineId();
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(UserDetailsDTO sellerId) {
		this.sellerId = sellerId.getId();
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
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getVerified() {
		return verified;
	}
	public void setVerified(int verified) {
		this.verified = verified;
	}
}
