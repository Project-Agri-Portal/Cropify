package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.cropify.entity.Machinery;
import com.cropify.entity.SellerMachineryDetails;
import com.cropify.entity.UserDetails;

public class OrderMachineDetailsDTO {
	private UserDetails farmerId;
//	private SellerMachineryDetails sellerMachineryId;
	private UserDetails sellerId;
	private Machinery machineId;
	private int rentDuration;
	private LocalDate orderDate;

	@Future
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;
	
	//-----------------------------Getter and Setters--------------------

	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}

	/*
	public SellerMachineryDetails getSellerMachineryId() {
		return sellerMachineryId;
	}
	public void setSellerMachineryId(SellerMachineryDetails sellerMachineryId) {
		this.sellerMachineryId = sellerMachineryId;
	}
	*/
	
	public int getRentDuration() {
		return rentDuration;
	}

	public UserDetails getSellerId() {
		return sellerId;
	}

	public void setSellerId(UserDetails sellerId) {
		this.sellerId = sellerId;
	}

	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Machinery getMachineId() {
		return machineId;
	}

	public void setMachineId(Machinery machineId) {
		this.machineId = machineId;
	}

}
