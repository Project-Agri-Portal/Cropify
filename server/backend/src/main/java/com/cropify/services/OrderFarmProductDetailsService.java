package com.cropify.services;

public interface OrderFarmProductDetailsService {
    String addFarmProductToCart(Long farmerId, double totalPrice);
}
