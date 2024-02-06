package com.cropify.entity;

import java.time.LocalDate;

public class OrderFarmProductDetails {
	private Long farmerId;
	private Long customerId;
	private Long farmProductId;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;
	private FarmOrderStatus farmOrderStatus;
}
