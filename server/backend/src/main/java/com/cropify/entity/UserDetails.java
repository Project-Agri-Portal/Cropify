package com.cropify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cropify.entity.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	
	@Column(length = 50, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(name = "mobile_no", length = 10, nullable = false, unique = true)
	private String mobileNo;
	
	@Column(name = "user_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
//	@Column(nullable = false)
//	private String city;
//	@Column(nullable = false)
//	private String state;
//	@Column(nullable = false)
//	private String pincode;
//	@Column(nullable = false)
//	private String fullAddress;
	@Embedded
	private UserAddress userAddress;

	@Column(columnDefinition = "CHAR(12)", unique = true)
	private String aadharNo;
	@Column(columnDefinition = "CHAR(10)", unique = true)
	private String panNo;
	
//	if seller has poor review or if seller is fraud
//	in such cases Admin can/has ability to block seller
//	if status is "block" then seller cannot sell any products
	@Column
	private String status;
	
	// ------------ Relationship Mapping ------------------------------
	@JsonIgnore
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<FarmerProductDetails> farmerProductDetails = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SellerMachineryDetails> sellerMachineryDetails = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SellerAgricultureProductDetails> sellerAgricultureProductDetails = new ArrayList<>();
	
	// ----------------- Order Farm Product --------------------------
	@JsonIgnore
	@OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderFarmProductDetails> orderFarmProductCustomerDetails = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderFarmProductDetails> orderFarmProductFarmerDetails = new ArrayList<>();

	// ----------------- Order Machinery --------------------------
	@JsonIgnore
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderMachineDetails> orderMachineFarmerDetails = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderMachineDetails> orderMachineSellerDetails = new ArrayList<>();
	
	// ----------------- Order Agriculture Product --------------------------
	@JsonIgnore
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderAgricultureProductDetails> orderAgricultureProductFarmerDetails = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderAgricultureProductDetails> orderAgricultureProductSellerDetails = new ArrayList<>();
	
	// --------------- Cart Machinery --------------------
	@JsonIgnore
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartMachinery> cartMachineryFarmerList = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartMachinery> cartMachinerySellerList = new ArrayList<>();
	
	// --------------- Cart Agri Product -----------------
	@JsonIgnore
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartAgricultureProduct> cartAgriProdFarmerList = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartAgricultureProduct> cartAgriProdSellerList = new ArrayList<>();
	
	// --------------- Cart Farm Product -----------------
	@JsonIgnore
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartFarmProduct> cartFarmProdFarmerList = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartFarmProduct> cartFarmProdCustomerList = new ArrayList<>();
	
	//--------- Constructors -------------------------	
	public UserDetails() {}
	
	public UserDetails(Long id, String firstName, String lastName, String email, String password, String mobileNo,
			UserType userType, UserAddress userAddress, String aadharNo, String panNo, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.userType = userType;
		this.userAddress = userAddress;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.status = status;
	}

	// -------------- Helper Methods for: --------------------
	// -------------- 1) farmer product details ---------
	public void addFarmerProductDetails(FarmerProductDetails productDetails) {
		farmerProductDetails.add(productDetails);
		productDetails.setFarmerId(this);
	}
	public void removeFarmerProductDetails(FarmerProductDetails productDetails) {
		farmerProductDetails.remove(productDetails);
		productDetails.setFarmerId(null);
	}
	
	// -------------- 2) seller machinery details ---------
	public void addSellerMachineryDetails(SellerMachineryDetails productDetails) {
		sellerMachineryDetails.add(productDetails);
		productDetails.setSellerId(this);
	}
	public void removeSellerMachineryDetails(SellerMachineryDetails productDetails) {
		sellerMachineryDetails.remove(productDetails);
		productDetails.setSellerId(null);
	}
	
	// -------------- 3) seller agri product details ---------
	public void addSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.add(productDetails);
		productDetails.setSellerId(this);
	}
	public void removeSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.remove(productDetails);
		productDetails.setSellerId(null);
	}
	
	// -------------- 4) order farm product farmer-customer details ---------------
	public void addOrderFarmProductCustomerDetails(OrderFarmProductDetails productDetails) {
		orderFarmProductCustomerDetails.add(productDetails);
		productDetails.setCustomerId(this);
	}
	public void removeOrderFarmProductCustomerDetails(OrderFarmProductDetails productDetails) {
		orderFarmProductCustomerDetails.remove(productDetails);
		productDetails.setCustomerId(null);
	}
	public void addOrderFarmProductFarmerDetails(OrderFarmProductDetails productDetails) {
		orderFarmProductFarmerDetails.add(productDetails);
		productDetails.setFarmerId(this);
	}
	public void removeOrderFarmProductFarmerDetails(OrderFarmProductDetails productDetails) {
		orderFarmProductFarmerDetails.remove(productDetails);
		productDetails.setFarmerId(null);
	}
	
	// -------------- 5) order machine farmer-seller details ---------------
	public void addOrderMachineFarmerDetails(OrderMachineDetails machineDetails) {
		orderMachineFarmerDetails.add(machineDetails);
		machineDetails.setFarmerId(this);
	}
	public void removeOrderMachineFarmerDetails(OrderMachineDetails machineDetails) {
		orderMachineFarmerDetails.remove(machineDetails);
		machineDetails.setFarmerId(null);
	}
	public void addOrderMachineSellerDetails(OrderMachineDetails machineDetails) {
		orderMachineSellerDetails.add(machineDetails);
		machineDetails.setSellerId(this);
	}
	public void removeOrderMachineSellerDetails(OrderMachineDetails machineDetails) {
		orderMachineSellerDetails.remove(machineDetails);
		machineDetails.setSellerId(null);
	}
	
	// -------------- 6) order agri product farmer-seller details ---------------
	public void addOrderAgricultureProductFarmerDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductFarmerDetails.add(productDetails);
		productDetails.setFarmerId(this);
	}
	public void removeOrderAgricultureProductFarmerDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductFarmerDetails.remove(productDetails);
		productDetails.setFarmerId(null);
	}
	public void addOrderAgricultureProductSellerDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductSellerDetails.add(productDetails);
		productDetails.setSellerId(this);
	}
	public void removeOrderAgricultureProductSellerDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductSellerDetails.remove(productDetails);
		productDetails.setSellerId(null);
	}
	
	// ---------------- Cart Machinery -----------------------------
	// -------------- 1) farmer details ---------------
	public void addCartMachineryFarmerList(CartMachinery farmer) {
		cartMachineryFarmerList.add(farmer);
		farmer.setFarmerId(this);
	}
	public void removeCartMachineryFarmerList(CartMachinery farmer) {
		cartMachineryFarmerList.remove(farmer);
		farmer.setFarmerId(null);
	}
	// -------------- 2) seller details ---------------
	public void addCartMachinerySellerList(CartMachinery seller) {
		cartMachinerySellerList.add(seller);
		seller.setSellerId(this);
	}
	public void removeCartMachinerySellerList(CartMachinery seller) {
		cartMachinerySellerList.remove(seller);
		seller.setSellerId(null);
	}
	// ---------------------------------------------------------------
	
	// ---------------- Cart Agriculture Product -----------------------------
	// -------------- 1) farmer details ---------------
	public void addCartAgricultureProductFarmerList(CartAgricultureProduct farmer) {
		cartAgriProdFarmerList.add(farmer);
		farmer.setFarmerId(this);
	}
	public void removeCartAgricultureProductFarmerList(CartAgricultureProduct farmer) {
		cartAgriProdFarmerList.remove(farmer);
		farmer.setFarmerId(null);
	}
	// -------------- 2) seller details ---------------
	public void addCartAgricultureProductSellerList(CartAgricultureProduct seller) {
		cartAgriProdSellerList.add(seller);
		seller.setSellerId(this);
	}
	public void removeCartAgricultureProductSellerList(CartAgricultureProduct seller) {
		cartAgriProdSellerList.remove(seller);
		seller.setSellerId(null);
	}
	// ---------------------------------------------------------------
	
	// ---------------- Cart Farmer Product -----------------------------
	// -------------- 1) farmer details ---------------
	public void addCartFarmProdFarmerList(CartFarmProduct farmer) {
		cartFarmProdFarmerList.add(farmer);
		farmer.setFarmerId(this);
	}
	public void removeCartFarmProdFarmerList(CartFarmProduct farmer) {
		cartFarmProdFarmerList.remove(farmer);
		farmer.setFarmerId(null);
	}
	// -------------- 2) customer details ---------------
	public void addCartFarmProdCustomerList(CartFarmProduct customer) {
		cartFarmProdCustomerList.add(customer);
		customer.setCustomerId(this);
	}
	public void removeCartFarmProdCustomerList(CartFarmProduct customer) {
		cartFarmProdCustomerList.remove(customer);
		customer.setCustomerId(null);
	}
	// ---------------------------------------------------------------
}
