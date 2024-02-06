package com.cropify.entity;

import java.time.LocalDate;

public class OrderAgricultureProductDetails {
	private Long farmerId;
	private Long sellerId;
	private Long agricultureProductId;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;
}
