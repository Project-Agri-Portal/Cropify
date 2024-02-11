package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;

@Entity
public class CartMachinery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	// Mapped with machinery table
	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false)
	private Machinery machineId;
	
	// Mapped with user_details table for farmer id
	@ManyToOne
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;
	
	// Mapped with user_details table for seller_id
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;
	
	@Column
	private int quantity;
	
	@Column(name = "total_amount")
	private double totalAmount;

	/**
	 * @return the cid
	 */
	public Long getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}

	/**
	 * @return the machineId
	 */
	public Machinery getMachineId() {
		return machineId;
	}

	/**
	 * @param machineId the machineId to set
	 */
	public void setMachineId(Machinery machineId) {
		this.machineId = machineId;
	}

	/**
	 * @return the farmerId
	 */
	public UserDetails getFarmerId() {
		return farmerId;
	}

	/**
	 * @param farmerId the farmerId to set
	 */
	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}

	/**
	 * @return the sellerId
	 */
	public UserDetails getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(UserDetails sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
