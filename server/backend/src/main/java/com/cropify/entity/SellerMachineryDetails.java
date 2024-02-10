package com.cropify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SellerMachineryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_machine_id")
	private Long sellerMachineryId;

	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false)
	private Machinery machineryId;

	@ManyToOne	// owning
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private boolean isAvailable;
	
	// ------------ Relationship Mapping ------------------------------
	@OneToMany(mappedBy = "sellerMachineryId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();
	
	// ------------ Constructors ------------------------
	public SellerMachineryDetails() {}
	
	public SellerMachineryDetails(Long sellerMachineryId, Machinery machineryId, UserDetails sellerId, int quantity,
			double price, String description, boolean isAvailable) {
		this.sellerMachineryId = sellerMachineryId;
		this.machineryId = machineryId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
	}

	//-----------------------------Getter and Setters--------------------
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
	
	public Long getSellerMachineryId() {
		return sellerMachineryId;
	}

	public void setSellerMachineryId(Long sellerMachineryId) {
		this.sellerMachineryId = sellerMachineryId;
	}

	public List<OrderMachineDetails> getOrderMachineDetails() {
		return orderMachineDetails;
	}

	public void setOrderMachineDetails(List<OrderMachineDetails> orderMachineDetails) {
		this.orderMachineDetails = orderMachineDetails;
	}

	// -------------- Helper Methods for: --------------------
	public void addOrderMachineDetails(OrderMachineDetails machineDetails) {
		orderMachineDetails.add(machineDetails);
		machineDetails.setSellerMachineryId(this);
	}
	public void removeOrderMachineDetails(OrderMachineDetails machineDetails) {
		orderMachineDetails.remove(machineDetails);
		machineDetails.setSellerMachineryId(null);
	}
	
}
