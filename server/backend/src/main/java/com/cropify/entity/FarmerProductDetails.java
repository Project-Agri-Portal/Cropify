package com.cropify.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cropify.entity.enums.FarmProductsStatus;

@Entity
public class FarmerProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farmer_product_details_id")
	private Long farmerProductDetailsId;

	// Mapped with farm_products table
	@ManyToOne
	@JoinColumn(name = "farm_prod_id", nullable = false)
	private FarmProducts farmProductId;

	// Mapped with user_details table
	@ManyToOne	// owning
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;
	
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private double price;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private boolean verified;
	
	@Column(name = "harvest_date", nullable = false)
	private LocalDate harvestDate;
	
	@Column(name = "expiry_date", nullable = false)
	private LocalDate expiryDate;
	
	@Column(name = "farm_prod_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private FarmProductsStatus farmProductStatus;
	
	/* Commented to remove order table relationship
	// ------------ Relationship Mapping ------------------------------
	@OneToMany(mappedBy = "farmerProductDetails" ,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<OrderFarmProductDetails> orderFarmProductDetails= new ArrayList<OrderFarmProductDetails>();
	*/
	
	//-----------------------------Constructors--------------------
	public FarmerProductDetails(Long farmerProductDetailsId, FarmProducts farmProductId, UserDetails farmerId,
			int quantity, double price, String description, LocalDate harvestDate, LocalDate expiryDate,
			FarmProductsStatus farmProductStatus) {
		this.farmerProductDetailsId = farmerProductDetailsId;
		this.farmProductId = farmProductId;
		this.farmerId = farmerId;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.harvestDate = harvestDate;
		this.expiryDate = expiryDate;
		this.farmProductStatus = farmProductStatus;
	}
	
	public FarmerProductDetails() {
		super();
	}
	
	//-----------------------------Getter and Setters--------------------

	public FarmProducts getFarmProductId() {
		return farmProductId;
	}

	public void setFarmProductId(FarmProducts farmProductId) {
		this.farmProductId = farmProductId;
	}

	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
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

	public LocalDate getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(LocalDate harvestDate) {
		this.harvestDate = harvestDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public FarmProductsStatus getFarmProductStatus() {
		return farmProductStatus;
	}

	public void setFarmProductStatus(FarmProductsStatus farmProductStatus) {
		this.farmProductStatus = farmProductStatus;
	}

	public Long getFarmerProductDetailsId() {
		return farmerProductDetailsId;
	}

	public void setFarmerProductDetailsId(Long farmerProductDetailsId) {
		this.farmerProductDetailsId = farmerProductDetailsId;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/* Commented to remove order table relationship
	public List<OrderFarmProductDetails> getOrderFarmProductDetails() {
		return orderFarmProductDetails;
	}
	public void setOrderFarmProductDetails(List<OrderFarmProductDetails> orderFarmProductDetails) {
		this.orderFarmProductDetails = orderFarmProductDetails;
	}
	
	//-----------------------------Helper Methods--------------------
	
	public void addOrderFarmProductDetails(OrderFarmProductDetails orderDetails) {
		orderFarmProductDetails.add(orderDetails);
		orderDetails.setFarmerProductDetails(this);
	}
	
	public void removeOrderFarmProductDetails(OrderFarmProductDetails orderDetails) {
		orderFarmProductDetails.remove(orderDetails);
		orderDetails.setFarmerProductDetails(null);
	}
	*/
}
