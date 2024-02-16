package com.cropify.dto;

import java.time.LocalDate;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class OrderMachineDetailsDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long oid;
	private String orderId;
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
	public void setFarmerId(UserDetailsDTO farmerId) {
		this.farmerId = farmerId.getId();
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(UserDetailsDTO sellerId) {
		this.sellerId = sellerId.getId();
	}
	public String getMachineId() {
		return machineId;
	}
	
	public String getOrderId(){
		return orderId;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public void setMachineId(MachineryDTO machineId) {
		this.machineId = machineId.getMachineId();
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
