package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

public class OrderMachineDetailsDTO {
	private Long farmerId;
	private Long sellerId;
	private String machineId;
	private int rentDuration;
	private LocalDate orderDate;

	@Future
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;

	//-----------------------------Getter and Setters--------------------
	public Long getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public int getRentDuration() {
		return rentDuration;
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
	
	
}
