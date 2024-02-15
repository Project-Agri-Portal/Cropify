package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SellerMachineryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_machine_id")
	private Long sellerMachineryId;

	// Mapped with Machinery table
	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false)
	private Machinery machineryId;

	// Mapped with UserDetails table
	@ManyToOne	// owning
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;
	
	@Column(nullable = false)
	private int quantity;

	@Column(name = "avail_quantity")
	private int availQuantity;
	
	@Column(nullable = false)
	private double price;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private String verified;


	/*
	// ------------ Relationship Mapping ------------------------------
	// Mapped with OrderMachineDetails table
//	@OneToMany(mappedBy = "sellerMachineryId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderMachineDetails> orderMachineSellerDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "machineId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();
	*/
	// ------------ Constructors ------------------------
	public SellerMachineryDetails() {}
	
	// public SellerMachineryDetails(Long sellerMachineryId) {
	// 	this.sellerMachineryId = sellerMachineryId;
	// }

	// public SellerMachineryDetails(Long sellerMachineryId) {
	// 	this.sellerMachineryId = sellerMachineryId;
	// }

	public SellerMachineryDetails(Long sellerMachineryId, Machinery machineryId, UserDetails sellerId, int quantity,
			double price, String description, int availQuantity, String verified) {
		this.sellerMachineryId = sellerMachineryId;
		this.machineryId = machineryId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.availQuantity = availQuantity;
		this.verified = verified;
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

	public int getAvailQuantity() {
		return availQuantity;
	}

	public void setAvailQuantity(int availQuantity) {
		this.availQuantity = availQuantity;
	}
	
	public Long getSellerMachineryId() {
		return sellerMachineryId;
	}

	public void setSellerMachineryId(Long sellerMachineryId) {
		this.sellerMachineryId = sellerMachineryId;
	}
	
	public String isVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}
	/*	
	 * Commented to remove the relationship with orders table
		public List<OrderMachineDetails> getOrderMachineDetails() {
			return orderMachineDetails;
		}
		public void setOrderMachineDetails(List<OrderMachineDetails> orderMachineDetails) {
			this.orderMachineDetails = orderMachineDetails;
		}
		public List<OrderMachineDetails> getOrderMachineSellerDetails() {
			return orderMachineSellerDetails;
		}
		public void setOrderMachineSellerDetails(List<OrderMachineDetails> orderMachineSellerDetails) {
			this.orderMachineSellerDetails = orderMachineSellerDetails;
		}
	
		// -------------- Helper Methods for: --------------------
		public void addOrderMachineDetails(OrderMachineDetails machineDetails) {
			orderMachineDetails.add(machineDetails);
			machineDetails.setMachineId(this);
		}
		public void removeOrderMachineDetails(OrderMachineDetails machineDetails) {
			orderMachineDetails.remove(machineDetails);
			machineDetails.setSellerMachineryId(null);
		}
	 */
}
