package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	// ---------------- Constructors ----------------
	
	public CartMachinery() {}
	public CartMachinery(Long cid, Machinery machineId, UserDetails farmerId, UserDetails sellerId, int quantity,
			double totalAmount) {
		super();
		this.cid = cid;
		this.machineId = machineId;
		this.farmerId = farmerId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	
	
	// ------------------ Getter & Setter --------------------
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Machinery getMachineId() {
		return machineId;
	}
	public void setMachineId(Machinery machineId) {
		this.machineId = machineId;
	}
	public UserDetails getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
