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
	
	@Column(length = 50, nullable = false, unique = true)
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
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<FarmerProductDetails> farmerProductDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SellerMachineryDetails> sellerMachineryDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SellerAgricultureProductDetails> sellerAgricultureProductDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderFarmProductDetails> orderFarmProductDetails = new ArrayList<>();

	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderAgricultureProductDetails> orderAgricultureProductDetails = new ArrayList<>();
	
	// --------------- Cart Machinery --------------------
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartMachinery> cartMachineryFarmerList = new ArrayList<>();
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartMachinery> cartMachinerySellerList = new ArrayList<>();
	
	// --------------- Cart Agri Product -----------------
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartAgricultureProduct> cartAgriProdFarmerList = new ArrayList<>();
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartAgricultureProduct> cartAgriProdSellerList = new ArrayList<>();
	
	// --------------- Cart Farm Product -----------------
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartFarmProduct> cartFarmProdFarmerList = new ArrayList<>();
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
	
	// -------------- 4) order agriculture product details ---------
	public void addOrderAgricultureProductDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductDetails.add(productDetails);
		productDetails.setFarmerId(this);
	}
	public void removeOrderAgricultureProductDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductDetails.remove(productDetails);
		productDetails.setFarmerId(null);
	}
	
	// -------------- 5) order farm product details ---------------
	public void addOrderFarmProductDetails(OrderFarmProductDetails productDetails) {
		orderFarmProductDetails.add(productDetails);
		productDetails.setCustomerId(this);
	}
	public void removeOrderFarmProductDetails(OrderFarmProductDetails productDetails) {
		orderFarmProductDetails.remove(productDetails);
		productDetails.setCustomerId(null);
	}
	
	// -------------- 6) order machine details ---------------
	public void addOrderMachineDetails(OrderMachineDetails machineDetails) {
		orderMachineDetails.add(machineDetails);
		machineDetails.setFarmerId(this);
	}
	public void removeOrderMachineDetails(OrderMachineDetails machineDetails) {
		orderMachineDetails.remove(machineDetails);
		machineDetails.setFarmerId(null);
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
		seller.setFarmerId(this);
	}
	public void removeCartMachinerySellerList(CartMachinery seller) {
		cartMachinerySellerList.remove(seller);
		seller.setFarmerId(null);
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
